package fr.adaming.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "clients")
public class Client implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_client")
	private int id;

	private String nom;

	private String telephone;

	private String mail;

	private String mdp;
	
	@Embedded
	private Adresse adresse;

	@JsonIgnore
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private List<Visite> visites;

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private List<Contrat> contrats;

	@JsonIgnore
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "classes_clients", joinColumns = @JoinColumn(name = "client_id"), inverseJoinColumns = @JoinColumn(name = "classe_id"))
	private List<ClasseStd> classesStd = new ArrayList<ClasseStd>();

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(String nom, String telephone, String mail, String mdp) {
		super();
		this.nom = nom;
		this.telephone = telephone;
		this.mail = mail;
		this.mdp = mdp;
	}

	public Client(int id, String nom, String telephone, String mail, String mdp) {
		super();
		this.id = id;
		this.nom = nom;
		this.telephone = telephone;
		this.mail = mail;
		this.mdp = mdp;
	}

	public Client(int id, String nom, String telephone, String mail, String mdp, Adresse adresse) {
		super();
		this.id = id;
		this.nom = nom;
		this.telephone = telephone;
		this.mail = mail;
		this.mdp = mdp;
		this.adresse = adresse;
	}

	public Client(String nom, String telephone, String mail, String mdp, Adresse adresse) {
		super();
		this.nom = nom;
		this.telephone = telephone;
		this.mail = mail;
		this.mdp = mdp;
		this.adresse = adresse;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
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

	public List<Contrat> getContrats() {
		return contrats;
	}

	public void setContrats(List<Contrat> contrats) {
		this.contrats = contrats;
	}

	public List<ClasseStd> getClassesStd() {
		return classesStd;
	}

	public void setClassesStd(List<ClasseStd> classesStd) {
		this.classesStd = classesStd;
	}
	

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", telephone=" + telephone + ", mail=" + mail + ", mdp=" + mdp
				+ "]";
	}

}
