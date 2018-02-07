package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.ClasseStd;
import fr.adaming.model.Vente;
import fr.adaming.service.IClasseStdService;
import fr.adaming.service.IVenteService;

@RestController
public class VenteRest {
	
	@Autowired
	private IVenteService venteService;
	
	
	@Autowired
	private IClasseStdService classeService;
	
	@RequestMapping(value="/listeVentes", method = RequestMethod.GET, produces = "application/json")
	public List<Vente> getAllVente() {
		return venteService.getAllVente();
	}

	@RequestMapping(value="/vente", method = RequestMethod.GET, produces = "application/json")
	public Vente getVenteById(@RequestParam("pIdVente")int idVente) {
		return venteService.getVenteById(idVente);
	}
	
	@RequestMapping(value="/vente", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public Vente updateVente(@RequestBody Vente vente) {
		return venteService.updateVente(vente);
	}
	
	@RequestMapping(value="/vente", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public Vente addVente(@RequestBody Vente vente) {
		return venteService.addVente(vente, vente.getClasseStd().getType_bien());
	}
	
	@RequestMapping(value="/vente", method=RequestMethod.DELETE)
	public int deleteVente(@RequestParam("pIdVente")int idVente) {
		return venteService.deleteVente(idVente);
	}
	
	@RequestMapping(value="/listeVentesByClasse", method = RequestMethod.GET, produces = "application/json")
	public List<Vente> getVentesByClasseStd(@RequestParam("pIdClasse")int idClasse) {
		ClasseStd classe = classeService.getClasseStdById(idClasse);
		return venteService.getVentesByClasseStd(classe);
	}

}
