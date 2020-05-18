package com.proyecto.dao;

import java.util.List;

import com.proyecto.model.CarImage;
import com.proyecto.model.Car;
import com.proyecto.model.Classification;
import com.proyecto.model.Make;
import com.proyecto.model.User;

public interface CarImageDao {

	

	CarImage save(CarImage ci);

	int update(int id, int image,  String name, int car_id);
	
	long totalCarImage();

	void deleteById(String id);
	
	List<CarImage> findAllCarImages();

	CarImage getByPk(Integer key);
}
