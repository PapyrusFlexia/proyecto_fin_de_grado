package com.proyecto.services;

import java.util.List;


import com.proyecto.model.Car;
import com.proyecto.model.Classification;
import com.proyecto.model.DriveLine;
import com.proyecto.model.Fuel;
import com.proyecto.model.Transmission;

public interface UtilsService {

	public List<String> getCarsMakes();
	
	public List<Car> getCarsMakesFilter(int m);
	
	public List<Integer> getCarsYears();
	
	public List<Integer> getCarsId();
	
	public List<Integer> getCarsPk();
	
	public List<Boolean> getEngineHybrids();
	
	public List<Classification> getCarsClassificationsTabla();
	
	public List<Fuel>	getCarsFuelTypes();
	
	public List<DriveLine>	getCarsDriveLines();
	
	public List<Transmission>	getCarsTransmissions();

	
	public Car saveMake(Car m);
	
	public Fuel saveFuelType(Fuel f);
	
	public DriveLine saveDriveLine(DriveLine d);
	
	public Transmission saveTransmission(Transmission t);
	
	public Classification saveClassification(Classification c);
	
	public Car getMakeByName(String m) throws Exception;
	
	public Classification getClassificationByName(String m) throws Exception;
	
	public DriveLine getDriveLineByName(String m) throws Exception;
	
	public Fuel getFuelTypeByName(String m) throws Exception;
	
	public Transmission getTransmissionByName(String m) throws Exception;
}

