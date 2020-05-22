package com.proyecto.dao;

import java.util.List;


import com.proyecto.model.Car;
import com.proyecto.model.User;

public interface MakeDao {

	List<Car> findMakes();

	Car findMakeByName(String name);

	Car save(Car m);

	Car getByPk(Integer key);

	void deleteById(String id);

	List<Car> findAllMakes();

}