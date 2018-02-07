package fr.adaming.service;

import java.util.List;

import fr.adaming.model.ClasseStd;
import fr.adaming.model.Vente;

public interface IVenteService {
	
	public List<Vente> getAllVente();

	public Vente getVenteById(int idVente);
	
	public Vente updateVente(Vente vente);
	
	public Vente addVente(Vente vente, String typeBien);
	
	public int deleteVente(int idVente);
	
	public List<Vente> getVentesByClasseStd(ClasseStd classe);

}
