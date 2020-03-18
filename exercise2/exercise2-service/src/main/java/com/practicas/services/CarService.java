package com.practicas.services;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.practicas.model.Car;
import com.practicas.services.data.DatabaseJson;

public class CarService {

	public static List<Car> getMarcaModelo(int start, int stop) {

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

	public static List<Car> getMarcaModeloHorsePower(int numberMax, int horsepower) {
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
		List<Car> listCarReturn = new ArrayList<>();
		int counter = 0;
		List<Car> listCarReturn1 = listCar.stream().filter(p).limit(numberMax).collect(Collectors.toList());

		for (Car car : listCar) {
			if (car.getEngineinformation().getEnginestatistics().getHorsepower() > horsepower) {
				listCarReturn.add(car);
				counter++;
				if (counter >= numberMax) {
					break;
				}
			}
		}
		System.out.println(listCarReturn1.size());
		return listCarReturn;

	}

	public static List<Car> getMarcaModeloAutomaticos(String automatico) {
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
		List<Car> listCarReturn = new ArrayList<>();
		int counter = 0;
		List<Car> listCarReturn1 = listCar.stream().filter(p).collect(Collectors.toList());

		for (Car car : listCar) {
			if (car.getIdentification().getClassification().equals("Automatic transmission")) {
				listCarReturn.add(car);
				counter++;
				if (counter >= listCar.size()) {
					break;
				}
			}
		}
		System.out.println(listCarReturn1.size());
		return listCarReturn;

	}

	public static List<Car> getMarcaModeloTraccionTrasera(String trasera) {
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
		List<Car> listCarReturn = new ArrayList<>();
		int counter = 0;
		List<Car> listCarReturn1 = listCar.stream().filter(p).collect(Collectors.toList());

		for (Car car : listCar) {
			if (car.getEngineinformation().getDriveline().equals("Rear-wheel drive")) {
				listCarReturn.add(car);
				counter++;
				if (counter >= listCar.size()) {
					break;
				}
			}
		}
		System.out.println(listCarReturn1.size());
		return listCarReturn;

	}

	public static List<Car> getMarcaModeloDiesel(String diesel) {
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
		List<Car> listCarReturn = new ArrayList<>();
		int counter = 0;
		List<Car> listCarReturn1 = listCar.stream().filter(p).collect(Collectors.toList());

		for (Car car : listCar) {
			if (car.getFuelinformation().getFueltype().equals("Diesel fuel")) {
				listCarReturn.add(car);
				counter++;
				if (counter >= listCar.size()) {
					break;
				}
			}
		}
		System.out.println(listCarReturn1.size());
		return listCarReturn;

	}

	public static List<Car> getMarcaModelo2011Potencia(int numberMax, int anno, boolean asc) {
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
		List<Car> listCarReturn = new ArrayList<>();
		List<Car> sortedList = listCarReturn.stream().sorted().collect(Collectors.toList());  
		int counter = 0;
		List<Car> listCarReturn1 = listCar.stream().filter(p).limit(numberMax).collect(Collectors.toList());

		for (Car car : listCar) {
			if (car.getIdentification().getYear() == anno) {
				sortedList.add(car);
				counter++;
				
				
				if (counter >= numberMax) {
					break;
				}
			}
		}
		System.out.println(listCarReturn1.size());
		return sortedList;

	}

}
