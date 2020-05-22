package com.proyecto.dao;

import java.util.List;


import com.proyecto.model.Dimensions;
import com.proyecto.model.Car;
import com.proyecto.model.Classification;
import com.proyecto.model.User;

public interface DimensionsDao {

	

	Dimensions save(Dimensions d);

	int update(int id, String name, int height, int length, int width);
	
	long totalDimensions();

	void deleteById(String id);
	
	List<Dimensions> findAllDimensions();

	Dimensions getByPk(Integer key);
}
