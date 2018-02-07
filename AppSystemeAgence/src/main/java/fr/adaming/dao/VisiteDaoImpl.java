package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import fr.adaming.model.Visite;



@Repository
public class VisiteDaoImpl implements IVisiteDao {

	
	@Autowired
	private SessionFactory sf;
	private Session s;

	// setters pour injection de dependance
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public Visite getVisiteById(int id) {

		// Récupérer la session
		s = sf.getCurrentSession();

		// Req HQL
		String req = "FROM Visite AS v WHERE v.id=:pId";

		Query query = s.createQuery(req);

		query.setParameter("pId", id);

		return (Visite) query.uniqueResult();
	}

	@Override
	public Visite addVisite(Visite visite) {

		// Récupérer la session
		 s = sf.getCurrentSession();

		// Enregistrer le client dans la BDD
		s.save(visite);

		return visite;
	}

	@Override
	public Visite updateVisite(Visite visite) {

		// Récupérer la session
		 s = sf.getCurrentSession();

		// Mettre a jour le client dans la BDD
		s.saveOrUpdate(visite);

		return visite;
	}

	@Override
	public List<Visite> getAllVisites() {

		// Récupérer la session
		 s = sf.getCurrentSession();

		// Requete HQL
		String req = "FROM Visite";

		// Création du Querry
		Query query = s.createQuery(req);

		return query.list();
	}

	@Override
	public void deleteVisite(int id) {

		// Récupération de la session
				 s = sf.getCurrentSession();
				// Récupération du Client correspondant à id de la BD
				Visite v_out = (Visite) s.get(Visite.class, id);
				// Suppession de la visite avec la methode delete
				s.delete(v_out);
			}

		}
