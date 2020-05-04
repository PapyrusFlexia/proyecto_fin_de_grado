package com.practicas.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.practicas.model.Car;
import com.practicas.services.CarService;

@RestController
@RequestMapping("cars")
public class CarRest {

	
	@Autowired
	private CarService carService;

	@GetMapping(value="/id/{id}", produces =  MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Car getCar(@PathVariable int id) {
        return carService.getCarByPk(id);
    }
	
	@GetMapping(value="/search", produces = "application/json")
    public @ResponseBody List<Car> search() {
        
		int page = 0;
		int start = (Integer.valueOf(page) + 1 * 10 - 10) * 10;
		int end = start + 10;
		
		return carService.getCars(start, end, null);
    }
	
	
	@GetMapping(value="/search/{page}", produces = "application/json")
    public @ResponseBody List<Car> search(@PathVariable int page) {
        
		int start = (Integer.valueOf(page) + 1 * 10 - 10) * 10;
		int end = start + 10;
		
		return carService.getCars(start, end, null);
    }
	
	@GetMapping(value="/carsByMake", produces = "application/json")
    public @ResponseBody List<Car> carsByMake() {
				
		return new ArrayList<Car>();
    }
	
	
	@GetMapping(value="/carsByMake/{makeFilter}", produces = "application/json")
    public @ResponseBody List<Car> carsByMake( @PathVariable String makeFilter) {
        
		if(!StringUtils.isEmpty(makeFilter)) {
			List<Predicate<Car>> lP = new ArrayList<Predicate<Car>>();
			Predicate<Car> p = new Predicate<Car>() {

				@Override
				public boolean test(Car t) {
					return t.getMake().getMake().equals(makeFilter);
				}
				
			}; 
			lP.add(p);
			return carService.getCars(lP);
		}
		
		return new ArrayList<Car>();
    }
	
	
	@GetMapping(value="/search/{page}/{makeFilter}", produces = "application/json")
    public @ResponseBody List<Car> search(@PathVariable int page, @PathVariable String makeFilter) {
        
		int start = (Integer.valueOf(page) + 1 * 10 - 10) * 10;
		int end = start + 10;
		
		
		if(!StringUtils.isEmpty(makeFilter)) {
			List<Predicate<Car>> lP = new ArrayList<Predicate<Car>>();
			Predicate<Car> p = new Predicate<Car>() {

				@Override
				public boolean test(Car t) {
					return t.getMake().getMake().equals(makeFilter);
				}
				
			}; 
			lP.add(p);
			return carService.getCars(start, end, lP);
		}
		
		return carService.getCars(start, end, null);
    }
	
	
}