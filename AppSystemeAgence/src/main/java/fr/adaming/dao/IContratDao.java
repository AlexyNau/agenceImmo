package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Contrat;

public interface IContratDao {

	public List<Contrat> getAllContrats();

	public Contrat getContratById(int id);

	public Contrat addContrat(Contrat contrat);

	public Contrat updateContrat(Contrat contrat);

	public void deleteContrat(int id);
	
}
