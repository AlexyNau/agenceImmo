package fr.adaming.service;

import java.util.List;

import fr.adaming.model.ClasseStd;

public interface IClasseStdService {

	public ClasseStd updateClasseStd(ClasseStd classe);

	public List<ClasseStd> getAllClassesStd();

	public ClasseStd getClasseStdById(int id);

}
