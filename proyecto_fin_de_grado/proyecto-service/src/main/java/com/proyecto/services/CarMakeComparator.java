package com.proyecto.services;

import java.util.Comparator;


import com.proyecto.model.Car;

public class CarMakeComparator extends CarComparator implements Comparator<Car> {

	public CarMakeComparator(boolean desc) {
		super.desc = desc;
	}
	
	@Override
	public int compare(Car o1, Car o2) {
		int compare = o1.getMake().compareTo(o2.getMake()); 
		
		return (desc)?compare: (-1)*compare;
	}

	
	

	
	
}