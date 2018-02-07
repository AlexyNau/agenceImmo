package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Client;
import fr.adaming.service.IClientService;

@RestController
public class ClientRest {

	@Autowired
	private IClientService clientService;
	
	
	@RequestMapping(value = "/listeClient", method = RequestMethod.GET, produces = "application/json")
	public List<Client> getAllClient() {
		return clientService.getAllClient();
	}

	@RequestMapping(value = "/client/{pId}", method = RequestMethod.GET, produces = "application/json")
	public Client getClientById(@PathVariable("pId") int id) {
		return clientService.getClientById(id);
	}

	@RequestMapping(value = "/addClient", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public Client addClient(@RequestBody Client c) {
		return clientService.addClient(c);
	}

	@RequestMapping(value = "/modifierClient", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public Client updateClient(@RequestBody Client c) {
		return clientService.updateClient(c);
	}

	@RequestMapping(value = "/deleteClient/{pId}", method = RequestMethod.DELETE)
	public void deleteClient(@PathVariable("pId") int id) {
		clientService.deleteClient(id);
	}
	
	@RequestMapping(value = "/logClient/{pMail}/{pMdp}", method = RequestMethod.GET, produces = "application/json")
	public Client logClient(@PathVariable("pMail") String mail,@PathVariable("pMdp") String mdp) {
		return clientService.isExiste(mail, mdp);
	}

}
