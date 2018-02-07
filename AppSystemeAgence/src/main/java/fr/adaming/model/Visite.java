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
@Table(name = "visites")
public class Visite implements Serializable {

	// attribut date avec l'heure compris dedans
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_visite")
	private int id;
	private Date date;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_conseiller", referencedColumnName = "id_conseiller")
	private Conseiller conseiller;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_client", referencedColumnName = "id_client")
	private Client client;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_vente", referencedColumnName = "id_vente")
	private Vente vente;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_location", referencedColumnName = "id_l")
	private Location location;

	// constructeur vide
	public Visite() {
		super();
	}

	// constructeur sans id
	public Visite(Date date) {
		super();
		this.date = date;
	}

	// constructeur avec id
	public Visite(int id, Date date) {
		super();
		this.id = id;
		this.date = date;
	}

	// Getters et Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Vente getVente() {
		return vente;
	}

	public void setVente(Vente vente) {
		this.vente = vente;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	// Methode ToString
	@Override
	public String toString() {
		return "Visite [id=" + id + ", date=" + date + "]";
	}

}
