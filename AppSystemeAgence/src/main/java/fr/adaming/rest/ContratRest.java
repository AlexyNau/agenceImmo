package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Contrat;
import fr.adaming.service.IContratService;

@RestController
public class ContratRest {

	@Autowired
	private IContratService contratService;

	@RequestMapping(value = "/listeContrat", method = RequestMethod.GET, produces = "application/json")
	public List<Contrat> getAllContrat() {
		return contratService.getAllContrats();
	}

	@RequestMapping(value = "/contrat/{pId}", method = RequestMethod.GET, produces = "application/json")
	public Contrat getContratById(@PathVariable("pId") int id) {
		return contratService.getContratById(id);
	}

	@RequestMapping(value = "/addContrat", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public Contrat addContrat(@RequestBody Contrat contrat) {
		return contratService.addContrat(contrat);
	}

	@RequestMapping(value = "/modifierContrat", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public Contrat updateContrat(@RequestBody Contrat contrat) {
		return contratService.updateContrat(contrat);
	}

	@RequestMapping(value = "/deleteContrat/{pId}", method = RequestMethod.DELETE)
	public void deleteContrat(@PathVariable("pId") int id) {
		contratService.deleteContrat(id);
	}
}
