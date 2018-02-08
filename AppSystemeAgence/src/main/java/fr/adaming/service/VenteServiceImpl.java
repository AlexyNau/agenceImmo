package fr.adaming.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClasseStdDao;
import fr.adaming.dao.IProprietaireDao;
import fr.adaming.dao.IVenteDao;
import fr.adaming.model.ClasseStd;
import fr.adaming.model.Proprietaire;
import fr.adaming.model.Vente;

@Service
@Transactional
public class VenteServiceImpl implements IVenteService {

	@Autowired
	private IVenteDao venteDao;

	@Autowired
	private IClasseStdDao classeDao;
	
	@Autowired
	private IProprietaireDao proprioDao;

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
		// calculer le revenu cadastral
		double revenuCadastral = (vente.getPrixAchat() * 12 / 10000) - (vente.getPrixAchat() * 12 / 10000) * 40 / 100;
		vente.setRevenuCadastral(revenuCadastral);
		
		return venteDao.updateVente(vente);
	}

	@Override
	public Vente addVente(Vente vente, String typeBien, int idProprio) {
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

		// faire le lien entre la classe std et la vente
		vente.setClasseStd(classe);

		// initialiser par défaut le statut à disponible
		vente.setStatut("disponible");

		// calculer le revenu cadastral
		double revenuCadastral = (vente.getPrixAchat() * 12 / 10000) - (vente.getPrixAchat() * 12 / 10000) * 40 / 100;
		vente.setRevenuCadastral(revenuCadastral);
		
		//récupération du propriétaire
		Proprietaire proprio = proprioDao.getProprioById(idProprio);
		
		//ajout du propriétaire dans la vente
		vente.setProprietaire(proprio);

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
