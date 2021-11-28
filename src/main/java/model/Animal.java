package model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the animal database table.
 * 
 */
@XmlRootElement
@Entity
@NamedQuery(name="Animal.findAll", query="SELECT a FROM Animal a")
public class Animal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String categorie;

	private String couleur;

	private String nom;

	public Animal() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategorie() {
		return this.categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getCouleur() {
		return this.couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}