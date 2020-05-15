package com.proyecto.dao;

import java.util.List;


import com.proyecto.model.Transmission;

public interface TransmissionDao {

	List<Transmission> findTransmissions();
	
	Transmission findTransmissionByName(String name);
	
	Transmission save(Transmission t);
	
	Transmission getByPk(Integer key);
}