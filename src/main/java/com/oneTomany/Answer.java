package com.oneTomany;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="god2")
public class Answer {
	
	@Id
	private int id;
	private String ansName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnsName() {
		return ansName;
	}
	public void setAnsName(String ansName) {
		this.ansName = ansName;
	}
	
	
}
