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
	 * méthode pour modifier une classe std (servira lors de l'ajout d'un bien
	 * immobilier ou la mise dans les favoris d'un client
	 */
	@Override
	public ClasseStd updateClasseStd(ClasseStd classe) {
		// récupération de la session
		s = sf.getCurrentSession();

		//récupération de la classe std existante
		ClasseStd classeOut = (ClasseStd) s.get(ClasseStd.class, classe.getId());
		
		//stockage de la classe modifiée dans la classe préexistante
		classeOut.setClients(classe.getClients());
		classeOut.setCode(classe.getCode());
		classeOut.setLocations(classe.getLocations());
		classeOut.setMode_offre(classe.getMode_offre());
		classeOut.setPrix_max(classe.getPrix_max());
		classeOut.setSup_min(classe.getSup_min());
		classeOut.setType_bien(classe.getType_bien());
		classeOut.setVentes(classe.getVentes());

		//modification de la classe std dans la base de données
		s.saveOrUpdate(classeOut);
		
		return classeOut;
	}

	/**
	 * méthode pour afficher toutes les classes std : servira dans l'accueil de
	 * l'application
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ClasseStd> getAllClassesStd() {
		// récupération de la session
		s = sf.getCurrentSession();

		// requete HQL
		String req = "from ClasseStd cs";

		// création d'un query
		Query query = s.createQuery(req);

		return query.list();
	}

	/**
	 * Méthode pour récupérer une classe std par son id servira pour retrouver
	 * les biens contenus dans une classe
	 */
	@Override
	public ClasseStd getClasseStdById(int id) {
		// récupération de la session
		s = sf.getCurrentSession();

		// requete HQL
		String req = "from ClasseStd cs where cs.id=:pId";

		// création d'un query
		Query query = s.createQuery(req);

		// assignation des paramètres
		query.setParameter("pId", id);

		return (ClasseStd) query.uniqueResult();
	}

}
