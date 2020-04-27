package com.practicas.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practicas.dao.CarDao;
import com.practicas.dao.ClassificationDao;
import com.practicas.dao.DriveLineDao;
import com.practicas.dao.FuelTypeDao;
import com.practicas.dao.MakeDao;
import com.practicas.dao.TransmissionDao;
import com.practicas.model.Car;
import com.practicas.model.Classification;
import com.practicas.model.DriveLine;
import com.practicas.model.FuelType;
import com.practicas.model.Make;
import com.practicas.model.Transmission;
import com.practicas.services.CarService;
import com.practicas.services.UtilsService;

@Service("utilService")
public class UtilServiceImpl implements UtilsService {
	@Autowired
	private CarService carService;

	@Autowired
	private TransmissionDao transmissionDao;
	
	@Autowired
	private MakeDao makeDao;

	@Autowired
	private FuelTypeDao fuelTypeDao;
	
	@Autowired
	private DriveLineDao driveLineDao;
	
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

	/**
	 * Obtiene los años distintos de los vehículos
	 * 
	 * @return
	 */
	public List<Integer> getCarsYears() {

		return new ArrayList<Integer>();
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

	@Override
	public List<Boolean> getCarsHybrids() {
		return carService.getCars().stream().map(car -> car.getEngineinformation().isHybrid()).distinct().sorted().collect(Collectors.toList());
		
	}

	@Override
	public List<Classification> getCarsClassificationsTabla() {
		return carService.getCars().stream().map(car -> car.getClassification()).distinct().sorted().collect(Collectors.toList());
	}

	@Override
	public List<String> getCarsClassifications() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getCarsFuelTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Make getMakeByName(String m) throws Exception {
		Make make = makeDao.findMakeByName(m);
		if(make == null) {
			throw new Exception("Marca " + m + " no encontrado/a");
		}
		return make;
	
	}
	
	@Override
	public Classification getClassificationByName(String c) throws Exception {
		Classification classification = classificationDao.findClassificationByName(c);
		if(classification == null) {
			throw new Exception("Clasificación " + c + " no encontrado/a");
		}
		return classification;
	
	}
	
	@Override
	public FuelType getFuelTypeByName(String f) throws Exception {
		FuelType fuelType = fuelTypeDao.findFuelTypeByName(f);
		if(fuelType == null) {
			throw new Exception("Tipo de combustible " + f + " no encontrado/a");
		}
		return fuelType;
	
	}
	
	@Override
	public DriveLine getDriveLineByName(String d) throws Exception {
		DriveLine driveLine = driveLineDao.findDriveLineByName(d);
		if(driveLine == null) {
			throw new Exception("Driveline " + d + " no encontrado/a");
		}
		return driveLine;
	
	}
	
	@Override
	public Transmission getTransmissionByName(String t) throws Exception {
		Transmission transmission = transmissionDao.findTransmissionByName(t);
		if(transmission == null) {
			throw new Exception("Transmisión " + t + " no encontrado/a");
		}
		return transmission;
	
	}
	
	@Override
	public Car save(Car c) {
		return carDao.save(c);
	}

	
	
}