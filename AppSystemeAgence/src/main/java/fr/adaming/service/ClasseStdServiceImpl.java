package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClasseStdDao;
import fr.adaming.model.ClasseStd;

@Service
@Transactional
public class ClasseStdServiceImpl implements IClasseStdService{

	@Autowired
	private IClasseStdDao classeDao;
	
	public void setClasseDao(IClasseStdDao classeDao) {
		this.classeDao = classeDao;
	}

	@Override
	public ClasseStd updateClasseStd(ClasseStd classe) {
		return classeDao.updateClasseStd(classe);
	}

	@Override
	public List<ClasseStd> getAllClassesStd() {
		return classeDao.getAllClassesStd();
	}

	@Override
	public ClasseStd getClasseStdById(int id) {
		return classeDao.getClasseStdById(id);
	}

}
