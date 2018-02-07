package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.ClasseStd;
import fr.adaming.model.Vente;

public interface IVenteDao {
	
	public List<Vente> getAllVente();

	public Vente getVenteById(int idVente);
	
	public Vente updateVente(Vente vente);
	
	public Vente addVente(Vente vente);
	
	public int deleteVente(int idVente);
	
	public List<Vente> getVentesByClasseStd(ClasseStd classe);

}
