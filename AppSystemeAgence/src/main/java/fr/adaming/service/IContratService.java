package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Contrat;

public interface IContratService {

	public List<Contrat> getAllContrats();

	public Contrat getContratById(int id);

	public Contrat addContratLocation(Contrat contrat, int idClient, int idLocation);
	
	public Contrat addContratVente(Contrat contrat, int idClient, int idVente);

	public Contrat updateContrat(Contrat contrat);

	public void deleteContrat(int id);
}
