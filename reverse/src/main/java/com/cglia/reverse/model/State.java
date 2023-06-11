package com.cglia.reverse.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class State {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int state_Id;
	private String stateName;
	private String region;
	private double area;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="capital_id")
	private Capital capital;
	
	@OneToMany(targetEntity = Distict.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "state_id")
	private List<Distict> distict;
	
	@ManyToMany(mappedBy = "state")
	private List<Language> language;
	
	
	public List<Distict> getDistict() {
		return distict;
	}
	public void setDistict(List<Distict> distict) {
		this.distict = distict;
	}
	public int getState_Id() {
		return state_Id;
	}
	public void setState_Id(int state_Id) {
		this.state_Id = state_Id;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getRegion() {
		return region;
	}
	public List<Language> getLanguage() {
		return language;
	}
	public void setLanguage(List<Language> language) {
		this.language = language;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	public Capital getCapital() {
		return capital;
	}
	public void setCapital(Capital capital) {
		this.capital = capital;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}

}
