package com.cglia.reverse.model;

import javax.persistence.*;

@Entity
public class Capital {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int capitalId;
	private String capitalName;
	
	public int getCapitalId() {
		return capitalId;
	}
	public void setCapitalId(int capitalId) {
		this.capitalId = capitalId;
	}
	public String getCapitalName() {
		return capitalName;
	}
	public void setCapitalName(String capitalName) {
		this.capitalName = capitalName;
	}
}
