package com.practicas.services;

import java.util.List;

import com.practicas.model.Car;
import com.practicas.model.Classification;
import com.practicas.model.Dimensions;
import com.practicas.model.DriveLine;
import com.practicas.model.FuelType;
import com.practicas.model.Make;
import com.practicas.model.Transmission;

public interface UtilsService {
	
	static final DriveLine driveLineDao = new DriveLine();

	public List<Make> getCarsMakes();
	
	public List<Integer> getCarsYears();
	
	public Make saveMake(Make m);
	
	public FuelType saveFuelType(FuelType f);
	
	public DriveLine saveDriveLine(DriveLine d);
	
	public Transmission saveTransmission(Transmission t);
	
	public Classification saveClassification(Classification c);
	
	public List<Boolean> getCarsHybrids();
	
	public List<Classification> getCarsClassificationsTabla();

	public List<String> getCarsClassifications();

	public List<String> getCarsFuelTypes();

	public Make getMakeByName(String m) throws Exception;
	
	public Classification getClassificationByName(String c) throws Exception;
	
	public FuelType getFuelTypeByName(String f) throws Exception;
	
	public DriveLine getDriveLineByName(String d) throws Exception;
	
	public Transmission getTransmissionByName(String t) throws Exception;
	
	public Car save(Car c);

}