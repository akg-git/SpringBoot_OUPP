package com.oupp.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	private int eid;

	private String name;
	private String email;
	private String designation;

	//constructors
	public Employee() {
		super();
	}

	public Employee(int eid, String name, String email, String designation) {
		super();
		this.eid = eid;
		this.name = name;
		this.email = email;
		this.designation = designation;
	}

	public int getEid() {
		return eid;
	}
	
	//getters and setters

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

}
