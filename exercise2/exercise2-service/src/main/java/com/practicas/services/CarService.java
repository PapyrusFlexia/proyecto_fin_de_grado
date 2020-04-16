package com.practicas.services;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.json.JSONObject;
import java.util.Set;

import com.practicas.model.Car;
import com.practicas.model.comparators.CarComparator;
import com.practicas.services.data.DatabaseJson;

public interface CarService  {

	public List<Car> getCars();

	public long getTotalCar();

	public List<Car> getCars(int start, int stop);

	public List<Car> getCars(int start, int end, List<Predicate<Car>> ps);

	public long getCarsCount(List<Predicate<Car>> ps);

	public List<Car> getCars(int start, int end, Predicate<Car> p, CarComparator comparator);

	public List<Car> getCarsSortMake(int begin, int end, List<Predicate<Car>> ps, CarComparator makecomparator);

	public List<Car> getCars(int start, int end, Predicate<Car> p, CarComparator comparator, int limit);

	public Optional<Car> getCarByPk(int pk);

	public List<Car> getMarcaModelo(int start, int stop);

	public List<Car> getMarcaModeloHorsePower(int numberMax, int horsepower);

	public List<Car> getMarcaModeloAutomaticos(String automatico);

	public List<Car> getMarcaModeloTraccionTrasera(String trasera);

	public List<Car> getMarcaModeloDiesel(String diesel);

	public List<Car> getMarcaModelo2011Potencia(int numberMax, int anno);

	public List<Car> septimaPosicion(int nCharacter);

	public List<Car> getMarcaModeloHibrido(boolean hibrido);

	public List<Car> velocidades(int velocidades);

	public List<Car> getCochesConsumo(int consumo);

	public List<Car> hp(String palabra);

	public List<String> getCarsMakes();

	public List<Integer> getCarsYears();

	public List<Boolean> getCarsHybrids();

	public List<String> getCarsClassificationsTabla();

	public long getCarsCount(Predicate<Car> p);

	public List<String> getCarsDrivelines();

	public List<String> getCarsClassifications();

	public List<Integer> getCarsAnnos();

	public List<String> getCarsFuelTypes();

	public List<Boolean> getHybrid();
	
	public long  totalCar();

}
