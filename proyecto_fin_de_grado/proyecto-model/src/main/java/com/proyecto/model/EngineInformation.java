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
@Table(name="ENGINEINFORMATION")
public class EngineInformation implements Serializable{

	private static final long serialVersionUID = 3988240899233372627L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Column(name="TRANSMISSION", nullable=false)
	private String transmission;
	
	@NotNull
	@Column(name="ENGINETYPE", nullable=false)
	private String engineType;
	
	@NotNull
	@Column(name="ENGINESTATISTICS", nullable=false)
	private int engineStatistics;
	
	@NotNull
	@Column(name="HYBRID", nullable=false)
	private boolean hybrid;
	
	@NotNull
	@Column(name="NUMBEROFFORWARDGEARS", nullable=false)
	private int numberOfForwardGears;
	
	@NotNull
	@Column(name="DRIVELINE", nullable=false)
	private String driveline;
	
	public EngineInformation() {
		
	}

	public EngineInformation(int id, String transmission, String engineType, int engineStatistics, boolean hybrid,
			int numberOfForwardGears, String driveline) {
		super();
		this.id = id;
		this.transmission = transmission;
		this.engineType = engineType;
		this.engineStatistics = engineStatistics;
		this.hybrid = hybrid;
		this.numberOfForwardGears = numberOfForwardGears;
		this.driveline = driveline;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getDriveline() {
		return driveline;
	}

	public void setDriveline(String driveline) {
		this.driveline = driveline;
	}
	

	

	
}
