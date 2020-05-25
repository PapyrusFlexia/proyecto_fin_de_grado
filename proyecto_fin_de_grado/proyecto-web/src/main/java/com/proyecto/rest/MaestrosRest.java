package com.proyecto.rest;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.model.Classification;
import com.proyecto.model.Fuel;
import com.proyecto.model.Car;
import com.proyecto.services.UtilsService;

@RestController
@RequestMapping("maestros")
public class MaestrosRest {

	@Autowired
	private UtilsService utilsService;

	@GetMapping(value="/makes", produces = "application/json")
    public @ResponseBody List<String> getMakes() {
        return utilsService.getCarsMakes();
    }

	@GetMapping(value="/years", produces = "application/json")
	public @ResponseBody List<Integer> getYears() {
		return utilsService.getCarsYears();
	}
	
	@GetMapping(value="/hybrids", produces = "application/json")
	public @ResponseBody List<Boolean> getHybrids() {
		return utilsService.getEngineHybrids();
	}
	
	@GetMapping(value="/classifications", produces = "application/json")
	public @ResponseBody List<Classification> getClassifications() {
		return utilsService.getCarsClassificationsTabla();
	}
	
	@GetMapping(value="/fueltypes", produces = "application/json")
	public @ResponseBody List<Fuel> getCarsFuelTypes() {
		return utilsService.getCarsFuelTypes();
	}		
}