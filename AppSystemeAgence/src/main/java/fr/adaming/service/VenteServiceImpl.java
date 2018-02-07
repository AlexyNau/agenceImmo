package fr.adaming.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClasseStdDao;
import fr.adaming.dao.IVenteDao;
import fr.adaming.model.ClasseStd;
import fr.adaming.model.Vente;

@Service
@Transactional
public class VenteServiceImpl implements IVenteService {

	@Autowired
	private IVenteDao venteDao;

	@Autowired
	private IClasseStdDao classeDao;

	public void setVenteDao(IVenteDao venteDao) {
		this.venteDao = venteDao;
	}

	@Override
	public List<Vente> getAllVente() {
		return venteDao.getAllVente();
	}

	@Override
	public Vente getVenteById(int idVente) {
		return venteDao.getVenteById(idVente);
	}

	@Override
	public Vente updateVente(Vente vente) {
		return venteDao.updateVente(vente);
	}

	@Override
	public Vente addVente(Vente vente, String typeBien) {
		// récupérer toutes les classes std
		List<ClasseStd> listClasses = classeDao.getAllClassesStd();
		List<ClasseStd> listIn = new ArrayList<ClasseStd>();

		// parcourir la liste de classe pour ne garder que les classes
		// correspondant au type de bien vendu
		for (ClasseStd element : listClasses) {
			if (element.getType_bien().equals(typeBien) && element.getMode_offre().equals("vente")) {
				listIn.add(element);
			}
		}

		// récupération de la classe correspondant au bien
		ClasseStd classe = new ClasseStd();

		for (ClasseStd element : listIn) {
			if (vente.getPrixAchat() <= element.getPrix_max() && vente.getSuperficie() >= element.getSup_min()) {
				classe = element;
			}
		}
		
		//faire le lien entre la classe std et la vente
		vente.setClasseStd(classe);

		return venteDao.addVente(vente);
	}

	@Override
	public int deleteVente(int idVente) {
		return venteDao.deleteVente(idVente);
	}

	@Override
	public List<Vente> getVentesByClasseStd(ClasseStd classe) {
		return venteDao.getVentesByClasseStd(classe);
	}

}
