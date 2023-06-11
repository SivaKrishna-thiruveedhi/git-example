package com.cglia.reverse.model;

import javax.persistence.*;

@Entity
public class Zipcode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int zipId;
	private int zipcode;
	
	
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
