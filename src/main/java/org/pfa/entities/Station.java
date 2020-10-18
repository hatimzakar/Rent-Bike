package org.pfa.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Station {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ;
	private String nom;
	private String Adresse ;
	
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="Station_Velo_association",joinColumns=@JoinColumn(name="idStation"),inverseJoinColumns=@JoinColumn(name="idVelo"))
	private List<Velo> velo=new ArrayList<Velo>();
	
	
	@ManyToMany
	@JoinTable(name="Gerant_Station_Association",joinColumns=@JoinColumn(name="idStation"),inverseJoinColumns=@JoinColumn(name="idGerant"))
	private List <Gerant> station=new ArrayList<Gerant>();
	
	
    @OneToOne( cascade = CascadeType.ALL) 
    @JoinColumn( name="idPosition" )
    private Position position;

	public Station() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Station(String nom, String adresse) {
		super();
		this.nom = nom;
		Adresse = adresse;
		
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

	public String getAdresse() {
		return Adresse;
	}

	public void setAdresse(String adresse) {
		Adresse = adresse;
	}

	

	public List<Velo> getVelo() {
		return velo;
	}

	@Override
	public String toString() {
		return "Station [id=" + id + ", nom=" + nom + ", Adresse=" + Adresse + ", longitude=" + ", velo=" + velo + "]";
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	
	

	
	
	
	
}
