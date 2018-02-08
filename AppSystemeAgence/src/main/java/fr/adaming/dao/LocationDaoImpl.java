package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.ClasseStd;
import fr.adaming.model.Location;

@Repository
public class LocationDaoImpl implements ILocationDao {

	@Autowired
	private SessionFactory sf;
	private Session s;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	/**
	 * méthode pour afficher toutes les locations : servira dans l'accueil de
	 * l'application
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Location> getAllLocation() {
		// récupération de la session
		s = sf.getCurrentSession();

		// requete HQL
		String req = "from Location l";

		// création d'un query
		Query query = s.createQuery(req);

		return query.list();
	}

	/**
	 * Méthode pour récupérer une location par son id
	 */
	@Override
	public Location getLocationById(int idLoc) {
		// récupération de la session
		s = sf.getCurrentSession();

		// requete HQL
		String req = "from Location l where l.id=:pId";

		// création d'un query
		Query query = s.createQuery(req);

		// assignation des paramètres
		query.setParameter("pId", idLoc);
		return (Location) query.uniqueResult();
	}

	/**
	 * méthode pour modifier une location : servira lors de la vente d'un bien
	 */
	@Override
	public Location updateLocation(Location loc) {
		// récupération de la session
		s = sf.getCurrentSession();

		// récupération de la location existante
		Location lOut = (Location) s.get(Location.class, loc.getId());

		if (lOut.getStatut().equals("disponible")){
			lOut.setStatut("loue");
		} else {
			lOut.setStatut("disponible");
		}
		

		// modification de la location dans la base de données
		s.saveOrUpdate(lOut);

		return lOut;
	}

	/**
	 * méthode pour ajouter un bien à louer
	 */
	@Override
	public Location addLocation(Location loc) {
		// récupération de la session
		s = sf.getCurrentSession();

		// ajout de la location
		s.save(loc);

		return loc;
	}

	/**
	 * méthode pour supprimer un bien à louer de la base de données
	 */
	@Override
	public int deleteLocation(int idLoc) {
		// récupération de la session
		s = sf.getCurrentSession();

		// écriture de la requete HQL
		String req = "delete from Location l where l.id=:pId";

		// création d'un query
		Query query = s.createQuery(req);

		// assignation des paramètres
		query.setParameter("pId", idLoc);

		return query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Location> getLocationsByClasseStd(ClasseStd classe) {
		// récupération de la session
		s = sf.getCurrentSession();

		// écriture de la requete HQL
		String req = "from Location l where l.classeStd.id=:pId";

		// création d'un query
		Query query = s.createQuery(req);

		// assignation des paramètres
		query.setParameter("pId", classe.getId());

		return query.list();
	}

}
