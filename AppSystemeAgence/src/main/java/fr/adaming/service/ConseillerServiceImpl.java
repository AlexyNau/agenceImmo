package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IConseillerDao;
import fr.adaming.model.Conseiller;

@Service
@Transactional
public class ConseillerServiceImpl implements IConseillerService{

	@Autowired
	private IConseillerDao conseillerDao;
	
	@Override
	public Conseiller isExist(String mail, String mdp) {
		
		return conseillerDao.isExist(mail, mdp);
	}

}
