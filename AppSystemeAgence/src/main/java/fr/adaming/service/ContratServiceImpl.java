package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;
import fr.adaming.dao.IContratDao;
import fr.adaming.dao.ILocationDao;
import fr.adaming.dao.IVenteDao;
import fr.adaming.model.Contrat;

@Service
@Transactional
public class ContratServiceImpl implements IContratService {

	@Autowired
	private IContratDao contratDao;
	
	@Autowired
	private IClientDao clientDao;
	
	@Autowired
	private ILocationDao locDao;
	
	private IVenteDao venteDao;

	@Override
	public List<Contrat> getAllContrats() {

		return contratDao.getAllContrats();
	}

	@Override
	public Contrat getContratById(int id) {

		return contratDao.getContratById(id);
	}

	@Override
	public Contrat addContratLocation(Contrat contrat, int idClient, int idLocation) {

		return contratDao.addContrat(contrat);
	}
	
	@Override
	public Contrat addContratVente(Contrat contrat, int idClient, int idVente) {

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
