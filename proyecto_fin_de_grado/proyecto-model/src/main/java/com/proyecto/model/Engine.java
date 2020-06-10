package com.proyecto.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ENGINE")
public class Engine implements Serializable {

	private Fuel fuel;

	private static final long serialVersionUID = 3988240899233372627L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Column(name = "DRIVELINE", nullable = false)
	private String driveline;

	@NotNull
	@Column(name = "TRANSMISSION", nullable = false)
	private String transmission;

	@NotNull
	@Column(name = "ENGINETYPE", nullable = false)
	private String enginetype;

	// Fuel

	@NotNull
	@ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "FUELTYPE_ID", referencedColumnName = "ID")
	private Fuel fueltype;

	public Engine() {

	}

	public Engine(Fuel fuel, int id, String driveline, String transmission, String enginetype, Fuel fueltype) {
		super();
		this.fuel = fuel;
		this.id = id;
		this.driveline = driveline;
		this.transmission = transmission;
		this.enginetype = enginetype;
		this.fueltype = fueltype;
	}

	public Fuel getFuel() {
		return fuel;
	}

	public void setFuel(Fuel fuel) {
		this.fuel = fuel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDriveline() {
		return driveline;
	}

	public void setDriveline(String driveline) {
		this.driveline = driveline;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public String getEnginetype() {
		return enginetype;
	}

	public void setEnginetype(String enginetype) {
		this.enginetype = enginetype;
	}

	public Fuel getFueltype() {
		return fueltype;
	}

	public void setFueltype(Fuel fueltype) {
		this.fueltype = fueltype;
	}

	@Override
	public String toString() {
		return "Engine [fuel=" + fuel + ", id=" + id + ", driveline=" + driveline + ", transmission=" + transmission
				+ ", enginetype=" + enginetype + ", fueltype=" + fueltype + "]";
	}

}
