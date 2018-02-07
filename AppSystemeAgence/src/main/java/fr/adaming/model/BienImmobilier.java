package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class BienImmobilier implements Serializable{
	
	private String statut;
	
	@Temporal(TemporalType.DATE)
	private Date datePublication;
	
	@Temporal(TemporalType.DATE)
	private Date dateDisponibilite;
	
	private double revenuCadastral;
	private double remise;
	private double superficie;
	
	@Lob
	private byte[] photo;
	
	private String image;
	
	@Embedded
	private Adresse adresse;
	
	public BienImmobilier() {
		super();
	}
	
	public BienImmobilier(String statut, Date datePublication, Date dateDisponibilite, double revenuCadastral,
			double remise, double superficie, byte[] photo, String image, Adresse adresse) {
		super();
		this.statut = statut;
		this.datePublication = datePublication;
		this.dateDisponibilite = dateDisponibilite;
		this.revenuCadastral = revenuCadastral;
		this.remise = remise;
		this.superficie = superficie;
		this.photo = photo;
		this.image = image;
		this.adresse = adresse;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Date getDatePublication() {
		return datePublication;
	}

	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}

	public Date getDateDisponibilite() {
		return dateDisponibilite;
	}

	public void setDateDisponibilite(Date dateDisponibilite) {
		this.dateDisponibilite = dateDisponibilite;
	}

	public double getRevenuCadastral() {
		return revenuCadastral;
	}

	public void setRevenuCadastral(double revenuCadastral) {
		this.revenuCadastral = revenuCadastral;
	}

	public double getRemise() {
		return remise;
	}

	public void setRemise(double remise) {
		this.remise = remise;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


	public double getSuperficie() {
		return superficie;
	}


	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

}
