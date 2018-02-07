package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;

@Repository
public class ClientDaoImpl implements IClientDao {

	@Autowired
	private SessionFactory sf;
	private Session s;

	// setters pour injection de dependance
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<Client> getAllClient() {
		// recup la session
		s = sf.getCurrentSession();

		// requete sql
		String req = "FROM Client";

		// recuperer l'objet Query
		Query query = s.createQuery(req);

		return query.list();
	}

	@Override
	public Client getClientById(int id) {
		s = sf.getCurrentSession();
		String req = "FROM Client c WHERE c.id=:pid";

		Query query = s.createQuery(req);

		query.setParameter("pid", id);

		return (Client) query.uniqueResult();

	}

	@Override
	public Client addClient(Client c) {
		s = sf.getCurrentSession();

		s.save(c);
		return c;
	}
	


	@Override
	public Client updateClient(Client c) {
		s = sf.getCurrentSession();
//		// requete hql
//		String req = "update Client c set c.adresse.numero=:pAdNum,c.adresse.pays=:pAdPays,c.adresse.rue=:pAdRue,c.adresse.ville=:pAdVille,c.mail=:pMail,c.mdp=:pMdp,c.nom=:pNom,c.telephone=:pTel WHERE c.id=:pID";
//
//		Query query = s.createQuery(req);
//
//		query.setParameter("pAdNum", c.getAdresse().getNumero());
//		query.setParameter("pAdPays", c.getAdresse().getPays());
//		query.setParameter("pAdRue", c.getAdresse().getRue());
//		query.setParameter("pAdVille", c.getAdresse().getVille());
//		query.setParameter("pMail", c.getMail());
//		query.setParameter("pMdp", c.getMdp());
//		query.setParameter("pNom", c.getNom());
//		query.setParameter("pTel", c.getTelephone());
//		query.setParameter("pID", c.getId());
//
//		query.executeUpdate();
//		return c;

				
				// Mettre a jour le client dans la BDD
				s.saveOrUpdate(c);

				return c;

	}

	@Override
	public void deleteClient(int id) {
		// Récupération de la session
		s = sf.getCurrentSession();
		// Récupération du Client correspondant à id de la BD
		Client c_out = (Client) s.get(Client.class, id);
		// Suppession du Client avec la methode delete
		s.delete(c_out);
	}

}
