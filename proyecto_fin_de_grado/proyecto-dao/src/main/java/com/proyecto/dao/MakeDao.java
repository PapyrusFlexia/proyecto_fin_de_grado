package com.proyecto.dao;

import java.util.List;


import com.proyecto.model.Make;

public interface MakeDao {

	List<Make> findMakes();
	
	Make findMakeByName(String name);
	
	Make save(Make m);
	
	Make getByPk(Integer key);
}