package com.proyecto.services.impl;

import java.util.ArrayList;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.dao.BookingDao;
import com.proyecto.dao.CarDao;
import com.proyecto.dao.CarImageDao;
import com.proyecto.dao.EngineDao;
import com.proyecto.dao.RatingDao;
import com.proyecto.dao.UserDao;
import com.proyecto.model.Booking;
import com.proyecto.model.Car;
import com.proyecto.model.CarImage;
import com.proyecto.model.Classification;
import com.proyecto.model.DriveLine;
import com.proyecto.model.Engine;
import com.proyecto.model.Fuel;
import com.proyecto.model.Rating;
import com.proyecto.model.Transmission;
import com.proyecto.model.User;
import com.proyecto.model.comparators.CarComparator;
import com.proyecto.services.CarService;
import com.proyecto.services.data.DatabaseJson;

@Service("carService")
public class CarServiceImpl implements CarService {

	public long totalCar;

	@Autowired
	private CarDao carDao;
	
	@Autowired
	private CarImageDao carImageDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BookingDao bookingDao;
	
	@Autowired
	private RatingDao ratingDao;

	@Autowired
	private EngineDao engineDao;

	@PostConstruct
	public void init() {

	}

	/**
	 * Obtiene los coches de un rango, se precargan todos
	 * 
	 * @param start inicio del rango
	 * @param stop  fin del rango
	 * @return
	 */
	public List<Car> getCars(int pageSize, int paginaActual) {

		return carDao.findPaginationCars(pageSize, paginaActual);
	}

	/** Recoge todos los coches
	 *
	 */
	public long getTotalCar() {
		if (totalCar == 0) {
			getCars(-1, -1);
		}
		return totalCar;
	}

	public List<Car> getCars() {

		return getCars(-1, -1);
	}

	/**
	 * Obtiene los coches que cumplen un predicado
	 * 
	 * @param start inicio
	 * @param end   fin
	 * @param p     Predicado
	 * @return
	 */
	public List<Car> getCars(int start, int end, Predicate<Car> p) {

		List<Car> cars = getCars(-1, -1);
		Stream<Car> stream = cars.stream();
		if (p != null) {
			stream = stream.filter(p);

		}

		return stream.collect(Collectors.toList()).subList(start, end);
	}

	/**
	 * Obtiene los coches que cumplen un predicado
	 * 
	 * @param start inicio
	 * @param end   fin
	 * @param p     Predicado
	 * @return
	 */
	public List<Car> getCars(List<Predicate<Car>> ps) {

		Stream<Car> stream = getCars(-1, -1).stream();
		if (ps != null) {
			for (Predicate<Car> p : ps) {
				stream = stream.filter(p);
			}
		}
		List<Car> cars = stream.collect(Collectors.toList());
		return cars;
	}

	/**
	 * Obtiene los coches que cumplen un predicado
	 * 
	 * @param start inicio
	 * @param end   fin
	 * @param p     Predicado
	 * @return
	 */
	public List<Car> getCars(int start, int end, List<Predicate<Car>> ps) {

		Stream<Car> stream = getCars(-1, -1).stream();
		if (ps != null) {
			for (Predicate<Car> p : ps) {
				stream = stream.filter(p);
			}
		}
		List<Car> cars = stream.collect(Collectors.toList()).subList(start, end);
		return cars;
	}

	/**
	 * Obtiene el número de coches que cumplen el predicado
	 * 
	 * @param p
	 * @return
	 */
	public long getCarsCount(List<Predicate<Car>> ps) {

		Stream<Car> stream = getCars(-1, -1).stream();
		if (ps != null) {
			for (Predicate<Car> p : ps) {
				stream = stream.filter(p);
			}
		}
		return stream.count();
	}

	/**
	 * Obtiene el número de coches que cumplen el predicado
	 * 
	 * @param p
	 * @return
	 */

	public List<Car> getCars(int start, int end, List<Predicate<Car>> p, CarComparator comparator) {

		List<Car> cars = getCars(-1, -1, p);
		long total = getCarsCount(p);
		if (start < 0) {
			start = 0;
		}
		if (total < end) {
			end = (int) total;
		}

		if (comparator != null) {
			return cars.stream().sorted(comparator).collect(Collectors.toList()).subList(start, end);
		}

		return cars.stream().sorted().collect(Collectors.toList()).subList(start, end);
	}

	/* Llamadas al Dao */
	
	@Override
	public Car getCarByPk(int pk) {
		return carDao.getByPk(pk);
	}
	
	@Override
	public CarImage getCarImageByCarPk(int carid) {
		return carImageDao.getCarImageByCarId(carid);
	}


	@Override
	public Car save(Car c) {
		return carDao.save(c);
	}
	
	@Override
	public CarImage saveImage(CarImage ci) {
		return carImageDao.saveImage(ci);
	}
	
	
	@Override
	public User saveUser(User u) {
		return userDao.save(u);
	}
	
	@Override
	public Booking saveBooking(Booking b) {
		return bookingDao.saveBooking(b);
	}
	
	@Override
	public Rating saveRating(Rating r) {
		return ratingDao.saveRating(r);
	}


	@Override
	public Engine saveEngine(Engine e) {
		return engineDao.save(e);
	}

	@Override
	public int update(int id, String transmission, String engineType, int horsepower, int torque,
			int numberofforwardgears, String driveline, String make, boolean hybrid, String modelyear, String name,
			String classification, int year, int width, int length, int height, int highwaympg, int citymph,
			String fuelType) {

		return carDao.update(id, transmission, engineType, horsepower, torque, numberofforwardgears, driveline, make, hybrid,
				modelyear, name, classification, year, width, length, height, highwaympg, citymph, fuelType);
	}

	@Override 
	public int insert(Car c) {
		
		carDao.save(c);
		
		return 0;
	}
	
	@Override 
	public int insertImage(CarImage ci) {
		
		carImageDao.saveImage(ci);
		
		return 0;
	}
	
	@Override 
	public int insertUser(User u) {
		
		userDao.save(u);
		
		return 0;
	
	}
	
	@Override 
	public int insertBooking(Booking b) {
		
		bookingDao.saveBooking(b);
		
		return 0;
	}


	@Override
	public int delete(int id) {
		return carDao.delete(id);

	}

	/** Obtiene marcas y modelos de los coches
	 * @param start
	 * @param stop
	 * @return
	 */
	public List<Car> getMarcaModelo(int start, int stop) {

		// comprobamos los parametros de entrada

		if (start > stop) {
			return null;

		}
		List<Car> listCar = DatabaseJson.loadDatabase().getDataParsed();

		int begin = start;
		if (begin < 0) {
			begin = 0;
		}

		int end = stop;

		if (end <= 0 || end > listCar.size()) {
			end = listCar.size();
		}

		return listCar.subList(begin, end);

	}

	/**  Obtiene marcas, modelos y caballos de potencia de los coches
	 * @param numberMax
	 * @param horsepower
	 * @return
	 */
	public List<Car> getMarcaModeloHorsePower(int numberMax, int horsepower) {
		if (horsepower < 0) {
			return null;
		}

		Predicate<Car> p = new Predicate<Car>() {

			@Override
			public boolean test(Car t) {
				return t.getHorsepower() > horsepower;
			}
		};

		List<Car> listCar = getMarcaModelo(-1, -1);
		List<Car> listCarReturn1 = listCar.stream().filter(p).limit(numberMax).collect(Collectors.toList());

		System.out.println(listCarReturn1.size());
		return listCarReturn1;

	}

	/**  Obtiene marcas y modelos de los coches cuya clsificación sea automática
	 * @param automatico
	 * @return
	 */
	public List<Car> getMarcaModeloAutomaticos(String automatico) {
		if (!automatico.equals("Automatic transmission")) {
			return null;
		}

		Predicate<Car> p = new Predicate<Car>() {

			@Override
			public boolean test(Car t) {
				return t.getClassification().equals("Automatic transmission");
			}
		};

		List<Car> listCar = getMarcaModelo(-1, -1);
		List<Car> listCarReturn1 = listCar.stream().filter(p).collect(Collectors.toList());

		System.out.println(listCarReturn1.size());
		return listCarReturn1;

	}

	/**  Obtiene marcas de los coches
	 *
	 */
	public List<String> getCarsMakes() {
		List<Car> cars = getCars(-1, -1);
		List<String> carsMakes = new ArrayList<>();
		List<String> carsMakesSinDuplicados = new ArrayList<>(new HashSet<>(carsMakes));
		for (int i = 0; i < cars.size(); i++) {
			carsMakesSinDuplicados.add(cars.get(i).getMake());
		}
		return carsMakesSinDuplicados.stream().distinct().sorted().collect(Collectors.toList());
	}

	/**  Obtiene años de los coches
	 *
	 */
	public List<Integer> getCarsYears() {
		List<Car> cars = getCars(-1, -1);
		List<Integer> carsYears = new ArrayList<>();
		List<Integer> carsYearsSinDuplicados = new ArrayList<>(new HashSet<>(carsYears));
		for (int i = 0; i < cars.size(); i++) {
			carsYearsSinDuplicados.add(cars.get(i).getYear());
		}
		return carsYearsSinDuplicados.stream().distinct().sorted().collect(Collectors.toList());
	}

	/**  Obtiene clasificaciones de los coches
	 *
	 */
	public List<String> getCarsClassificationsTabla() {
		List<Car> cars = getCars(-1, -1);
		List<String> carsClassifications = new ArrayList<>();
		List<String> carsClassificationsSinDuplicados = new ArrayList<>(new HashSet<>(carsClassifications));
		for (int i = 0; i < cars.size(); i++) {
			carsClassificationsSinDuplicados.addAll((Collection<? extends String>) cars.get(i).getClassification());
		}
		return carsClassificationsSinDuplicados.stream().distinct().sorted().collect(Collectors.toList());
	}

	public List<Car> getCarsCount(int m) {

		return carDao.getCarsMakesFilter(m);
	}

	public long totalCar() {
		long totalCar = carDao.totalCar();
		return totalCar;
	}

	/**  Obtiene drivelines de los coches
	 *
	 */
	public List<String> getCarsDrivelines() {
		List<Car> cars = getCars(-1, -1);
		List<String> carsDrivelines = new ArrayList<>();
		for (int i = 0; i < cars.size(); i++) {
			carsDrivelines.addAll((Collection<? extends String>) cars.get(i).getDriveline());
		}
		return carsDrivelines.stream().distinct().sorted().collect(Collectors.toList());
	}

	/**  Obtiene clasificaciones de los coches
	 *
	 */
	public List<String> getCarsClassifications() {
		List<Car> cars = getCars(-1, -1);
		List<String> carsClassifications = new ArrayList<>();
		for (int i = 0; i < cars.size(); i++) {
			carsClassifications.addAll((Collection<? extends String>) cars.get(i).getClassification());
		}
		return carsClassifications.stream().distinct().sorted().collect(Collectors.toList());
	}

	/**  Obtiene años de los coches
	 *
	 */
	public List<Integer> getCarsAnnos() {
		List<Car> cars = getCars(-1, -1);
		List<Integer> carsYears = new ArrayList<>();
		for (int i = 0; i < cars.size(); i++) {
			carsYears.add(cars.get(i).getYear());
		}
		return carsYears.stream().distinct().sorted().collect(Collectors.toList());
	}

	/**  Obtiene tipos de combustibles de los coches
	 *
	 */
	public List<String> getCarsFuelTypes() {
		List<Car> cars = getCars(-1, -1);
		List<String> carsFuelTypes = new ArrayList<>();
		for (int i = 0; i < cars.size(); i++) {
			carsFuelTypes.addAll((Collection<? extends String>) cars.get(i).getFueltype());
		}
		return carsFuelTypes.stream().distinct().sorted().collect(Collectors.toList());
	}

	/**  Obtiene transmisiones de los coches
	 * @return
	 */
	public List<String> getCarsTransmissions() {
		List<Car> cars = getCars(-1, -1);
		List<String> carsTransmissions = new ArrayList<>();
		for (int i = 0; i < cars.size(); i++) {
			carsTransmissions.addAll((Collection<? extends String>) cars.get(i).getTransmission());
		}
		return carsTransmissions.stream().distinct().sorted().collect(Collectors.toList());
	}

	/** Comparación de coches
	 *
	 */
	public List<Car> getCarsCompare(int start, int end, List<Predicate<Car>> ps, CarComparator comparator) {
		long total = getCarsCount(ps);
		List<Car> cars = getCars(0, (int) total, ps); 
		if (start < 0) {
			start = 0;
		}
		if (total < end) {
			end = (int) total;
		}
		if (comparator != null) {
			return cars.stream().sorted(comparator).collect(Collectors.toList()).subList(start, end);
		}
		return cars.stream().sorted(comparator).collect(Collectors.toList()).subList(start, end);

	}

}