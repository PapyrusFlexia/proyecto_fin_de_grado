package com.proyecto.services.impl;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.dao.CarDao;
import com.proyecto.dao.ClassificationDao;
import com.proyecto.dao.DriveLineDao;
import com.proyecto.dao.FuelTypeDao;
import com.proyecto.dao.MakeDao;
import com.proyecto.dao.TransmissionDao;
import com.proyecto.model.Classification;
import com.proyecto.model.DriveLine;
import com.proyecto.model.EngineStatistics;
import com.proyecto.model.FuelType;
import com.proyecto.model.Make;
import com.proyecto.model.Transmission;
import com.proyecto.services.UtilsService;

@Service("utilService")
public class UtilServiceImpl implements UtilsService {

	@Autowired
	private TransmissionDao transmissionDao;
	
	@Autowired
	private MakeDao makeDao;

	@Autowired
	private FuelTypeDao fuelTypeDao;
	
	@Autowired
	private DriveLineDao driveLineDao;
	
	//@Autowired
	//private EngineStatisticsDaoImpl engineStatisticsDao;
	
	@Autowired
	private ClassificationDao classificationDao;
	
	@Autowired
	private CarDao carDao;
	
	/**
	 * Obtiene las marcas distintas de los coches
	 * 
	 * @return
	 */
	public List<Make> getCarsMakes() {

		return makeDao.findMakes();
	}
	
	public List<Make> getCarsMakesFilter(int m) {

		return carDao.getCarsMakesFilter(m);
	}

	/**
	 * Obtiene los años distintos de los vehículos
	 * 
	 * @return
	 */
	public List<Integer> getCarsYears() {

		return carDao.getCarsYears();
	}
	
	public List<Boolean> getCarsHybrids() {

		return carDao.getCarsHybrids();
	}
	
	public List<Classification> getCarsClassificationsTabla() {

		return classificationDao.findClassifications();
	}
	
	public List<FuelType> getCarsFuelTypes() {

		return fuelTypeDao.findFuelTypes();
	}
	
	public List<DriveLine> getCarsDriveLines() {

		return driveLineDao.findDriveLines();
	}
	
	public List<Transmission> getCarsTransmissions() {

		return transmissionDao.findTransmissions();
	}



	public Make saveMake(Make m) {

		return makeDao.save(m);
	}

	public FuelType saveFuelType(FuelType f) {

		return fuelTypeDao.save(f);
	}

	public DriveLine saveDriveLine(DriveLine d) {

		return driveLineDao.save(d);
	}
	
	public Transmission saveTransmission(Transmission t) {

		return transmissionDao.save(t);
	}
	
	
	
	public Classification saveClassification(Classification c) {

		return classificationDao.save(c);
	}
	
	
	public Make getMakeByName(String m) throws Exception{
		Make make = makeDao.findMakeByName(m);
		if(make == null) {
			throw new Exception("Marca con nombre "+ m +" no encontrada");
		}
		return make;
	}
	
	public Classification getClassificationByName(String m) throws Exception{
		Classification c = classificationDao.findClassificationByName(m);
		if(c == null) {
			throw new Exception("Classification con nombre "+ m +" no encontrada");
		}
		return c;
	}
	
	public DriveLine getDriveLineByName(String m) throws Exception{
		DriveLine d = driveLineDao.findDriveLineByName(m);
		if(d == null) {
			throw new Exception("DriveLine con nombre "+ m +" no encontrada");
		}
		return d;
	}

	@Override
	public FuelType getFuelTypeByName(String m) throws Exception {
		FuelType f = fuelTypeDao.findFuelTypeByName(m);
		if(f == null) {
			throw new Exception("FuelType con nombre "+ m +" no encontrada");
		}
		return f;
	}

	@Override
	public Transmission getTransmissionByName(String m) throws Exception {
		Transmission t = transmissionDao.findTransmissionByName(m);
		if(t == null) {
			throw new Exception("Transmission con nombre "+ m +" no encontrada");
		}
		return t;
	}
	
	
	
}