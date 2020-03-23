package com.practicas.model.comparators;

import java.util.Comparator;

import com.practicas.model.Car;

public class CarByGasTypeComparator extends CarComparator implements Comparator<Car> {

	public CarByGasTypeComparator(boolean asc) {

		super.asc = asc;
	}
	
	@Override
	public int compare(Car o1, Car o2) {

		return 0;
	}

}
