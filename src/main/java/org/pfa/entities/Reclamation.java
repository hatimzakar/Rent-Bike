package org.pfa.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Proxy;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Proxy(lazy=false)
@Entity
public class Reclamation {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ;
	private String description;
	private Date date;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idClient2")
	private Client client2;
	
	
	public Reclamation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reclamation(String description ,Date  date,Client client) {
		super();
		this.description = description;
		this.date=date;
		this.client2=client;
	}
	public int getId() {
		return id;
	}
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
	
	@Override
	public String toString() {
		return "Reclamation [id=" + id + ", description=" + description + ", date=" + date + "]";
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Client getClient() {
		return client2;
	}
	public void setClient(Client client) {
		this.client2 = client;
	}
	
	
	
	
}
