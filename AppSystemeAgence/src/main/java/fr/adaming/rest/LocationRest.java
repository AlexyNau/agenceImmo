package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.ClasseStd;
import fr.adaming.model.Location;
import fr.adaming.service.IClasseStdService;
import fr.adaming.service.ILocationServiceImpl;

@RestController
public class LocationRest {

	@Autowired
	private ILocationServiceImpl locService;
	
	@Autowired
	private IClasseStdService classeService;

	@RequestMapping(value="/listeLocations", method = RequestMethod.GET, produces = "application/json")
	public List<Location> getAllLocation() {
		return locService.getAllLocation();
	}

	@RequestMapping(value="/location", method = RequestMethod.GET, produces = "application/json")
	public Location getLocationById(@RequestParam("pIdLoc")int idLoc){
		return locService.getLocationById(idLoc);
	}

	@RequestMapping(value="/location", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public Location updateLocation(@RequestBody Location loc) {
		return locService.updateLocation(loc);
	}

	@RequestMapping(value="/location", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public Location addLocation(@RequestBody Location loc) {
		return locService.addLocation(loc, loc.getClasseStd().getType_bien(), loc.getProprietaire().getId());
	}

	@RequestMapping(value="/location", method=RequestMethod.DELETE)
	public int deleteLocation(@RequestParam("pIdLoc")int idLoc) {
		return locService.deleteLocation(idLoc);
	}

	@RequestMapping(value="/listeLocationsByClasse", method = RequestMethod.GET, produces = "application/json")
	public List<Location> getLocationsByClasseStd(@RequestParam("pIdClasse")int idClasse){
		ClasseStd classe = classeService.getClasseStdById(idClasse);
		return locService.getLocationsByClasseStd(classe);

	}

}
