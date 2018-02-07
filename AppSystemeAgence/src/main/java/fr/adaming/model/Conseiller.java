package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="conseillers")
public class Conseiller implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_conseiller")
	private int id;
	
	private String nom;
	
	private String mail;
	
	private String mdp;

	@OneToMany(mappedBy="conseiller",cascade=CascadeType.ALL)
	private List<Visite> visites;
	
	public Conseiller() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Conseiller( String nom, String mail, String mdp) {
		super();
		this.nom = nom;
		this.mail = mail;
		this.mdp = mdp;
	}

	public Conseiller(int id, String nom, String mail, String mdp) {
		super();
		this.id = id;
		this.nom = nom;
		this.mail = mail;
		this.mdp = mdp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public List<Visite> getVisites() {
		return visites;
	}

	public void setVisites(List<Visite> visites) {
		this.visites = visites;
	}

	@Override
	public String toString() {
		return "Conseiller [id=" + id + ", nom=" + nom + ", mail=" + mail + ", mdp=" + mdp + "]";
	}
	
	
	

}
