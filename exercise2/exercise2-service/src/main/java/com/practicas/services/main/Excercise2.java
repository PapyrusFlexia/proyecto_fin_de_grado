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
		
		System.out.println(" -------------- ");
		System.out.println(CarService.getMarcaModeloTraccionTrasera("Rear-wheel drive"));
		
		System.out.println(" -------------- ");
		System.out.println(CarService.getMarcaModeloDiesel("Diesel fuel"));
		
		//System.out.println(" -------------- ");
		//boolean asc = true;
		//System.out.println(CarService.getMarcaModelo2011Potencia(30, 2011, asc));
		
		System.out.println(" -------------- ");
		System.out.println(CarService.septimaPosicion(6));
		
		System.out.println(" -------------- ");
		boolean hibrido = true;
		System.out.println(CarService.getMarcaModeloHibrido(hibrido));
		
		System.out.println(" -------------- ");
		System.out.println(CarService.velocidades(6));
		
		System.out.println(" -------------- ");
		System.out.println(CarService.getCochesConsumo(18));
		
		System.out.println(" -------------- ");
		System.out.println(CarService.hp("hp"));
		
		

	}

}
