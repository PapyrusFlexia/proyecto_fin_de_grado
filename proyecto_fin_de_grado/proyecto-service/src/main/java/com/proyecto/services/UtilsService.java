package com.proyecto.services;

import java.util.List;

import com.proyecto.model.Classification;
import com.proyecto.model.DriveLine;
import com.proyecto.model.EngineStatistics;
import com.proyecto.model.FuelType;
import com.proyecto.model.Make;
import com.proyecto.model.Transmission;

public interface UtilsService {

	public List<Make> getCarsMakes();
	
	public List<Make> getCarsMakesFilter(int m);
	
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

