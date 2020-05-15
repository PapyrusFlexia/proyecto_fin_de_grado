package com.proyecto.dao;

import java.util.List;


import com.proyecto.model.DriveLine;

public interface DriveLineDao {

	List<DriveLine> findDriveLines() ;
	
	DriveLine findDriveLineByName(String name);

	DriveLine save(DriveLine d);
	
	DriveLine getByPk(Integer key);
}