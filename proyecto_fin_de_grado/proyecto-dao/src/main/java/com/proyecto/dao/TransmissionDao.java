package com.proyecto.dao;

import java.util.List;

import com.proyecto.model.Car;
import com.proyecto.model.Transmission;
import com.proyecto.model.User;

public interface TransmissionDao {

	List<Transmission> findTransmissions();

	Transmission findTransmissionByName(String name);

	Transmission save(Transmission t);

	Transmission getByPk(Integer key);

	void deleteById(String id);

	List<Transmission> findAllTransmissions();

}