package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.ClasseStd;

public interface IClasseStdDao {
	
	public ClasseStd updateClasseStd(ClasseStd classe);
	
	public List<ClasseStd> getAllClassesStd();
	
	public ClasseStd getClasseStdById(int id);

}
