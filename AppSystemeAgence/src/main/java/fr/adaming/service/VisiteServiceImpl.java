package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;
import fr.adaming.dao.ILocationDao;
import fr.adaming.dao.IVenteDao;
import fr.adaming.dao.IVisiteDao;
import fr.adaming.model.Client;
import fr.adaming.model.Location;
import fr.adaming.model.Vente;
import fr.adaming.model.Visite;

@Service
@Transactional
public class VisiteServiceImpl implements IVisiteService {

	@Autowired
	private IVisiteDao visiteDao;
	
	@Autowired
	private IClientDao clientDao;
	
	@Autowired
	private ILocationDao locationDao;
	
	@Autowired
	private IVenteDao venteDao;

	@Override
	public Visite getVisiteById(int id) {

		return visiteDao.getVisiteById(id);
	}

	@Override
	public Visite addVisite(Visite visite,int idClient,int idLocation,int idVente) {
		
		Client client = clientDao.getClientById(idClient);
		Location location=locationDao.getLocationById(idLocation);
		Vente vente=venteDao.getVenteById(idVente);
		
		visite.setClient(client);
		visite.setLocation(location);
		visite.setVente(vente);
		
		return visiteDao.addVisite(visite);
	}

	@Override
	public Visite updateVisite(Visite visite) {

		return visiteDao.updateVisite(visite);
	}

	@Override
	public List<Visite> getAllVisites() {

		return visiteDao.getAllVisites();
	}

	@Override
	public void deleteVisite(int id) {
		visiteDao.deleteVisite(id);

	}

}
