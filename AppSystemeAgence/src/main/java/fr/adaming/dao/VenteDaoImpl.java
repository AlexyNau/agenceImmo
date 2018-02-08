package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.ClasseStd;
import fr.adaming.model.Vente;

@Repository
public class VenteDaoImpl implements IVenteDao {

	@Autowired
	private SessionFactory sf;
	private Session s;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	//
	/**
	 * méthode pour afficher toutes les ventes : servira dans l'accueil de
	 * l'application
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Vente> getAllVente() {
		// récupération de la session
		s = sf.getCurrentSession();

		// requete HQL
		String req = "from Vente v";

		// création d'un query
		Query query = s.createQuery(req);

		return query.list();
	}

	/**
	 * Méthode pour récupérer une vente par son id
	 */
	@Override
	public Vente getVenteById(int idVente) {
		// récupération de la session
		s = sf.getCurrentSession();

		// requete HQL
		String req = "from Vente v where v.id=:pId";

		// création d'un query
		Query query = s.createQuery(req);

		// assignation des paramètres
		query.setParameter("pId", idVente);

		return (Vente) query.uniqueResult();
	}

	/**
	 * méthode pour modifier une vente : servira lors de la vente d'un bien
	 */
	@Override
	public Vente updateVente(Vente vente) {
		// récupération de la session
		s = sf.getCurrentSession();

		// récupération de la vente existante
		Vente vOut = (Vente) s.get(Vente.class, vente.getId());

		// stockage de la vente modifiée dans la vente préexistante
		vOut.setStatut("vendu");

		// modification de la vente dans la base de données
		s.saveOrUpdate(vOut);

		return vOut;
	}

	/**
	 * méthode pour ajouter un bien à vendre
	 */
	@Override
	public Vente addVente(Vente vente) {
		// récupération de la session
		s = sf.getCurrentSession();

		// ajout de la vente
		s.save(vente);
		return vente;
	}

	/**
	 * méthode pour supprimer un bien à vendre de la base de données
	 */
	@Override
	public int deleteVente(int idVente) {
		// récupération de la session
		s = sf.getCurrentSession();

		// écriture de la requete HQL
		String req = "delete from Vente v where v.id=:pId";

		// création d'un query
		Query query = s.createQuery(req);

		// assignation des paramètres
		query.setParameter("pId", idVente);

		return query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vente> getVentesByClasseStd(ClasseStd classe) {
		// récupération de la session
		s = sf.getCurrentSession();

		// écriture de la requete HQL
		String req = "from Vente v where v.classeStd.id=:pId";

		// création d'un query
		Query query = s.createQuery(req);

		// assignation des paramètres
		query.setParameter("pId", classe.getId());

		return query.list();
	}

}
