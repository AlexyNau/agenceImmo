package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.ClasseStd;

@Repository
public class ClasseStdDaoImpl implements IClasseStdDao {

	@Autowired
	private SessionFactory sf;
	private Session s;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	/**
	 * m�thode pour modifier une classe std (servira lors de l'ajout d'un bien
	 * immobilier ou la mise dans les favoris d'un client
	 */
	@Override
	public ClasseStd updateClasseStd(ClasseStd classe) {
		// r�cup�ration de la session
		s = sf.getCurrentSession();

		//r�cup�ration de la classe std existante
		ClasseStd classeOut = (ClasseStd) s.get(ClasseStd.class, classe.getId());
		
		//stockage de la classe modifi�e dans la classe pr�existante
		classeOut.setClients(classe.getClients());
		classeOut.setCode(classe.getCode());
		classeOut.setLocations(classe.getLocations());
		classeOut.setMode_offre(classe.getMode_offre());
		classeOut.setPrix_max(classe.getPrix_max());
		classeOut.setSup_min(classe.getSup_min());
		classeOut.setType_bien(classe.getType_bien());
		classeOut.setVentes(classe.getVentes());

		//modification de la classe std dans la base de donn�es
		s.saveOrUpdate(classeOut);
		
		return classeOut;
	}

	/**
	 * m�thode pour afficher toutes les classes std : servira dans l'accueil de
	 * l'application
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ClasseStd> getAllClassesStd() {
		// r�cup�ration de la session
		s = sf.getCurrentSession();

		// requete HQL
		String req = "from ClasseStd cs";

		// cr�ation d'un query
		Query query = s.createQuery(req);

		return query.list();
	}

	/**
	 * M�thode pour r�cup�rer une classe std par son id servira pour retrouver
	 * les biens contenus dans une classe
	 */
	@Override
	public ClasseStd getClasseStdById(int id) {
		// r�cup�ration de la session
		s = sf.getCurrentSession();

		// requete HQL
		String req = "from ClasseStd cs where cs.id=:pId";

		// cr�ation d'un query
		Query query = s.createQuery(req);

		// assignation des param�tres
		query.setParameter("pId", id);

		return (ClasseStd) query.uniqueResult();
	}

}
