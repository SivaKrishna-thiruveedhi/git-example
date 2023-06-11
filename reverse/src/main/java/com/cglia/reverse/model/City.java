package com.cglia.reverse.model;

import javax.persistence.*;

@Entity
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cityId;
	private String cityName;
	private int population;
	
	@ManyToOne
	@JoinColumn(name = "distict_id")
	private Distict distict;
	
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public Distict getDistict() {
		return distict;
	}
	public void setDistict(Distict distict) {
		this.distict = distict;
	}
}
