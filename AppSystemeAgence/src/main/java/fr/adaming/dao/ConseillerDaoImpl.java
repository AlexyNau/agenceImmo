package fr.adaming.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import fr.adaming.model.Conseiller;

@Repository
public class ConseillerDaoImpl implements IConseillerDao {

	@Autowired
	private SessionFactory sf;
	private Session s;

	@Override
	public Conseiller isExist(String mail, String mdp) {
		s = sf.getCurrentSession();
		String req = "FROM Conseiller c WHERE c.mail=:pMail and c.mdp=:pMdp";
		Query query = s.createQuery(req);
		query.setParameter("pMail", mail);
		query.setParameter("pMdp", mdp);

		return (Conseiller) query.uniqueResult();
		
	}

}
