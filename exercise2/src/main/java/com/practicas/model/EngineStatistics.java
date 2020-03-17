package com.practicas.model;

public class EngineStatistics {
	
	public EngineStatistics(int horsepower, int torque) {
		super();
		this.horsepower = horsepower;
		this.torque = torque;
	}

	private int horsepower;
	private int torque;
	
	public EngineStatistics() {
		
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
	

}
