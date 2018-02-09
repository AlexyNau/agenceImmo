package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JoinTableDaoImpl implements IJoinTableDao {

	@Autowired
	private SessionFactory sf;
	private Session s;

	@Override
	public List<Integer> getIdClasseOfClientInteresse(int idClient) {

		try {
			// récupération de la session
			s = sf.getCurrentSession();
		} catch (Exception e) {
			System.out.println("erreur session");
		}
		s = sf.openSession();

		// requete SQL
		String req = "SELECT classes_clients.classe_id FROM classes_clients INNER JOIN clients ON (clients.id_client = classes_clients.client_id AND  clients.id_client =  ?)";

		// création d'un querySQL
		Query query = s.createSQLQuery(req);
		query.setInteger(0, idClient);

		return query.list();
	}

}
