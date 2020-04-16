package com.practicas.services;

import java.util.function.Predicate;

import com.practicas.model.Car;

public class CarPredicate {
	public Predicate<Car> esHibrido(boolean hibrido) {
		return car -> car.getEngineinformation().isHybrid() == hibrido;
	}

	public Predicate<Car> velocidades(int velocidades) {
		return car -> car.getEngineinformation().getNumberofforwardgears() == velocidades;
	}

	public Predicate<Car> consumoCiudadMenorA(int cantidad) {
		return car -> car.getFuelinformation().getCitymph() < cantidad;
	}

	public Predicate<Car> consumoCiudadMayorA(int cantidad) {
		return car -> car.getFuelinformation().getCitymph() > cantidad;
	}

	public Predicate<Car> incluyeEnMotor(String caracteres) {
		return car -> car.getEngineinformation().getEnginetype().toLowerCase().contains(caracteres.toLowerCase());
	}
	
	public Predicate<Car> incluyeEnMarca(String caracteres) {
		return car -> car.getIdentification().getMake().toLowerCase().contains(caracteres.toLowerCase());
	}

	public Predicate<Car> caracterNumericoEnId(int indice) {
		return car -> (int) car.getIdentification().getId().charAt(indice + 1) >= 48
				&& (int) car.getIdentification().getId().charAt(indice) <= 57;
	}

	public Predicate<Car> cochesPorAnno(int anno) {
		return car -> car.getIdentification().getYear() == anno;
	}

	public Predicate<Car> tipoFuel(String fuel) {
		return car -> car.getFuelinformation().getFueltype().equals(fuel);
	}

	public Predicate<Car> tipoTraccion(String traccion) {
		return car -> car.getEngineinformation().getDriveline().equals(traccion);
	}

	public Predicate<Car> tipoClasificacion(String clasificacion) {
		return car -> car.getIdentification().getClassification().equals(clasificacion);
	}

	public Predicate<Car> porPotenciaMayor(int potencia) {
		return car -> car.getEngineinformation().getEnginestatistics().getHorsepower() > potencia;
	}

	public Predicate<Car> porPotenciaMenor(int potencia) {
		return car -> car.getEngineinformation().getEnginestatistics().getHorsepower() < potencia;
	}
	
	public Predicate<Car> porMarca(String marca){
		return car -> car.getIdentification().getMake().equals(marca);	
	}
	
	public Predicate<Car> porAnno(int anno){
		return car -> car.getIdentification().getYear() == anno;
	}
}