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
@Table(name = "ENGINEINFORMATION")
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
	private String engineType;

	@NotNull
	@Column(name = "ENGINESTATISTICS", nullable = false)
	private int engineStatistics;

	@NotNull
	@Column(name = "HYBRID", nullable = false)
	private boolean hybrid;

	@NotNull
	@Column(name = "NUMBEROFFORWARDGEARS", nullable = false)
	private int numberOfForwardGears;

	@NotNull
	@Column(name = "HORSEPOWER", nullable = false) ///////// CAMBIADO
	private int horsepower;

	@NotNull
	@Column(name = "TORQUE", nullable = false) ///////// CAMBIADO
	private int torque;

	// Fuel

	@NotNull
	@Column(name = "CITYMPH", nullable = false)
	private int citymph;

	@NotNull
	@ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "FUELTYPE_ID", referencedColumnName = "ID")
	private Fuel fueltype;

	@NotNull
	@Column(name = "HIGHWAYMPG", nullable = false)
	private int highwaympg;

	public Engine() {

	}

	public Engine(Fuel fuel, int id, String driveline, String transmission, String engineType, int engineStatistics,
			boolean hybrid, int numberOfForwardGears, int horsepower, int torque, int citymph, Fuel fueltype,
			int highwaympg) {
		super();
		this.fuel = fuel;
		this.id = id;
		this.driveline = driveline;
		this.transmission = transmission;
		this.engineType = engineType;
		this.engineStatistics = engineStatistics;
		this.hybrid = hybrid;
		this.numberOfForwardGears = numberOfForwardGears;
		this.horsepower = horsepower;
		this.torque = torque;
		this.citymph = citymph;
		this.fueltype = fueltype;
		this.highwaympg = highwaympg;
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

	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	public int getEngineStatistics() {
		return engineStatistics;
	}

	public void setEngineStatistics(int engineStatistics) {
		this.engineStatistics = engineStatistics;
	}

	public boolean isHybrid() {
		return hybrid;
	}

	public void setHybrid(boolean hybrid) {
		this.hybrid = hybrid;
	}

	public int getNumberOfForwardGears() {
		return numberOfForwardGears;
	}

	public void setNumberOfForwardGears(int numberOfForwardGears) {
		this.numberOfForwardGears = numberOfForwardGears;
	}

	public int getHorsepower() {
		return horsepower;
	}

	public void setHorsepower(int horsepower) {
		this.horsepower = horsepower;
	}

	public int getTorque() {
		return torque;
	}

	public void setTorque(int torque) {
		this.torque = torque;
	}

	public int getCitymph() {
		return citymph;
	}

	public void setCitymph(int citymph) {
		this.citymph = citymph;
	}

	public Fuel getFueltype() {
		return fueltype;
	}

	public void setFueltype(Fuel fueltype) {
		this.fueltype = fueltype;
	}

	public int getHighwaympg() {
		return highwaympg;
	}

	public void setHighwaympg(int highwaympg) {
		this.highwaympg = highwaympg;
	}

	@Override
	public String toString() {
		return "Engine [fuel=" + fuel + ", id=" + id + ", driveline=" + driveline + ", transmission=" + transmission
				+ ", engineType=" + engineType + ", engineStatistics=" + engineStatistics + ", hybrid=" + hybrid
				+ ", numberOfForwardGears=" + numberOfForwardGears + ", horsepower=" + horsepower + ", torque=" + torque
				+ ", citymph=" + citymph + ", fueltype=" + fueltype + ", highwaympg=" + highwaympg + "]";
	}

}
