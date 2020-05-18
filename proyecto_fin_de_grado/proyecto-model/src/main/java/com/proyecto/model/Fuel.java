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
@Table(name="FUEL")
public class Fuel implements Serializable{

	private static final long serialVersionUID = 3988240899233372627L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Column(name="HIGHWAYMPG", nullable=false)
	private int highwayMpg;
	
	@NotNull
	@Column(name="CITYMPH", nullable=false)
	private int cityMph;
	
	@NotNull
	@Column(name="FUELTYPE", nullable=false)
	private String fuelType;
	
	public Fuel() {
		
	}

	public Fuel(int id, int highwayMpg, int cityMph, String fuelType) {
		super();
		this.id = id;
		this.highwayMpg = highwayMpg;
		this.cityMph = cityMph;
		this.fuelType = fuelType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHighwayMpg() {
		return highwayMpg;
	}

	public void setHighwayMpg(int highwayMpg) {
		this.highwayMpg = highwayMpg;
	}

	public int getCityMph() {
		return cityMph;
	}

	public void setCityMph(int cityMph) {
		this.cityMph = cityMph;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	
}

