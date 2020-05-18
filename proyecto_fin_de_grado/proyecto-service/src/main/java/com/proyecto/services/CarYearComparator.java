package com.proyecto.services;

import java.util.Comparator;


import com.proyecto.model.Car;

public class CarYearComparator extends CarComparator implements Comparator<Car> {

	public CarYearComparator(boolean desc) {
		super.desc = desc;
	}
	
	@Override
	public int compare(Car car1, Car car2) {
		Integer valA = car1.getYear();
		Integer valB = car2.getYear();

		int mult = -1;
		if (!desc) {
			mult = 1;
		}

		if (valA < valB) {
			return mult * -1;
		} else if (valA > valB) {
			return mult * 1;
		} else {
			return mult * (car1.getMake().compareTo(car2.getMake()));
		}
	}

	
}