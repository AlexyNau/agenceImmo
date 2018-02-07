package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="proprietaires")
public class Proprietaire implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_p")
	private int id;
	private String nom;
	private String numTelPrive;
	private String numTelTravail;
	
	@Embedded
	private Adresse adresse;
	
	@JsonIgnore
	@OneToMany(mappedBy="proprietaire",cascade=CascadeType.ALL)
	private List<Vente> listeVentes;
	
	@JsonIgnore
	@OneToMany(mappedBy="proprietaire",cascade=CascadeType.ALL)
	private List<Location> listeLocations;
	

	public Proprietaire() {
		super();
	}

	public Proprietaire(String nom, String numTelPrive, String numTelTravail, Adresse adresse) {
		super();
		this.nom = nom;
		this.numTelPrive = numTelPrive;
		this.numTelTravail = numTelTravail;
		this.adresse = adresse;
	}

	public Proprietaire(int id, String nom, String numTelPrive, String numTelTravail, Adresse adresse) {
		super();
		this.id = id;
		this.nom = nom;
		this.numTelPrive = numTelPrive;
		this.numTelTravail = numTelTravail;
		this.adresse = adresse;
	}

	public Proprietaire(String nom, String numTelPrive, String numTelTravail) {
		super();
		this.nom = nom;
		this.numTelPrive = numTelPrive;
		this.numTelTravail = numTelTravail;
	}

	public Proprietaire(int id, String nom, String numTelPrive, String numTelTravail) {
		super();
		this.id = id;
		this.nom = nom;
		this.numTelPrive = numTelPrive;
		this.numTelTravail = numTelTravail;
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

	public String getNumTelPrive() {
		return numTelPrive;
	}

	public void setNumTelPrive(String numTelPrive) {
		this.numTelPrive = numTelPrive;
	}

	public String getNumTelTravail() {
		return numTelTravail;
	}

	public void setNumTelTravail(String numTelTravail) {
		this.numTelTravail = numTelTravail;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	

	public List<Vente> getListeVentes() {
		return listeVentes;
	}

	public void setListeVentes(List<Vente> listeVentes) {
		this.listeVentes = listeVentes;
	}

	public List<Location> getListeLocations() {
		return listeLocations;
	}

	public void setListeLocations(List<Location> listeLocations) {
		this.listeLocations = listeLocations;
	}

	@Override
	public String toString() {
		return "Proprietaire [id=" + id + ", nom=" + nom + ", numTelPrive=" + numTelPrive + ", numTelTravail="
				+ numTelTravail + ", adresse=" + adresse + "]";
	}	
	
	

}
