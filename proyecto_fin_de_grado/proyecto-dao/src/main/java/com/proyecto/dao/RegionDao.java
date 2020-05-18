package com.proyecto.dao;

import java.util.List;

import com.proyecto.model.Region;
import com.proyecto.model.Car;
import com.proyecto.model.Classification;
import com.proyecto.model.Make;
import com.proyecto.model.User;

public interface RegionDao {

	

	Region save(Region b);

	int update(int id, String name, int price);
	
	long totalRegion();

	void deleteById(String id);
	
	List<Region> findAllRegions();

	Region getByPk(Integer key);
}
