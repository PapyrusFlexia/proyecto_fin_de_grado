package com.proyecto.services;

import java.util.function.Predicate;


import com.proyecto.model.Car;

public class CarFiltro {
/**public Predicate<Car> hibrido(boolean hibrido) {
		return car -> car.getHybrid() == hibrido;
	}*/

	public Predicate<Car> velocidades(int velocidades) {
		return car -> car.getEngine().getNumberOfForwardGears() == velocidades;
	}

	public Predicate<Car> consumoMenor(int cantidad) {
		return car -> car.getFuel().getCityMph() < cantidad;
	}

	public Predicate<Car> consumoMayor(int cantidad) {
		return car -> car.getFuel().getCityMph() > cantidad;
	}

	public Predicate<Car> motor(String caracteres) {
		return car -> car.getEngine().getEngineType().toLowerCase().contains(caracteres.toLowerCase());
	}

	public Predicate<Car> caracterNumerico(int indice) {
		return car -> (int) car.getName().charAt(indice + 1) >= 48
				&& (int) car.getName().charAt(indice) <= 57;
	}

	public Predicate<Car> anno(int anno) {
		return car -> car.getYear() == anno;
	}
	
	public Predicate<Car> make(String make) {
		return car -> car.getMake().equals(make);
	}

	public Predicate<Car> tipoFuel(String fuel) {
		return car -> car.getFuel().getFuelType().equals(fuel);
	}

	public Predicate<Car> tipoTraccion(String traccion) {
		return car -> car.getEngine().getDriveline().equals(traccion);
	}

	public Predicate<Car> clasificacion(String clasificacion) {
		return car -> car.getClassification().equals(clasificacion);
	}

	public Predicate<Car> potenciaMayor(int potencia) {
		return car -> car.getHorsepower() > potencia;
	}

	public Predicate<Car> potenciaMenor(int potencia) {
		return car -> car.getHorsepower() < potencia;
	}
}