package com.proyecto.services;

import java.util.Comparator;


import com.proyecto.model.Car;

public class CarMakeComparator extends CarComparator implements Comparator<Car>{
	
	public CarMakeComparator(boolean asc) {
		super.asc = asc;
	}
	
	@Override
	public int compare(Car car1, Car car2) {

		int mult = 1;
		if (!asc) {
			mult = -1;
		}

		return mult * (car1.getMake().compareTo(car2.getMake()));

	}
	
}