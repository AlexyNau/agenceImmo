package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import fr.adaming.service.IJoinTableService;

@RestController
public class JoinTableRest {

	@Autowired
	private IJoinTableService joinService;
	
	@RequestMapping(value="/listeClasseStd/{pId}", method = RequestMethod.GET, produces = "application/json")
	public List<Integer> getIdClasseOfClientInteresse(@PathVariable("pId") int idClient) {
		return joinService.getIdClasseOfClientInteresse(idClient);
	}
	
	
}
