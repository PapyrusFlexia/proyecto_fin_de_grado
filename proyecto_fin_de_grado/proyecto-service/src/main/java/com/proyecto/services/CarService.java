package com.proyecto.services;

import java.util.List;



import java.util.Optional;
import java.util.function.Predicate;

import com.proyecto.model.Booking;
import com.proyecto.model.Car;
import com.proyecto.model.CarImage;
import com.proyecto.model.Engine;
import com.proyecto.model.Rating;
import com.proyecto.model.comparators.CarComparator;
import com.proyecto.model.User;


public interface CarService {
	
	public  Car getCarByPk(int pk);

	public List<Car> getCars(int start, int end, List<Predicate<Car>> p, CarComparator comparator);

	public Car save(Car c);
	
	public User saveUser(User u);
	
	public CarImage saveImage(CarImage ci);
	
	public Booking saveBooking(Booking b); 
	
	public Rating saveRating(Rating r);
	
	Engine saveEngine(Engine e);
	
	int update(int id, String transmission, String engineType, int horsepower, int torque,
			int numberofforwardgears, String driveline, String make, boolean hybrid, String modelyear, String name,
			String classification, int year, int width, int length, int height, int highwaympg, int citymph,
			String fuelType);
	
	int insert(Car c);
	
	int insertImage(CarImage ci); 
	
	int insertUser(User u);
	
	int insertBooking(Booking b);
	
	int delete(int id);

	public List<Car> getCars();

	public long getTotalCar();

	public List<Car> getCars(int start, int stop);

	public List<Car> getCars(int start, int end, List<Predicate<Car>> ps);

	public List<Car> getCarsCount(int m);

	public List<Car> getCars(List<Predicate<Car>> ps);

	public List<String> getCarsMakes();

	public List<Integer> getCarsYears();

	public List<String> getCarsClassificationsTabla();

	public List<String> getCarsDrivelines();

	public List<String> getCarsClassifications();

	public List<Integer> getCarsAnnos();

	public List<String> getCarsFuelTypes();
	
	public long  totalCar();

	public List<Car> getCarsCompare(int start, int end, List<Predicate<Car>> plist, CarComparator carComparator);

	CarImage getCarImageByCarPk(int carid);

}