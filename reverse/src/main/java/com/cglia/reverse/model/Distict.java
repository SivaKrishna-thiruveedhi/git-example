package com.cglia.reverse.model;

import javax.persistence.*;

@Entity
public class Distict {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int distictId;
	private String distictName;
	private int population;
	private double area;
	
	@ManyToOne
	@JoinColumn(name="state_id")
	private State state;
	
	
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public int getDistictId() {
		return distictId;
	}
	public void setDistictId(int distictId) {
		this.distictId = distictId;
	}
	public String getDistictName() {
		return distictName;
	}
	public void setDistictName(String distictName) {
		this.distictName = distictName;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	
}
