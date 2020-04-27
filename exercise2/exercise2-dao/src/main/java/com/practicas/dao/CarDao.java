package com.practicas.dao;

import java.util.List;

import com.practicas.model.Car;


public interface CarDao {

	List<Car> findPaginationCars(int start, int end);
	
	Car save(Car c);

	long totalCar();

	List<Integer> getCarsNumberOfForwardGears();

	List<Integer> getCarsYears();
}