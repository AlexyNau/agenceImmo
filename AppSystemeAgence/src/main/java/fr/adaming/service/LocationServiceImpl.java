package fr.adaming.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClasseStdDao;
import fr.adaming.dao.ILocationDao;
import fr.adaming.model.ClasseStd;
import fr.adaming.model.Location;

@Service
@Transactional
public class LocationServiceImpl implements ILocationServiceImpl {

	@Autowired
	private ILocationDao locDao;

	@Autowired
	private IClasseStdDao classeDao;

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
		return locDao.updateLocation(loc);
	}

	@Override
	public Location addLocation(Location loc, String typeBien) {
		// récupérer toutes les classes std
		List<ClasseStd> listClasses = classeDao.getAllClassesStd();
		List<ClasseStd> listIn = new ArrayList<ClasseStd>();

		// parcourir la liste de classe pour ne garder que les classes
		// correspondant au type de bien vendu
		for (ClasseStd element : listClasses) {
			if (element.getType_bien().equals(typeBien) && element.getMode_offre().equals("location")) {
				listIn.add(element);
			}
		}

		// récupération de la classe correspondant au bien
		ClasseStd classe = new ClasseStd();
		
		double loyerTotal = loc.getLoyer() + loc.getCharges();

		for (ClasseStd element : listIn) {
			if (loyerTotal <= element.getPrix_max() && loc.getSuperficie() >= element.getSup_min()) {
				classe = element;
			}
		}
		
		//faire le lien entre la classe std et la location
		loc.setClasseStd(classe);
		
		
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
