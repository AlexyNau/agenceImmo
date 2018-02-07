package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IVisiteDao;
import fr.adaming.model.Visite;

@Service
@Transactional
public class VisiteServiceImpl implements IVisiteService {

	@Autowired
	private IVisiteDao visiteDao;

	@Override
	public Visite getVisiteById(int id) {

		return visiteDao.getVisiteById(id);
	}

	@Override
	public Visite addVisite(Visite visite) {

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
