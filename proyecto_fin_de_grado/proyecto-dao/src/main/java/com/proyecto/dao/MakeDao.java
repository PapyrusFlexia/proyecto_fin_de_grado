package com.proyecto.dao;

import java.util.List;

import com.proyecto.model.Car;
import com.proyecto.model.Make;
import com.proyecto.model.User;

public interface MakeDao {

	List<Make> findMakes();

	Make findMakeByName(String name);

	Make save(Make m);

	Make getByPk(Integer key);

	void deleteById(String id);

	List<Make> findAllMakes();

}