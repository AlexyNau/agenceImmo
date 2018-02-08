package fr.adaming.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Conseiller;
import fr.adaming.service.IConseillerService;

@RestController
public class ConseillerRest {

	@Autowired
	private IConseillerService conseillerService;
	
	
	@RequestMapping(value = "/logConseiller/{pMail}/{pMdp}", method = RequestMethod.GET, produces = "application/json")
	public Conseiller logConseiller(@PathVariable("pMail") String mail,@PathVariable("pMdp") String mdp) {
		Conseiller c = conseillerService.isExist(mail, mdp);
		
		System.out.println(c);
		c.setVisites(null);
		return c;
	}
	
}
