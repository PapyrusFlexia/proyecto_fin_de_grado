package com.practicas.services;

import java.util.Comparator;

import com.practicas.model.Car;
import com.practicas.model.Identification;

public class CarMakeComparator extends CarComparator implements Comparator<Car> {

	public CarMakeComparator(boolean desc) {
		super.desc = desc;
	}
	
	@Override
	public int compare(Car o1, Car o2) {
		int compare = o1.getIdentification().getMake().compareTo(o2.getIdentification().getMake()); 
		
		return (desc)?compare: (-1)*compare;
	}

	
	

	
	
}