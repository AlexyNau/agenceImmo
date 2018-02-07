package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Proprietaire;
import fr.adaming.service.IProprietaireService;

@RestController
public class ProprietaireRest {

	@Autowired
	private IProprietaireService proprioService;
	

	@RequestMapping(value = "/listeProprietaire", method = RequestMethod.GET, produces = "application/json")
	public List<Proprietaire> getAllProprio() {
		return proprioService.getAllProprio();
	}

	@RequestMapping(value = "/proprietaire/{pId}", method = RequestMethod.GET, produces = "application/json")
	public Proprietaire getProprioById(@PathVariable("pId") int id) {
		return proprioService.getProprioById(id);
	}

	@RequestMapping(value = "/addProprietaire", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public Proprietaire addProprio(@RequestBody Proprietaire p) {
		return proprioService.addProprio(p);
	}

	@RequestMapping(value = "/modifierProprietaire", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public Proprietaire updateProprio(@RequestBody Proprietaire p) {
		return proprioService.updateProprio(p);
	}

	@RequestMapping(value = "/deleteProprietaire/{pId}", method = RequestMethod.DELETE)
	public void deleteProprio(@PathVariable("pId") int id) {
		proprioService.deleteProprio(id);
	}

}

