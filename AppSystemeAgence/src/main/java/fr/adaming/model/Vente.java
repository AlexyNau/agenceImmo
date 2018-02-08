package fr.adaming.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ventes")
public class Vente extends BienImmobilier {

	// Les attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_vente")
	private int id;
	private double prixAchat;
	private String etat; // Soit : à restaurer, correct, impeccable

	@ManyToOne
	@JoinColumn(referencedColumnName = "id_p", name = "proprietaire_id")
	private Proprietaire proprietaire;

	@JsonIgnore
	@OneToMany(mappedBy = "vente", cascade = CascadeType.ALL)
	private List<Visite> visites;

	@JsonIgnore
	@OneToOne(mappedBy = "vente")
	private Contrat contrat;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id_classeStd", name = "classeStd_id")
	private ClasseStd classeStd;


	// Constructeurs
	public Vente() {
		super();
	}

	public Vente(String statut, Date datePublication, Date dateDisponibilite, double revenuCadastral, double remise,
			double superficie, byte[] photo, String image, Adresse adresse, int id, double prixAchat, String etat,
			Proprietaire proprietaire, List<Visite> visites, Contrat contrat, ClasseStd classeStd) {
		super(statut, datePublication, dateDisponibilite, revenuCadastral, remise, superficie, photo, image, adresse);
		this.id = id;
		this.prixAchat = prixAchat;
		this.etat = etat;
		this.proprietaire = proprietaire;
		this.visites = visites;
		this.contrat = contrat;
		this.classeStd = classeStd;
	}

	public Vente(double prixAchat, String etat, Proprietaire proprietaire, List<Visite> visites, Contrat contrat,
			ClasseStd classeStd) {
		super();
		this.prixAchat = prixAchat;
		this.etat = etat;
		this.proprietaire = proprietaire;
		this.visites = visites;
		this.contrat = contrat;
		this.classeStd = classeStd;
	}

	// Getters et setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(double prixAchat) {
		this.prixAchat = prixAchat;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	
	public Proprietaire getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}

	public List<Visite> getVisites() {
		return visites;
	}

	public void setVisites(List<Visite> visites) {
		this.visites = visites;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	public ClasseStd getClasseStd() {
		return classeStd;
	}

	public void setClasseStd(ClasseStd classeStd) {
		this.classeStd = classeStd;
	}

	@Override
	public String toString() {
		return "Vente [id=" + id + ", prixAchat=" + prixAchat + ", etat=" + etat + "]";
	}

}
