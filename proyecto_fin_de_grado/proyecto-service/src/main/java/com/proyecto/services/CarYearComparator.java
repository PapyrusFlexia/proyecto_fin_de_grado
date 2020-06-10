package com.proyecto.services;

import java.util.Comparator;


import com.proyecto.model.Car;

public class CarYearComparator extends CarComparator implements Comparator<Car>{

	public CarYearComparator(boolean asc) {
		super.asc = asc;
	}
	
	/** Comparación del año de los coches
	 *
	 */
	@Override
	public int compare(Car car1, Car car2) {
		Integer valA = car1.getYear();
		Integer valB = car2.getYear();


		if (!asc) {
			return valA.compareTo(valB)*-1;
		}else {
			return valA.compareTo(valB);
		}

	}

	
}