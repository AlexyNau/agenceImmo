package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.ClasseStd;
import fr.adaming.model.Location;

public interface ILocationDao {

	public List<Location> getAllLocation();

	public Location getLocationById(int idLoc);
	
	public Location updateLocation(Location loc);
	
	public Location addLocation(Location loc);
	
	public int deleteLocation(int idLoc);
	
	public List<Location> getLocationsByClasseStd(ClasseStd classe);

}
