package com.proyecto.dao;

import java.util.List;

import com.proyecto.model.FuelType;

public interface FuelTypeDao {

	List<FuelType> findFuelTypes();
	
	FuelType findFuelTypeByName(String name);
	
	FuelType save(FuelType f);
	
	FuelType getByPk(Integer key);
}