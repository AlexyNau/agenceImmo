package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Proprietaire;
import fr.adaming.model.Visite;
import fr.adaming.service.IVisiteService;

@RestController
public class VisiteRest {
	
	@Autowired
	private IVisiteService visiteService;
	
	
	@RequestMapping(value = "/listeVisite", method = RequestMethod.GET, produces = "application/json")
	public List<Visite> getAllVisite() {
		return visiteService.getAllVisites();
	}

	@RequestMapping(value = "/visite/{pId}", method = RequestMethod.GET, produces = "application/json")
	public Visite getVisiteById(@PathVariable("pId") int id) {
		return visiteService.getVisiteById(id);
	}
	
	@RequestMapping(value = "/addVisite", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public Visite addVisite(@RequestBody Visite visite) {
		return visiteService.addVisite(visite,visite.getClient().getId(),visite.getLocation().getId(),visite.getVente().getId());
	}
	
	@RequestMapping(value = "/modifierVisite", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public Visite updateVisite(@RequestBody Visite visite) {
		return visiteService.updateVisite(visite);
	}
	
	@RequestMapping(value = "/deleteVisite/{pId}", method = RequestMethod.DELETE)
	public void deleteVisite(@PathVariable("pId") int id) {
		visiteService.deleteVisite(id);
	}
}
