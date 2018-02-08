package fr.adaming.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClasseStdDao;
import fr.adaming.dao.ILocationDao;
import fr.adaming.dao.IProprietaireDao;
import fr.adaming.model.ClasseStd;
import fr.adaming.model.Location;
import fr.adaming.model.Proprietaire;

@Service
@Transactional
public class LocationServiceImpl implements ILocationServiceImpl {

	@Autowired
	private ILocationDao locDao;

	@Autowired
	private IClasseStdDao classeDao;
	
	@Autowired
	private IProprietaireDao proprioDao;

	public void setLocDao(ILocationDao locDao) {
		this.locDao = locDao;
	}

	@Override
	public List<Location> getAllLocation() {
		return locDao.getAllLocation();
	}

	@Override
	public Location getLocationById(int idLoc) {
		return locDao.getLocationById(idLoc);
	}

	@Override
	public Location updateLocation(Location loc) {
		// calculer le revenu cadastral
		double revenuCadastral = loc.getLoyer() * 12 - (loc.getLoyer() * 12 * 40 / 100);
		loc.setRevenuCadastral(revenuCadastral);
		return locDao.updateLocation(loc);
	}

	@Override
	public Location addLocation(Location loc, String typeBien, int idProprio) {
		// r�cup�rer toutes les classes std
		List<ClasseStd> listClasses = classeDao.getAllClassesStd();
		List<ClasseStd> listIn = new ArrayList<ClasseStd>();

		// parcourir la liste de classe pour ne garder que les classes
		// correspondant au type de bien vendu
		for (ClasseStd element : listClasses) {
			if (element.getType_bien().equals(typeBien) && element.getMode_offre().equals("location")) {
				listIn.add(element);
			}
		}

		// r�cup�ration de la classe correspondant au bien
		ClasseStd classe = new ClasseStd();

		double loyerTotal = loc.getLoyer() + loc.getCharges();

		for (ClasseStd element : listIn) {
			if (loyerTotal <= element.getPrix_max() && loc.getSuperficie() >= element.getSup_min()) {
				classe = element;
			}
		}

		// faire le lien entre la classe std et la location
		loc.setClasseStd(classe);

		// initialiser par d�faut le statut � disponible
		loc.setStatut("disponible");

		// calculer le revenu cadastral
		double revenuCadastral = loc.getLoyer() * 12 - (loc.getLoyer() * 12 * 40 / 100);
		loc.setRevenuCadastral(revenuCadastral);

		//r�cup�ration du proprio
		Proprietaire proprio = proprioDao.getProprioById(idProprio);
		
		//ajout du proprio dans la location
		loc.setProprietaire(proprio);
		
		return locDao.addLocation(loc);
	}

	@Override
	public int deleteLocation(int idLoc) {
		return locDao.deleteLocation(idLoc);
	}

	@Override
	public List<Location> getLocationsByClasseStd(ClasseStd classe) {
		return locDao.getLocationsByClasseStd(classe);
	}

}
