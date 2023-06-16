package com.cglia.junit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Zipcode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int zipId;
	private int zipcode;
	
	@OneToOne
	private Village village;
		
	public Zipcode() {
		super();
	}
	
	
	public Zipcode(int zipId, int zipcode) {
		super();
		this.zipId = zipId;
		this.zipcode = zipcode;
	}
	
	
	public int getZipId() {
		return zipId;
	}
	public void setZipId(int zipId) {
		this.zipId = zipId;
	}
	public int getZipcode() {
		return zipcode;
	}
	
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

}






