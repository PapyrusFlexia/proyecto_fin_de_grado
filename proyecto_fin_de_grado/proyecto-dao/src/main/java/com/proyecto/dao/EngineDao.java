package com.proyecto.dao;

import java.util.List;


import com.proyecto.model.Engine;
import com.proyecto.model.Car;
import com.proyecto.model.Classification;
import com.proyecto.model.User;

public interface EngineDao {

	

	Engine save(Engine b);

	int update(int id, String driveline, String enginetype, Boolean hybrid, int numberofforwardgears, String transmission, int horsepower, int torque);
	
	long totalEngine();

	void deleteById(String id);
	
	List<Engine> findAllEngines();

	Engine getByPk(Integer key);
}
