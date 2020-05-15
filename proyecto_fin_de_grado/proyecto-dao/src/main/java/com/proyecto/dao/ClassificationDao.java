package com.proyecto.dao;

import java.util.List;


import com.proyecto.model.Classification;


public interface ClassificationDao {

	List<Classification> findClassifications();
	
	Classification findClassificationByName(String name);

	Classification save(Classification c);
	
	Classification getByPk(Integer key);
}