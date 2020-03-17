package com.practicas.model;

public class Car {
	
	private EngineInformation engineinformation;
	private Dimensions dimensions;
	private Identification identification;
	
	public Car() {
		
	}

	public Car(EngineInformation engineinformation, Dimensions dimensions, Identification identification) {
		super();
		this.engineinformation = engineinformation;
		this.dimensions = dimensions;
		this.identification = identification;
	}

	public EngineInformation getEngineinformation() {
		return engineinformation;
	}

	public void setEngineinformation(EngineInformation engineinformation) {
		this.engineinformation = engineinformation;
	}

	public Dimensions getDimensions() {
		return dimensions;
	}

	public void setDimensions(Dimensions dimensions) {
		this.dimensions = dimensions;
	}

	public Identification getIdentification() {
		return identification;
	}

	public void setIdentification(Identification identification) {
		this.identification = identification;
	}
	
	
	
	

}
