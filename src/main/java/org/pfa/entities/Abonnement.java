package org.pfa.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Abonnement {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private float montant;
	private String Type ;
	private Date date;
	
	private long pin;
	@OneToOne( cascade = CascadeType.ALL) 
	@JoinColumn( name="id_client" )
	private Client client;
	
	public Abonnement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Abonnement( float montant, String type,Date date,Client c1) {
		super();
		
		this.montant = montant;
		this.Type = type;
		this.date=date;
		this.client=c1;
	}
	public int getId() {
		return id;
	}
	
	
	public float getMontant() {
		return montant;
	}
	public void setMontant(float montant) {
		this.montant = montant;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	
	
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public long getPin() {
		return pin;
	}
	public void setPin(long pin) {
		this.pin = pin;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Abonnement [id=" + id + ", montant=" + montant + ", Type=" + Type + ", date=" + date + ", pin=" + pin
				+ ", client=" + client + "]";
	}
	
}	
