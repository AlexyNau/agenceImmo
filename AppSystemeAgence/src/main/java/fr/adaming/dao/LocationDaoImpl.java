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
	 * m�thode pour afficher toutes les locations : servira dans l'accueil de
	 * l'application
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Location> getAllLocation() {
		// r�cup�ration de la session
		s = sf.getCurrentSession();

		// requete HQL
		String req = "from Location l";

		// cr�ation d'un query
		Query query = s.createQuery(req);

		return query.list();
	}

	/**
	 * M�thode pour r�cup�rer une location par son id
	 */
	@Override
	public Location getLocationById(int idLoc) {
		// r�cup�ration de la session
		s = sf.getCurrentSession();

		// requete HQL
		String req = "from Location l where l.id=:pId";

		// cr�ation d'un query
		Query query = s.createQuery(req);

		// assignation des param�tres
		query.setParameter("pId", idLoc);
		return (Location) query.uniqueResult();
	}

	/**
	 * m�thode pour modifier une location : servira lors de la vente d'un bien
	 */
	@Override
	public Location updateLocation(Location loc) {
		// r�cup�ration de la session
		s = sf.getCurrentSession();

		// r�cup�ration de la location existante
		Location lOut = (Location) s.get(Location.class, loc.getId());

		if (lOut.getStatut().equals("disponible")){
			lOut.setStatut("loue");
		} else {
			lOut.setStatut("disponible");
		}
		

		// modification de la location dans la base de donn�es
		s.saveOrUpdate(lOut);

		return lOut;
	}

	/**
	 * m�thode pour ajouter un bien � louer
	 */
	@Override
	public Location addLocation(Location loc) {
		// r�cup�ration de la session
		s = sf.getCurrentSession();

		// ajout de la location
		s.save(loc);

		return loc;
	}

	/**
	 * m�thode pour supprimer un bien � louer de la base de donn�es
	 */
	@Override
	public int deleteLocation(int idLoc) {
		// r�cup�ration de la session
		s = sf.getCurrentSession();

		// �criture de la requete HQL
		String req = "delete from Location l where l.id=:pId";

		// cr�ation d'un query
		Query query = s.createQuery(req);

		// assignation des param�tres
		query.setParameter("pId", idLoc);

		return query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Location> getLocationsByClasseStd(ClasseStd classe) {
		// r�cup�ration de la session
		s = sf.getCurrentSession();

		// �criture de la requete HQL
		String req = "from Location l where l.classeStd.id=:pId";

		// cr�ation d'un query
		Query query = s.createQuery(req);

		// assignation des param�tres
		query.setParameter("pId", classe.getId());

		return query.list();
	}

}
