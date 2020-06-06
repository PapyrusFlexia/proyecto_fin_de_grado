package com.proyecto.dao;

import java.util.List;


import com.proyecto.model.CarImage;
import com.proyecto.model.Car;
import com.proyecto.model.Classification;
import com.proyecto.model.User;

public interface CarImageDao {

	

	CarImage saveImage(CarImage ci);
	
	CarImage getCarImageByCarId(int carid);
	
	long totalCarImage();
	
	public List<String> getCarImages();

	void deleteById(String id);
	
	List<CarImage> findAllCarImages();

	CarImage getByPk(Integer key);
}
