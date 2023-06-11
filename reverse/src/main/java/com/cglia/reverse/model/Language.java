package com.cglia.reverse.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Language {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int langID;
	private String langName;
	
	@ManyToMany
	@JoinTable(name = "state_language", joinColumns = @JoinColumn(referencedColumnName = "lang_id"), inverseJoinColumns = @JoinColumn(name="state_id"))
	private List<State> state;
	
	public List<State> getState() {
		return state;
	}
	public void setState(List<State> state) {
		this.state = state;
	}
	public int getLangID() {
		return langID;
	}
	public void setLangID(int langID) {
		this.langID = langID;
	}
	public String getLangName() {
		return langName;
	}
	public void setLangName(String langName) {
		this.langName = langName;
	}
}
