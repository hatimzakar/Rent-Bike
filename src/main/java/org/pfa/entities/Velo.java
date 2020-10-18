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

@Entity 
public class Velo   {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String Matricule;
	private String Type ;
	
	@OneToOne @JoinColumn(name="idPosition")
	private Position position;
	

	@ManyToMany
	@JoinTable(name="Station_Velo_association",joinColumns=@JoinColumn(name="idVelo"),inverseJoinColumns=@JoinColumn(name="idStation"))
	List<Station> station=new ArrayList<Station>();
	
	@ManyToMany
	@JoinTable(name="Date_Utilisation",joinColumns=@JoinColumn(name="idVelo"),inverseJoinColumns=@JoinColumn(name="idClient"))
	private List<Client> client=new ArrayList<Client>();
	
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public Velo() {
		super();
	}
	public Velo(int id, String matricule, String type) {
		super();
		this.id = id;
		Matricule = matricule;
		Type = type;
	}
	public int getId() {
		return id;
	}

	
	public String getMatricule() {
		return Matricule;
	}
	public void setMatricule(String matricule) {
		Matricule = matricule;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	@Override
	public String toString() {
		return "Velo [id=" + id + ", Matricule=" + Matricule + ", Type=" + Type + ", position=" + position
				+ ", station=" + station + ", client=" + client + "]";
	}
	
	

}
