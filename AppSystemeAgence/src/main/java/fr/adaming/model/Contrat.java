package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "contrats")
public class Contrat implements Serializable{
	// Com
	// Les attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_contrat")
	private int id;
	private double prix;
	private Date date;
	
	@OneToOne
	@JoinColumn(referencedColumnName="id_l",name="location_id")
	private Location location;
	
	@OneToOne
	@JoinColumn(referencedColumnName="id_vente",name="vente_id")
	private Vente vente;
	
	@ManyToOne
	@JoinColumn(name="client_id", referencedColumnName="id_client")
	private Client client;
	

	// Les constructeurs
	public Contrat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contrat(double prix, Date date) {
		super();
		this.prix = prix;
		this.date = date;
	}

	public Contrat(int id, double prix, Date date) {
		super();
		this.id = id;
		this.prix = prix;
		this.date = date;
	}

	// Getters et setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Vente getVente() {
		return vente;
	}

	public void setVente(Vente vente) {
		this.vente = vente;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	// ToString
	@Override
	public String toString() {
		return "Contrat [id=" + id + ", prix=" + prix + ", date=" + date + "]";
	}
}
