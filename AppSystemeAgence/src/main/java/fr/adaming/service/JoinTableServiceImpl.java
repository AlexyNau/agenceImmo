package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IJoinTableDao;

@Service
@Transactional
public class JoinTableServiceImpl implements IJoinTableService{

	@Autowired
	private IJoinTableDao joinDao;

	@Override
	public List<Integer> getIdClasseOfClientInteresse(int idClient) {
	
		return joinDao.getIdClasseOfClientInteresse(idClient);
	}
	
}
