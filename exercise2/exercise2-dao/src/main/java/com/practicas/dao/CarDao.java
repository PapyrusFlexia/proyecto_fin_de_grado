package com.practicas.dao;

import java.util.List;

import com.practicas.model.Car;


public interface CarDao {

	List<Car> findPaginationCars(int start, int end);
	
	Car save(Car c);
	
	int update(int id, String transmission, String engineType, int horsepower, int torque, boolean hybrid,
			int numberofforwardgears, String driveline, String make, String modelyear, String name,
			String classification, int year, int width, int length, int height, int highwaympg, int citymph,
			String fuelType);

	long totalCar();

	List<Integer> getCarsNumberOfForwardGears();

	List<Integer> getCarsYears();
	
	Car getByPk(Integer key);
}