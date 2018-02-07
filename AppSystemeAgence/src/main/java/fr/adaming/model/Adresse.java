package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse implements Serializable {
	
	private String rue;
	private int numero;
	private String ville;
	private String pays;
	
	
	public Adresse() {
		super();
	}
	
	
	public Adresse(String rue, int numero, String ville, String pays) {
		super();
		this.rue = rue;
		this.numero = numero;
		this.ville = ville;
		this.pays = pays;
	}




	public String getRue() {
		return rue;
	}


	public void setRue(String rue) {
		this.rue = rue;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public String getPays() {
		return pays;
	}


	public void setPays(String pays) {
		this.pays = pays;
	}


	@Override
	public String toString() {
		return "Adresse [rue=" + rue + ", numero=" + numero + ", ville=" + ville + ", pays=" + pays + "]";
	}
	
	
	

}
