package com.proyecto.services;

import java.util.Comparator;

import com.proyecto.model.Car;


public abstract class CarComparator implements Comparator<Car> {

	protected boolean desc;
	protected boolean asc;
	
}

