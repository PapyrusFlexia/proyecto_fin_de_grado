package com.practicas.services;

import java.util.List;

import com.practicas.model.Classification;
import com.practicas.model.DriveLine;
import com.practicas.model.EngineStatistics;
import com.practicas.model.FuelType;
import com.practicas.model.Make;
import com.practicas.model.Transmission;

public interface UtilsService {

	public List<Make> getCarsMakes();
	
	public List<Integer> getCarsYears();
	
	public List<Boolean> getCarsHybrids();
	
	public List<Classification> getCarsClassificationsTabla();
	
	public List<FuelType>	getCarsFuelTypes();
	
	public List<DriveLine>	getCarsDriveLines();
	
	public List<Transmission>	getCarsTransmissions();
	
	public Make saveMake(Make m);
	
	public FuelType saveFuelType(FuelType f);
	
	public DriveLine saveDriveLine(DriveLine d);
	
	public Transmission saveTransmission(Transmission t);
	
	public Classification saveClassification(Classification c);
	
	public Make getMakeByName(String m) throws Exception;
	
	public Classification getClassificationByName(String m) throws Exception;
	
	public DriveLine getDriveLineByName(String m) throws Exception;
	
	public FuelType getFuelTypeByName(String m) throws Exception;
	
	public Transmission getTransmissionByName(String m) throws Exception;
}

