package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Client;

public interface IClientDao {

	public List<Client> getAllClient();

	public Client getClientById(int id);

	public Client addClient(Client c);

	public Client updateClient(Client c);

	public void deleteClient(int id);
	
}
