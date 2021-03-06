package fr.adaming.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;
import fr.adaming.dao.IContratDao;
import fr.adaming.dao.ILocationDao;
import fr.adaming.dao.IVenteDao;
import fr.adaming.model.Client;
import fr.adaming.model.Contrat;
import fr.adaming.model.Location;
import fr.adaming.model.Vente;

@Service
@Transactional
public class ContratServiceImpl implements IContratService {

	@Autowired
	private IContratDao contratDao;
	
	@Autowired
	private IClientDao clientDao;
	
	@Autowired
	private ILocationDao locDao;
	
	@Autowired
	private IVenteDao venteDao;

	@Override
	public List<Contrat> getAllContratsVente() {
		List<Contrat> listOut = contratDao.getAllContrats();
		List<Contrat> listIn = new ArrayList<Contrat>();
		
		for (Contrat element : listOut) {
			if (element.getVente()!=null) {
				listIn.add(element);
			}
		}
		

		return listIn;
	}
	
	@Override
	public List<Contrat> getAllContratsLocation() {
		List<Contrat> listOut = contratDao.getAllContrats();
		List<Contrat> listIn = new ArrayList<Contrat>();
		
		for (Contrat element : listOut) {
			if (element.getLocation()!=null) {
				listIn.add(element);
			}
		}
		

		return listIn;
	}

	@Override
	public Contrat getContratById(int id) {

		return contratDao.getContratById(id);
	}

	@Override
	public Contrat addContratLocation(Contrat contrat, int idClient, int idLocation) {
		Client client = clientDao.getClientById(idClient);
		Location loc = locDao.getLocationById(idLocation);
		
		contrat.setVente(null);
		contrat.setClient(client);
		contrat.setLocation(loc);
		loc.setStatut("loue");
		
		double prixAvecRemise = (loc.getLoyer()+loc.getCharges())*(1-(loc.getRemise()/100));
		contrat.setPrix(prixAvecRemise);
		
		return contratDao.addContrat(contrat);
	}
	
	@Override
	public Contrat addContratVente(Contrat contrat, int idClient, int idVente) {
		Client client = clientDao.getClientById(idClient);
		Vente vente = venteDao.getVenteById(idVente);
		
		contrat.setLocation(null);
		contrat.setClient(client);
		contrat.setVente(vente);
		
		double prixAvecRemise = vente.getPrixAchat() * (1-(vente.getRemise()/100));
		contrat.setPrix(prixAvecRemise);

		return contratDao.addContrat(contrat);
	}

	@Override
	public Contrat updateContrat(Contrat contrat) {

		return contratDao.updateContrat(contrat);
	}

	@Override
	public void deleteContrat(int id) {
		contratDao.deleteContrat(id);

	}

}
