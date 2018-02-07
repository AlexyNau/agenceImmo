package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IContratDao;
import fr.adaming.model.Contrat;

@Service
@Transactional
public class ContratServiceImpl implements IContratService {

	@Autowired
	private IContratDao contratDao;

	@Override
	public List<Contrat> getAllContrats() {

		return contratDao.getAllContrats();
	}

	@Override
	public Contrat getContratById(int id) {

		return contratDao.getContratById(id);
	}

	@Override
	public Contrat addContrat(Contrat contrat) {

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
