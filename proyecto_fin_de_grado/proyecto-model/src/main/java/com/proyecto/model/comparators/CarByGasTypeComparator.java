package com.proyecto.model.comparators;

import java.util.Comparator;


import com.proyecto.model.Car;

public class CarByGasTypeComparator extends CarComparator implements Comparator<Car> {

	public CarByGasTypeComparator(boolean asc) {

		super.asc = asc;
	}
	
	@Override
	public int compare(Car o1, Car o2) {

		int compare = o1.getFuel().getFuelType().compareTo(o1.getFuel().getFuelType()); 
		
		return (asc)?compare: (-1)*compare;
	}

}