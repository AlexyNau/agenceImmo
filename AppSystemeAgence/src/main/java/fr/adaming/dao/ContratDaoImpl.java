package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Contrat;


@Repository
public class ContratDaoImpl implements IContratDao {

	@Autowired
	private SessionFactory sf;
	private Session s;
	
	// setters pour injection de dependance
		public void setSf(SessionFactory sf) {
			this.sf = sf;
		}
		
		@Override
		public List<Contrat> getAllContrats() {
			
			s = sf.getCurrentSession();
			
			// requete
			String req = "FROM Contrat";
			
			Query query = s.createQuery(req);
			
			return query.list();
		}

		@Override
		public Contrat getContratById(int id) {
			
			s = sf.getCurrentSession();
			
			// requete
			String req = "FROM Contrat c WHERE c.id=:pId";
			
			Query query = s.createQuery(req);
			
			query.setParameter("pId", id);
			
			return (Contrat) query.uniqueResult();
		}

		@Override
		public Contrat addContrat(Contrat contrat) {
			
			s = sf.getCurrentSession();
			System.out.println("-----------------contrat dao"+contrat);
			s.save(contrat);
			return contrat;
		}

		@Override
		public Contrat updateContrat(Contrat contrat) {
		
			s = sf.getCurrentSession();
			
			s.saveOrUpdate(contrat);
			return contrat;
		}

	@Override
	public void deleteContrat(int id) {
		// Récupération de la session
				s = sf.getCurrentSession();
				// Récupération du contrat correspondant à id de la BD
				Contrat c_out = (Contrat) s.get(Contrat.class, id);
				// Suppession du contrat avec la methode delete
				s.delete(c_out);
			}


}
