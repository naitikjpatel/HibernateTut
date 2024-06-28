package com.map1;

import java.util.List;

import javax.persistence.*;

@Entity
public class Emp {
	
	@Id
	private int eid;
	private String name;
	
	//one Employee can have a multiple project 
//	that reason we ceate a list u can also a create a set no problem
	@ManyToMany
	@JoinTable(name="emp_learn",joinColumns = {@JoinColumn(name="EID")},inverseJoinColumns = {@JoinColumn(name="PID")})
	private List<Project> projects;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Emp(int eid, String name, List<Project> projects) {
		super();
		this.eid = eid;
		this.name = name;
		this.projects = projects;
	}

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
