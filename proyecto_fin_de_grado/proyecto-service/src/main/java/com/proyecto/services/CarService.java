
package com.proyecto.services;

import java.util.List;

import java.util.Optional;
import java.util.function.Predicate;

import com.proyecto.model.Car;
import com.proyecto.model.Engine;
import com.proyecto.model.comparators.CarComparator;


public interface CarService {
	
	public  Car getCarByPk(int pk);

	public List<Car> getCars(int start, int end, List<Predicate<Car>> p, CarComparator comparator);

	public Car save(Car c);
	
	Engine saveEngine(Engine e);
	
	int update(int id, String transmission, String engineType, int horsepower, int torque,
			int numberofforwardgears, String driveline, String make, boolean hybrid, String modelyear, String name,
			String classification, int year, int width, int length, int height, int highwaympg, int citymph,
			String fuelType);
	
	int insert(Car c);
	
	int delete(int id);


	public List<Car> getCars();

	public long getTotalCar();

	public List<Car> getCars(int start, int stop);

	public List<Car> getCars(int start, int end, List<Predicate<Car>> ps);

	public List<Car> getCarsCount(int m);

	public List<Car> getCars(List<Predicate<Car>> ps);

	public List<String> getCarsMakes();

	public List<Integer> getCarsYears();

	//public List<Boolean> getCarsHybrids();

	public List<String> getCarsClassificationsTabla();


	public List<String> getCarsDrivelines();

	public List<String> getCarsClassifications();

	public List<Integer> getCarsAnnos();

	public List<String> getCarsFuelTypes();

	//public List<Boolean> getHybrid();
	
	public long  totalCar();

	public List<Car> getCarsCompare(int start, int end, List<Predicate<Car>> plist, CarComparator carComparator);



	



	

}
