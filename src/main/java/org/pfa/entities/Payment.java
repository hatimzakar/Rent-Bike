package org.pfa.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Payment {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idClient")
	private Client client;
	private String reference;
	private boolean status;
	
	
	
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Payment(int id,  String reference, boolean status) {
		super();
		this.id = id;
		
		this.reference = reference;
		this.status = status;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}



	public Client getClient() {
		return client;
	}



	public void setClient(Client client) {
		this.client = client;
	}



	@Override
	public String toString() {
		return "payment [id=" + id + ", reference=" + reference + ", status=" + status + "]";
	}
	
	
	
	

}
