package com.proyecto.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="IDENTIFICATION")
public class Identification implements Serializable{

	private static final long serialVersionUID = 3988240899233372627L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Column(name="MAKE", nullable=false)
	private String make;
	
	@NotNull
	@Column(name="MODELYEAR", nullable=false)
	private String modelYear;
	
	@NotNull
	@Column(name="NAME", nullable=false)
	private String name;
	
	@NotNull
	@Column(name="CLASSIFICATION", nullable=false)
	private String classification;
	
	@NotNull
	@Column(name="YEAR", nullable=false)
	private int year;
	
	
	public Identification() {
		
	}


	public Identification(int id, String make, String modelYear, String name, String classification, int year) {
		super();
		this.id = id;
		this.make = make;
		this.modelYear = modelYear;
		this.name = name;
		this.classification = classification;
		this.year = year;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getMake() {
		return make;
	}


	public void setMake(String make) {
		this.make = make;
	}


	public String getModelYear() {
		return modelYear;
	}


	public void setModelYear(String modelYear) {
		this.modelYear = modelYear;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getClassification() {
		return classification;
	}


	public void setClassification(String classification) {
		this.classification = classification;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}

	
	

	
}