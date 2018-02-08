package fr.adaming.service;

import java.util.List;

import fr.adaming.model.ClasseStd;
import fr.adaming.model.Location;

public interface ILocationServiceImpl {
	
	public List<Location> getAllLocation();

	public Location getLocationById(int idLoc);
	
	public Location updateLocation(Location loc);
	
	public Location addLocation(Location loc, String typeBien, int idProprio);
	
	public int deleteLocation(int idLoc);
	
	public List<Location> getLocationsByClasseStd(ClasseStd classe);

}
