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

	@SuppressWarnings("unchecked")
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

	@Override
	public Client isExiste(String mail, String mdp) {
		s = sf.getCurrentSession();
		String req = "FROM Client c WHERE c.mail=:pMail and c.mdp=:pMdp";
		Query query = s.createQuery(req);
		query.setParameter("pMail", mail);
		query.setParameter("pMdp", mdp);

		return (Client) query.uniqueResult();
	}

}
