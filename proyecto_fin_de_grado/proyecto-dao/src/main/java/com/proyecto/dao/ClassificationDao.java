package com.proyecto.dao;

import java.util.List;

import com.proyecto.model.Car;
import com.proyecto.model.Classification;
import com.proyecto.model.User;

public interface ClassificationDao {

	List<Classification> findClassifications();

	Classification findClassificationByName(String name);

	Classification save(Classification c);

	List<Classification> findAllClassifications();

	Classification getByPk(Integer key);

	void deleteById(String id);

}