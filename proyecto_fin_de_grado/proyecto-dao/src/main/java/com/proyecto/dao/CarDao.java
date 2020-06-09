package com.proyecto.dao;

import java.util.List;

import com.proyecto.model.Car;
import com.proyecto.model.Classification;
import com.proyecto.model.Engine;
import com.proyecto.model.User;

public interface CarDao {

	public List<Car> findPaginationCars(int pageSize, int paginaActual);

	Car save(Car c);

	int update(int id, String transmission, String enginetype, int horsepower, int torque, int numberofforwardgears,
			String driveline, String make, boolean hybrid, String modelyear, String name, String classification,
			int year, int width, int length, int height, int highwaympg, int citymph, String fuelType);

	int insert(int id, String transmission, String enginetype, int horsepower, int torque, int numberofforwardgears,
			int pk, String driveline, String make, String modelyear, String name, String classification, int year,
			int width, int length, int height, int highwaympg, int citymph, String fuelType);

	int delete(int id);

	long totalCar();

	void deleteById(String id);

	List<Car> findAllCars();

	List<Integer> getCarsNumberOfForwardGears();

	List<Integer> getCarsYears();

	List<String> getCarsMakes();

	List<String> getCarsNames();

	List<Integer> getCarsId();

	List<Integer> getCarsPk();

	List<Car> getCarsMakesFilter(int m);

	List<Car> findYearByName(int annoFiltro);

	List<Boolean> getCarsHybrids();

	List<Car> findHybridByName(Boolean name);

	List<Car> findClassificationByName(int name);

	List<Car> findMakeByName(String name);

	Car getByPk(Integer key);
}