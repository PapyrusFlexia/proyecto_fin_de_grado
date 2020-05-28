package com.proyecto.dao;

import java.util.List;

import com.proyecto.model.Car;
import com.proyecto.model.Fuel;
import com.proyecto.model.User;

public interface FuelDao {

	List<Fuel> findFuel();

	Fuel findFuelByName(String name);
	
	Fuel findFuelById(int id);

	Fuel save(Fuel f);

	Fuel getByPk(Integer key);

	void deleteById(String id);

	List<Fuel> findAllFuels();

}