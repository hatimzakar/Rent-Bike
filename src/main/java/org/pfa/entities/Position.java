package org.pfa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Position {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ;
	private int longititude;
	private  int latitude;
	
	public Position() {
		super();
		
	}
	public Position(int longititude, int latitude) {
		super();
		this.longititude = longititude;
		this.latitude = latitude;
	}
	public int getId() {
		return id;
	}
	
	public int getLongititude() {
		return longititude;
	}
	public void setLongititude(int longititude) {
		this.longititude = longititude;
	}
	public int getLatitude() {
		return latitude;
	}
	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}
	@Override
	public String toString() {
		return "Position [id=" + id + ", longititude=" + longititude + ", latitude=" + latitude + "]";
	}
	
	 
	

}
