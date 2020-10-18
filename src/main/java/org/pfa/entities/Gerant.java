package org.pfa.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Gerant {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int  id;
	private String nom;
	private String prenom;
	private String email ;
	private String username;
	private String password;
	
	@ManyToMany
	@JoinTable(name="Gerant_Station_Association",joinColumns=@JoinColumn(name="idGerant"),inverseJoinColumns=@JoinColumn(name="idStation"))
	private List <Station> station=new ArrayList<Station>();
	
	
	
	
	
	public Gerant() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Gerant(String nom, String prenom, String email, String username, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.username = username;
		this.password = password;
	}




	public int getId() {
		return id;
	}




	



	




	public String getNom() {
		return nom;
	}




	public void setNom(String nom) {
		this.nom = nom;
	}




	public String getPrenom() {
		return prenom;
	}




	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Gerant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", username="
				+ username + ", password=" + password + "]";
	}
	
	
	
	
	
}
