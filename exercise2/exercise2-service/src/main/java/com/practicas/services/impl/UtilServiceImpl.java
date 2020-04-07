package com.practicas.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practicas.services.CarService;
import com.practicas.services.UtilsService;

@Service("utilService")
public class UtilServiceImpl implements UtilsService{

	@Autowired
	private CarService carService;
	
	/**
	 * Obtiene las marcas distintas de los coches
	 * @return
	 */
	public List<String> getCarsMakes() {
		
		return carService.getCars().stream().map(car -> car.getIdentification().getMake()).distinct().sorted().collect(Collectors.toList());
	}
	
	/**
	 * Obtiene los años distintos de los vehículos
	 * @return
	 */
	public List<Integer> getCarsYears() {
		
		return carService.getCars().stream().map(car -> car.getIdentification().getYear()).distinct().sorted().collect(Collectors.toList());
	}

	@Override
	public List<Boolean> getCarsHybrids() {
		return carService.getCars().stream().map(car -> car.getEngineinformation().isHybrid()).distinct().sorted().collect(Collectors.toList());
		
	}

	@Override
	public List<String> getCarsClassificationsTabla() {
		return carService.getCars().stream().map(car -> car.getIdentification().getClassification()).distinct().sorted().collect(Collectors.toList());
	}
	
}