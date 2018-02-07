package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Proprietaire;

@Repository
public class ProprietaireDaoImpl implements IProprietaireDao {

	@Autowired
	private SessionFactory sf;
	private Session s;

	// setters pour injection de dependance
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<Proprietaire> getAllProprio() {
		// recup la session
		s = sf.getCurrentSession();

		// requete sql
		String req = "FROM Proprietaire";

		// recuperer l'objet Query
		Query query = s.createQuery(req);

		return query.list();
	}

	@Override
	public Proprietaire getProprioById(int id) {
		s = sf.getCurrentSession();
		String req = "FROM Proprietaire p WHERE p.id=:pidp";

		Query query = s.createQuery(req);

		query.setParameter("pidp", id);

		return (Proprietaire) query.uniqueResult();

	}

	@Override
	public Proprietaire addProprio(Proprietaire p) {
		s = sf.getCurrentSession();

		s.save(p);
		return p;
	}

	@Override
	public Proprietaire updateProprio(Proprietaire p) {
		s = sf.getCurrentSession();
		// requete hql
		String req = "update Proprietaire p set p.adresse.numero=:pAdNum,p.adresse.pays=:pAdPays,p.adresse.rue=:pAdRue,p.adresse.ville=:pAdVille,p.nom=:pNom,p.numTelPrive=:pNumTelp,p.numTelTravail=:pNumTelt WHERE p.id=:pID";

		Query query = s.createQuery(req);

		query.setParameter("pAdNum", p.getAdresse().getNumero());
		query.setParameter("pAdPays", p.getAdresse().getPays());
		query.setParameter("pAdRue", p.getAdresse().getRue());
		query.setParameter("pAdVille", p.getAdresse().getVille());
		query.setParameter("pNom", p.getNom());
		query.setParameter("pNumTelp", p.getNumTelPrive());
		query.setParameter("pNumTelt", p.getNumTelTravail());
		query.setParameter("pID", p.getId());

		query.executeUpdate();
		return p;

	}

	@Override
	public void deleteProprio(int id) {
		// Récupération de la session
		s = sf.getCurrentSession();
		// Récupération du proprio correspondant à id de la BD
		Proprietaire p_out = (Proprietaire) s.get(Proprietaire.class, id);
		// Suppression du proprio avec la methode delete
		s.delete(p_out);
	}

}
