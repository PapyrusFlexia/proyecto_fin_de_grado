package com.proyecto.dao;

import java.util.List;


import com.proyecto.model.Car;
import com.proyecto.model.Classification;
import com.proyecto.model.Make;


public interface CarDao {

	public List<Car> findPaginationCars(int pageSize, int paginaActual);
	
	Car save(Car c);
	
	int update(int id, String transmission, String engineType, int horsepower, int torque, boolean hybrid,
			int numberofforwardgears, String driveline, String make, String modelyear, String name,
			String classification, int year, int width, int length, int height, int highwaympg, int citymph,
			String fuelType);

	long totalCar();

	List<Integer> getCarsNumberOfForwardGears();

	List<Integer> getCarsYears();
	
	List<Boolean> getCarsHybrids();
	
	List<Make> getCarsMakesFilter(int m);
	
	List<Car> findYearByName(Integer annoFiltro);
	
	List<Car> findHybridByName(Boolean hybridFiltro);
	
	List<Car> findClassificationByName(String name);
	
	List<Car> findMakeByName(String name);
	
	Car getByPk(Integer key);
}