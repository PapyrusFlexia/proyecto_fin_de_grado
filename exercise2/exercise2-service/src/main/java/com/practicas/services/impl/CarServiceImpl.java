package com.practicas.services.impl;

import java.util.ArrayList;
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

import com.practicas.dao.CarDao;
import com.practicas.model.Car;
import com.practicas.model.comparators.CarComparator;
import com.practicas.services.CarService;
import com.practicas.services.data.DatabaseJson;

@Service("carService")
public class CarServiceImpl implements CarService {

	public long totalCar;
	
	@Autowired
	private CarDao carDao;
	
	@PostConstruct
	public void init() {
		
	}
	
	/**
	 * Obtiene los coches de un rango, se precargan todos
	 * @param start inicio del rango
	 * @param stop fin del rango
	 * @return
	 */
	public List<Car> getCars(int start, int stop) {
		
		// comprobamos los parámetros de entrada
		
		//List<Car> listCar = DatabaseJson.loadDatabase().getDataParsed();
		//totalCar = listCar.size();
		int begin = start;
		if(begin < 0) {
			begin = 0;
		}
		int end = stop;
		// si end es mayor que la longitud, end lo asignamos a la longitud
		if(end <= 0 ) {
			end = 0;
		}
		
		return carDao.findPaginationCars(begin, end);
	}
	
	public long getTotalCar() {
		if(totalCar == 0) {
			getCars(-1, -1);
		}
		return totalCar;
	}
	
	public List<Car> getCars(){
		
		return getCars(-1, -1);
	}
	
	/**
	 * Obtiene los coches que cumplen un predicado
	 * @param start inicio
	 * @param end fin
	 * @param p Predicado
	 * @return
	 */
	public List<Car> getCars(int start, int end, Predicate<Car> p) {
		
		List<Car> cars = getCars(-1, -1);
		Stream<Car> stream = cars.stream();
		if(p != null) {
			stream = stream.filter(p);
			
		}
		
		return stream.collect(Collectors.toList()).subList(start, end);
	}
	
	/**
	 * Obtiene los coches que cumplen un predicado
	 * @param start inicio
	 * @param end fin
	 * @param p Predicado
	 * @return
	 */
	public List<Car> getCars(List<Predicate<Car>> ps) {
		
		Stream<Car> stream = getCars(-1, -1).stream();
		if(ps != null) {
			for(Predicate<Car> p: ps) {
				stream = stream.filter(p);
			}
		}
		List<Car> cars = stream.collect(Collectors.toList());
		return cars;
	}
	
	/**
	 * Obtiene los coches que cumplen un predicado
	 * @param start inicio
	 * @param end fin
	 * @param p Predicado
	 * @return
	 */
	public List<Car> getCars(int start, int end, List<Predicate<Car>> ps) {
		
		Stream<Car> stream = getCars(-1, -1).stream();
		if(ps != null) {
			for(Predicate<Car> p: ps) {
				stream = stream.filter(p);
			}
		}
		List<Car> cars = stream.collect(Collectors.toList()).subList(start, end);
		return cars;
	}
	
	/**
	 * Obtiene el número de coches que cumplen el predicado
	 * @param p
	 * @return
	 */
	public long getCarsCount(List<Predicate<Car>> ps) {
		
		Stream<Car> stream = getCars(-1, -1).stream();
		if(ps != null) {
			for(Predicate<Car> p: ps) {
				stream = stream.filter(p);
			}
		}
		return stream.count();
	}
	
	
	/**
	 * Obtiene el número de coches que cumplen el predicado
	 * @param p
	 * @return
	 */
	
	public List<Car> getCars(int start, int end, List<Predicate<Car>> p, CarComparator comparator){
		
		List<Car> cars = getCars( -1, -1, p);
		long total = getCarsCount(p);
		if(start < 0) {
			start = 0;
		}
		if(total < end) {
			end = (int)total;
		}
		
		if(comparator != null) {
			return cars.stream().sorted(comparator).collect(Collectors.toList()).subList(start, end);
		}
		
		return cars.stream().sorted().collect(Collectors.toList()).subList(start, end);
	}
	
	/*
	public List<Car> getCars(int start, int end, Predicate<Car> p, CarComparator comparator, int limit){
		
		List<Car> cars = getCars( start, end, p, comparator);
		return cars.stream().limit(limit).collect(Collectors.toList());
	}*/
	
	
	public Optional<Car> getCarByPk(int pk) {
		
		List<Car> cars = getCars(-1, -1);
		return cars.stream().filter(c -> c.getId() == pk).findFirst();
	}

	@Override
	public Car save(Car c) {
		return carDao.save(c);
	}
	
	
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

	public List<Car> getMarcaModeloHorsePower(int numberMax, int horsepower) {
		if (horsepower < 0) {
			return null;
		}

		Predicate<Car> p = new Predicate<Car>() {

			@Override
			public boolean test(Car t) {
				return t.getEngineinformation().getEnginestatistics().getHorsepower() > horsepower;
			}
		};

		List<Car> listCar = getMarcaModelo(-1, -1);
		// List<Car> listCarReturn = new ArrayList<>();
		// int counter = 0;
		List<Car> listCarReturn1 = listCar.stream().filter(p).limit(numberMax).collect(Collectors.toList());

		/*
		 * for (Car car : listCar) { if
		 * (car.getEngineinformation().getEnginestatistics().getHorsepower() >
		 * horsepower) { listCarReturn.add(car); counter++; if (counter >= numberMax) {
		 * break; } } }
		 */
		System.out.println(listCarReturn1.size());
		return listCarReturn1;

	}

	public List<Car> getMarcaModeloAutomaticos(String automatico) {
		if (!automatico.equals("Automatic transmission")) {
			return null;
		}

		Predicate<Car> p = new Predicate<Car>() {

			@Override
			public boolean test(Car t) {
				return t.getIdentification().getClassification().equals("Automatic transmission");
			}
		};

		List<Car> listCar = getMarcaModelo(-1, -1);
		// List<Car> listCarReturn = new ArrayList<>();
		// int counter = 0;
		List<Car> listCarReturn1 = listCar.stream().filter(p).collect(Collectors.toList());

		/*
		 * for (Car car : listCar) { if
		 * (car.getIdentification().getClassification().equals("Automatic transmission"
		 * )) { listCarReturn.add(car); counter++; if (counter >= listCar.size()) {
		 * break; } } }
		 */
		System.out.println(listCarReturn1.size());
		return listCarReturn1;

	}

	public List<Car> getMarcaModeloTraccionTrasera(String trasera) {
		if (!trasera.equals("Rear-wheel drive")) {
			return null;
		}

		Predicate<Car> p = new Predicate<Car>() {

			@Override
			public boolean test(Car t) {
				return t.getEngineinformation().getDriveline().equals("Rear-wheel drive");
			}
		};

		List<Car> listCar = getMarcaModelo(-1, -1);
		// List<Car> listCarReturn = new ArrayList<>();
		// int counter = 0;
		List<Car> listCarReturn1 = listCar.stream().filter(p).collect(Collectors.toList());

		/*
		 * for (Car car : listCar) { if
		 * (car.getEngineinformation().getDriveline().equals("Rear-wheel drive")) {
		 * listCarReturn.add(car); counter++; if (counter >= listCar.size()) { break; }
		 * } }
		 */
		System.out.println(listCarReturn1.size());
		return listCarReturn1;

	}

	public List<Car> getMarcaModeloDiesel(String diesel) {
		if (!diesel.equals("Diesel fuel")) {
			return null;
		}

		Predicate<Car> p = new Predicate<Car>() {

			@Override
			public boolean test(Car t) {
				return t.getFuelinformation().getFueltype().equals("Diesel fuel");
			}
		};

		List<Car> listCar = getMarcaModelo(-1, -1);
		// List<Car> listCarReturn = new ArrayList<>();
		// int counter = 0;
		List<Car> listCarReturn1 = listCar.stream().filter(p).collect(Collectors.toList());

		/*
		 * for (Car car : listCar) { if
		 * (car.getFuelinformation().getFueltype().equals("Diesel fuel")) {
		 * listCarReturn.add(car); counter++; if (counter >= listCar.size()) { break; }
		 * } }
		 */
		System.out.println(listCarReturn1.size());
		return listCarReturn1;

	}

	public List<Car> getMarcaModelo2011Potencia(int numberMax, int anno) {
		if (anno < 0) {
			return null;
		}

		Predicate<Car> p = new Predicate<Car>() {

			@Override
			public boolean test(Car t) {
				return t.getIdentification().getYear() == anno;
			}
		};

		List<Car> listCar = getMarcaModelo(-1, -1);
		boolean desc = false;
		List<Car> listCarReturn1 = listCar.stream().filter(car -> car.getIdentification().getYear() == anno)
				.sorted(new Comparator<Car>() {
					public int compare(Car a, Car b) {
						Integer valA = a.getEngineinformation().getEnginestatistics().getHorsepower();
						Integer valB = b.getEngineinformation().getEnginestatistics().getHorsepower();

						int mult = -1;
						if (!desc) {
							mult = 1;
						}

						if (valA < valB) {
							return mult * -1;
						} else if (valA > valB) {
							return mult * 1;
						} else {
							return mult * (a.getIdentification().getMake().compareTo(b.getIdentification().getMake()));
						}
					}
				}).limit(numberMax).collect(Collectors.toList());

		System.out.println(listCarReturn1.size());
		return listCarReturn1;

	}

	public List<Car> septimaPosicion(int nCharacter) {
		if (nCharacter < 0) {
			return null;
		}

		List<Car> listCar = getMarcaModelo(-1, -1);
		List<Car> listCarReturn1 = listCar.stream().filter(car -> {
			return Character.isDigit(car.getIdentification().getId().charAt(nCharacter));
		}).collect(Collectors.toList());

		System.out.println(listCarReturn1.size());
		return listCarReturn1;

	}

	public List<Car> getMarcaModeloHibrido(boolean hibrido) {
		if (hibrido != true) {
			return null;
		}
		Predicate<Car> p = new Predicate<Car>() {

			@Override
			public boolean test(Car t) {
				return t.getEngineinformation().isHybrid() == true;
			}
		};

		List<Car> listCar = getMarcaModelo(-1, -1);
		List<Car> listCarReturn1 = listCar.stream().filter(p).collect(Collectors.toList());

		System.out.println(listCarReturn1.size());
		return listCarReturn1;

	}

	public List<Car> velocidades(int velocidades) {
		if (velocidades != 6) {
			return null;
		}
		Predicate<Car> p = new Predicate<Car>() {

			@Override
			public boolean test(Car t) {
				return t.getEngineinformation().getNumberofforwardgears() == velocidades;
			}
		};

		List<Car> listCar = getMarcaModelo(-1, -1);
		List<Car> listCarReturn1 = listCar.stream().filter(p).collect(Collectors.toList());

		System.out.println(listCarReturn1.size());
		return listCarReturn1;

	}

	public List<Car> getCochesConsumo(int consumo) {
		if (consumo > 18) {
			return null;
		}

		Predicate<Car> p = new Predicate<Car>() {

			@Override
			public boolean test(Car t) {
				return t.getFuelinformation().getCitymph() < consumo;
			}
		};

		List<Car> listCar = getMarcaModelo(-1, -1);
		boolean desc = true;
		List<Car> listCarReturn1 = listCar.stream().filter(car -> car.getFuelinformation().getCitymph() < consumo)
				.sorted(new Comparator<Car>() {
					public int compare(Car a, Car b) {
						Integer valA = a.getFuelinformation().getCitymph();
						Integer valB = b.getFuelinformation().getCitymph();

						int mult = -1;
						if (desc) {
							mult = 1;
						}

						if (valA < valB) {
							return mult * -1;
						} else if (valA > valB) {
							return mult * 1;
						} else {
							return mult * (a.getIdentification().getMake().compareTo(b.getIdentification().getMake()));
						}
					}
				}).collect(Collectors.toList());

		System.out.println(listCarReturn1.size());
		return listCarReturn1;

	}

	public List<Car> hp(String palabra) {
		if (palabra.length() == 0) {
			return null;
		}

		List<Car> listCar = getMarcaModelo(-1, -1);
		List<Car> listCarReturn1 = listCar.stream()
				.filter(car -> car.getEngineinformation().getEnginetype().contains(palabra))
				.collect(Collectors.toList());

		System.out.println(listCarReturn1.size());
		return listCarReturn1;

	}

	public List<String> getCarsMakes() {
		List<Car> cars = getCars(-1, -1);
		List<String> carsMakes = new ArrayList<>();
		List<String> carsMakesSinDuplicados = new ArrayList<>(new HashSet<>(carsMakes));
		for (int i = 0; i < cars.size(); i++) {
			carsMakesSinDuplicados.add(cars.get(i).getIdentification().getMake());
		}
		return carsMakesSinDuplicados.stream().distinct().sorted().collect(Collectors.toList());
	}

	public List<Integer> getCarsYears() {
		List<Car> cars = getCars(-1, -1);
		List<Integer> carsYears = new ArrayList<>();
		List<Integer> carsYearsSinDuplicados = new ArrayList<>(new HashSet<>(carsYears));
		for (int i = 0; i < cars.size(); i++) {
			carsYearsSinDuplicados.add(cars.get(i).getIdentification().getYear());
		}
		return carsYearsSinDuplicados.stream().distinct().sorted().collect(Collectors.toList());
	}

	public List<Boolean> getCarsHybrids() {
		List<Car> cars = getCars(-1, -1);
		List<Boolean> carsHybrids = new ArrayList<>();
		List<Boolean> carsHybridsSinDuplicados = new ArrayList<>(new HashSet<>(carsHybrids));
		for (int i = 0; i < cars.size(); i++) {
			carsHybridsSinDuplicados.add(cars.get(i).getEngineinformation().isHybrid());
		}
		return carsHybridsSinDuplicados.stream().distinct().sorted().collect(Collectors.toList());
	}

	public List<String> getCarsClassificationsTabla() {
		List<Car> cars = getCars(-1, -1);
		List<String> carsClassifications = new ArrayList<>();
		List<String> carsClassificationsSinDuplicados = new ArrayList<>(new HashSet<>(carsClassifications));
		for (int i = 0; i < cars.size(); i++) {
			carsClassificationsSinDuplicados.add(cars.get(i).getIdentification().getClassification());
		}
		return carsClassificationsSinDuplicados.stream().distinct().sorted().collect(Collectors.toList());
	}

	public long getCarsCount(Predicate<Car> p) {
		return (long) getCars(-1, -1).stream().filter(p).count();
	}

	public long totalCar() {
		long totalCar = getCars(-1, -1).parallelStream().count();
		return totalCar;
	}

	public List<String> getCarsDrivelines() {
		List<Car> cars = getCars(-1, -1);
		List<String> carsDrivelines = new ArrayList<>();
		for (int i = 0; i < cars.size(); i++) {
			carsDrivelines.add(cars.get(i).getEngineinformation().getDriveline());
		}
		return carsDrivelines.stream().distinct().sorted().collect(Collectors.toList());
	}

	public List<String> getCarsClassifications() {
		List<Car> cars = getCars(-1, -1);
		List<String> carsClassifications = new ArrayList<>();
		for (int i = 0; i < cars.size(); i++) {
			carsClassifications.add(cars.get(i).getIdentification().getClassification());
		}
		return carsClassifications.stream().distinct().sorted().collect(Collectors.toList());
	}

	public List<Integer> getCarsAnnos() {
		List<Car> cars = getCars(-1, -1);
		List<Integer> carsYears = new ArrayList<>();
		for (int i = 0; i < cars.size(); i++) {
			carsYears.add(cars.get(i).getIdentification().getYear());
		}
		return carsYears.stream().distinct().sorted().collect(Collectors.toList());
	}

	public List<String> getCarsFuelTypes() {
		List<Car> cars = getCars(-1, -1);
		List<String> carsFuelTypes = new ArrayList<>();
		for (int i = 0; i < cars.size(); i++) {
			carsFuelTypes.add(cars.get(i).getFuelinformation().getFueltype());
		}
		return carsFuelTypes.stream().distinct().sorted().collect(Collectors.toList());
	}

	public List<Boolean> getHybrid() {
		List<Car> cars = getCars(-1, -1);
		List<Boolean> carsHybrid = new ArrayList<>();
		for (int i = 0; i < cars.size(); i++) {
			carsHybrid.add(cars.get(i).getEngineinformation().isHybrid());
		}
		return carsHybrid.stream().distinct().sorted().collect(Collectors.toList());
	}

	

	
	
	public List<Car> getCarsCompare(int start, int end, List<Predicate<Car>> ps, CarComparator comparator){
		long total = getCarsCount(ps);
		List<Car> cars = getCars(0, (int) total, ps); ///////////
		if(start < 0) {
			start = 0;
		}
		if(total < end) {
			end = (int) total;
		}
		if (comparator != null) {
			return cars.stream().sorted(comparator).collect(Collectors.toList()).subList(start, end);
		}
		return cars.stream().sorted(comparator).collect(Collectors.toList()).subList(start, end);
		
	}

	@Override
	public List<Car> getCars(int start, int end, Predicate<Car> p, CarComparator comparator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> getCarsSortMake(int begin, int end, List<Predicate<Car>> ps, CarComparator makecomparator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> getCars(int start, int end, Predicate<Car> p, CarComparator comparator, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}