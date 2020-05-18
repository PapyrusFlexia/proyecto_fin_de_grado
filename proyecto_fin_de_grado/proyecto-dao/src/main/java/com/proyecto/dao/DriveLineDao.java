package com.proyecto.dao;

import java.util.List;

import com.proyecto.model.Car;
import com.proyecto.model.DriveLine;
import com.proyecto.model.User;

public interface DriveLineDao {

	List<DriveLine> findDriveLines();

	DriveLine findDriveLineByName(String name);

	DriveLine save(DriveLine d);

	DriveLine getByPk(Integer key);

	void deleteById(String id);

	List<DriveLine> findAllDriveLines();

}