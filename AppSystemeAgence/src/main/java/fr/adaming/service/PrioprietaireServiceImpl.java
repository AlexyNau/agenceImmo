package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IProprietaireDao;
import fr.adaming.model.Location;
import fr.adaming.model.Proprietaire;

@Service
@Transactional
public class PrioprietaireServiceImpl implements IProprietaireService {

	@Autowired
	private IProprietaireDao proprioDao;
	
	
	@Override
	public List<Proprietaire> getAllProprio() {
		
		return proprioDao.getAllProprio();
	}

	@Override
	public Proprietaire getProprioById(int id) {
		
		return proprioDao.getProprioById(id);
	}

	@Override
	public Proprietaire addProprio(Proprietaire p) {
		
		return proprioDao.addProprio(p);
	}

	@Override
	public Proprietaire updateProprio(Proprietaire p) {
		
		return proprioDao.updateProprio(p);
	}

	@Override
	public void deleteProprio(int id) {
		proprioDao.deleteProprio(id);

	}

	@Override
	public List<Location> getBiensProprioById(int id) {
		// TODO Auto-generated method stub
		return proprioDao.getLocationsProprioById(id);
	}

}
