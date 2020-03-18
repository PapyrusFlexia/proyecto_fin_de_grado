package com.practicas.services.main;

import java.util.List;

import com.practicas.model.Car;
import com.practicas.services.CarService;
import com.practicas.services.data.DatabaseJson;

public class Excercise2 {

	public static void main(String[] args) {

		List<Car> listCar = DatabaseJson.loadDatabase().getDataParsed();

		System.out.println(" -------------- ");
		System.out.println(CarService.getMarcaModelo(23, 31));
		
		System.out.println(" -------------- ");
		System.out.println(CarService.getMarcaModeloHorsePower(10, 150));
		
		System.out.println(" -------------- ");
		System.out.println(CarService.getMarcaModeloAutomaticos("Automatic transmission"));

	}

}
