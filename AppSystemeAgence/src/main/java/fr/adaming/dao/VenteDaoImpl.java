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
	 * m�thode pour afficher toutes les ventes : servira dans l'accueil de
	 * l'application
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Vente> getAllVente() {
		// r�cup�ration de la session
		s = sf.getCurrentSession();

		// requete HQL
		String req = "from Vente v";

		// cr�ation d'un query
		Query query = s.createQuery(req);

		return query.list();
	}

	/**
	 * M�thode pour r�cup�rer une vente par son id
	 */
	@Override
	public Vente getVenteById(int idVente) {
		// r�cup�ration de la session
		s = sf.getCurrentSession();

		// requete HQL
		String req = "from Vente v where v.id=:pId";

		// cr�ation d'un query
		Query query = s.createQuery(req);

		// assignation des param�tres
		query.setParameter("pId", idVente);

		return (Vente) query.uniqueResult();
	}

	/**
	 * m�thode pour modifier une vente : servira lors de la vente d'un bien
	 */
	@Override
	public Vente updateVente(Vente vente) {
		// r�cup�ration de la session
		s = sf.getCurrentSession();

		// r�cup�ration de la vente existante
		Vente vOut = (Vente) s.get(Vente.class, vente.getId());

		// stockage de la vente modifi�e dans la vente pr�existante
		vOut.setAdresse(vente.getAdresse());
		vOut.setClasseStd(vente.getClasseStd());
		vOut.setContrat(vente.getContrat());
		vOut.setDateDisponibilite(vente.getDateDisponibilite());
		vOut.setDatePublication(vente.getDatePublication());
		vOut.setEtat(vente.getEtat());
		vOut.setImage(vente.getImage());
		vOut.setPhoto(vente.getPhoto());
		vOut.setPrixAchat(vente.getPrixAchat());
		vOut.setProprietaire(vente.getProprietaire());
		vOut.setRemise(vente.getRemise());
		vOut.setRevenuCadastral(vente.getRevenuCadastral());
		vOut.setStatut(vente.getStatut());
		vOut.setVisites(vente.getVisites());
		vOut.setSuperficie(vente.getSuperficie());

		// modification de la vente dans la base de donn�es
		s.saveOrUpdate(vOut);

		return vOut;
	}

	/**
	 * m�thode pour ajouter un bien � vendre
	 */
	@Override
	public Vente addVente(Vente vente) {
		// r�cup�ration de la session
		s = sf.getCurrentSession();

		// ajout de la vente
		s.save(vente);
		return vente;
	}

	/**
	 * m�thode pour supprimer un bien � vendre de la base de donn�es
	 */
	@Override
	public int deleteVente(int idVente) {
		// r�cup�ration de la session
		s = sf.getCurrentSession();

		// �criture de la requete HQL
		String req = "delete from Vente v where v.id=:pId";

		// cr�ation d'un query
		Query query = s.createQuery(req);

		// assignation des param�tres
		query.setParameter("pId", idVente);

		return query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vente> getVentesByClasseStd(ClasseStd classe) {
		// r�cup�ration de la session
		s = sf.getCurrentSession();

		// �criture de la requete HQL
		String req = "from Vente v where v.classeStd.id=:pId";

		// cr�ation d'un query
		Query query = s.createQuery(req);

		// assignation des param�tres
		query.setParameter("pId", classe.getId());

		return query.list();
	}

}
