package com.practicas.dao;

import java.util.List;

import com.practicas.model.Classification;


public interface ClassificationDao {

	List<Classification> findClassification() ;
	
	Classification findClassificationByName(String name);

	Classification save(Classification c);
	
	Classification getByPk(Integer key);
}