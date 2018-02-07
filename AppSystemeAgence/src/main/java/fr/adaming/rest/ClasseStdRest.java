package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.ClasseStd;
import fr.adaming.service.IClasseStdService;

@RestController
public class ClasseStdRest {
	
	@Autowired
	private IClasseStdService classeService;
	
	@RequestMapping(value="/listeClasses", method=RequestMethod.GET, produces = "application/json")
	public List<ClasseStd> getAllClassesStd() {
		return classeService.getAllClassesStd();
	}
	
	@RequestMapping(value="/classe", method=RequestMethod.GET, produces = "application/json")
	public ClasseStd getClasseStdById(@RequestParam("pId")int id) {
		return classeService.getClasseStdById(id);
	}
	
	@RequestMapping(value="/classe", method=RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public ClasseStd updateClasseStd(@RequestBody ClasseStd classe) {
		return classeService.updateClasseStd(classe);
	}

}
