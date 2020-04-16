package com.practicas.services;

import java.util.Comparator;

import com.practicas.model.Car;
import com.practicas.model.Identification;

public class CarYearComparator extends CarComparatorId implements Comparator<Identification> {

	public CarYearComparator(boolean desc) {
		super.desc = desc;
	}
	
	@Override
	public int compare(Identification car1, Identification car2) {
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