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
import javax.persistence.OneToOne;

import org.springframework.transaction.annotation.Transactional;

@Entity
public class Client {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom ;
	private String prenom ;
	private String email ;
	private String username;
	private String password;
	@OneToOne
	@JoinColumn(name="idAbonnement")
	private Abonnement abonnement ;
	
	
	
	@ManyToMany
	@JoinTable(name="Date_Utilisation",joinColumns=@JoinColumn(name="idStation"),inverseJoinColumns=@JoinColumn(name="idVelo"))
	private List<Velo> velo_utilise=new ArrayList<Velo>();
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(String nom, String prenom, String email, String username, String password) {
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
	public List<Velo> getVelo_utilise() {
		return velo_utilise;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", username="
				+ username + ", password=" + password + "]";
	}

	
	
	
	
	
	
}
