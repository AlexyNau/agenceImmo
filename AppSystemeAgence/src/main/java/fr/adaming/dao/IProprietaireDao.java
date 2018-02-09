package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Location;
import fr.adaming.model.Proprietaire;

public interface IProprietaireDao {

	public List<Proprietaire> getAllProprio();

	public Proprietaire getProprioById(int id);

	public Proprietaire addProprio(Proprietaire p);

	public Proprietaire updateProprio(Proprietaire p);
	
	public List<Location> getLocationsProprioById(int id);

	public void deleteProprio(int id);
	
}
