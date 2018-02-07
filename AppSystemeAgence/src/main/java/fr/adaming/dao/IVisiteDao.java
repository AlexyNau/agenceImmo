package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Visite;

public interface IVisiteDao {

public Visite getVisiteById(int id);
	
	public Visite addVisite(Visite visite);
	
	public Visite updateVisite(Visite visite);
	
	public List<Visite> getAllVisites();
	
	public void deleteVisite(int id);
	
}
