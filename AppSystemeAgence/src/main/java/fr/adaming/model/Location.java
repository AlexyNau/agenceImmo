package fr.adaming.model;

import java.io.Serializable;
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
@Table(name = "locations")
public class Location extends BienImmobilier implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_l")
	private int id;
	private double caution;
	private double loyer;
	private double charges;
	private int bail;
	private boolean garniture;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id_p", name = "proprietaire_id")
	private Proprietaire proprietaire;

	@JsonIgnore
	@OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
	private List<Visite> visites;

	@JsonIgnore
	@OneToOne(mappedBy = "location")
	private Contrat contrat;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id_classeStd", name = "classeStd_id")
	private ClasseStd classeStd;

	public Location() {
		super();
	}

	public Location(String statut, Date datePublication, Date dateDisponibilite, double revenuCadastral, double remise,
			double superficie, byte[] photo, String image, Adresse adresse, int id, double caution, double loyer,
			double charges, int bail, boolean garniture, Proprietaire proprietaire, List<Visite> visites,
			Contrat contrat, ClasseStd classeStd) {
		super(statut, datePublication, dateDisponibilite, revenuCadastral, remise, superficie, photo, image, adresse);
		this.id = id;
		this.caution = caution;
		this.loyer = loyer;
		this.charges = charges;
		this.bail = bail;
		this.garniture = garniture;
		this.proprietaire = proprietaire;
		this.visites = visites;
		this.contrat = contrat;
		this.classeStd = classeStd;
	}

	public Location(String statut, Date datePublication, Date dateDisponibilite, double revenuCadastral, double remise,
			double superficie, byte[] photo, String image, Adresse adresse, double caution, double loyer,
			double charges, int bail, boolean garniture, Proprietaire proprietaire, List<Visite> visites,
			Contrat contrat, ClasseStd classeStd) {
		super(statut, datePublication, dateDisponibilite, revenuCadastral, remise, superficie, photo, image, adresse);
		this.caution = caution;
		this.loyer = loyer;
		this.charges = charges;
		this.bail = bail;
		this.garniture = garniture;
		this.proprietaire = proprietaire;
		this.visites = visites;
		this.contrat = contrat;
		this.classeStd = classeStd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCaution() {
		return caution;
	}

	public void setCaution(double caution) {
		this.caution = caution;
	}

	public double getLoyer() {
		return loyer;
	}

	public void setLoyer(double loyer) {
		this.loyer = loyer;
	}

	public double getCharges() {
		return charges;
	}

	public void setCharges(double charges) {
		this.charges = charges;
	}

	public int getBail() {
		return bail;
	}

	public void setBail(int bail) {
		this.bail = bail;
	}

	public boolean isGarniture() {
		return garniture;
	}

	public void setGarniture(boolean garniture) {
		this.garniture = garniture;
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
		return "Location [id=" + id + ", caution=" + caution + ", loyer=" + loyer + ", charges=" + charges + ", bail="
				+ bail + ", garniture=" + garniture + "]";
	}

}
