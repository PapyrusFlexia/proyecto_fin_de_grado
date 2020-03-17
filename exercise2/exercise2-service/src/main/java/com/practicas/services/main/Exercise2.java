package com.practicas.services.main;

import com.practicas.exercise2.utils.DatabaseJson;

public class Exercise2 {

	public static void main(String[] args) {
		
		
		List<Car> listCar = DatabaseJson.loadDatabase().getDataParsed();
		
		System.out.println(listCar);

	}

}
