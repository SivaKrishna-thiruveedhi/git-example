package com.cglia.reverse.model;

import javax.persistence.*;

@Entity
public class State_language {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int slId;
	
	@ManyToOne
	@JoinColumn(name="Sate_id")
	private State state;
	
	@ManyToOne
	@JoinColumn(name="lang_id")
	private Language language;
	
	
	public int getSlId() {
		return slId;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public void setSlId(int slId) {
		this.slId = slId;
	}
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}
	
}
