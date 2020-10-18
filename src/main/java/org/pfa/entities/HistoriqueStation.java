package org.pfa.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HistoriqueStation {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int idClient ;
	private String matricule;
	private Date date;
	private String Type;
	private int station;
	
	public HistoriqueStation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HistoriqueStation(int idClient, String matricule, Date date, String type,int station) {
		super();
		this.idClient = idClient;
		this.matricule = matricule;
		this.date = date;
		this.Type = type;
		this.station=station;
		
	}
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	
	@Override
	public String toString() {
		return "HistoriqueStation [id=" + id + ", idClient=" + idClient + ", matricule=" + matricule + ", date=" + date
				+ ", Type=" + Type + "]";
	}
	public int getStation() {
		return station;
	}
	public void setStation(int station) {
		this.station = station;
	}
	
	
	
	
	

}
