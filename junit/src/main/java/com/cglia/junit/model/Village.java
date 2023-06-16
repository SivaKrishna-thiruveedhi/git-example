package com.cglia.junit.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Village {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int villageId;
	private String villageName;
	private int population;
	private int status;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "zipId")
	private Zipcode zipcode;

	public Village() {
		super();
	}
	
	public int getVillageId() {
		return villageId;
	}
	
	public void setVillageId(int villageId) {
		this.villageId = villageId;
	}
	
	public Village(int villageId, String villageName, int population, int status, Zipcode zipcode) {
		super();
		this.villageId = villageId;
		this.villageName = villageName;
		this.population = population;
		this.status = status;
		this.zipcode = zipcode;
	}

	public String getVillageName() {
		return villageName;
	}
	
	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}
	
	public int getPopulation() {
		return population;
	}
	
	public void setPopulation(int population) {
		this.population = population;
	}
	
	public Zipcode getZipcode() {
		return zipcode;
	}
	
	public void setZipcode(Zipcode zipcode) {
		this.zipcode = zipcode;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
