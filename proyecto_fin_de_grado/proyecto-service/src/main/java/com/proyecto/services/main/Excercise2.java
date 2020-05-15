/**package com.practicas.services.main;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.practicas.model.Car;
import com.practicas.services.CarService;
import com.practicas.services.data.DatabaseJson;

public class Excercise2 {

	public static void main(String[] args) {

		arService.getCars(-1, -1, null);
		
		
		restoreloadData();
	}

	
	@SuppressWarnings("unused")
	private static void restoreloadData() {
		JSONArray array = DatabaseJson.loadDatabase().getData();

		int length = array.length();
		List<String> listCheck = new ArrayList<>(); 
		for(int i = 0; i < length; i++) {
			int random = new SecureRandom().nextInt(length); 
			while(listCheck.contains(""+random)) {
				random = new SecureRandom().nextInt(length);
			}
			listCheck.add(""+random);
			((JSONObject)array.get(i)).put("pk", random);
		}
		
		DatabaseJson.saveFile(array.toString());
		
		for(int i = 0; i < length; i++) {
			System.out.println(((JSONObject)array.get(i)).get("pk"));
		}
		
		List<Car> listCar = DatabaseJson.loadDatabase().getDataParsed();

		System.out.println(" \ngetMarcaModelo -------------- ");
		System.out.println(CarService.getMarcaModelo(23, 31));

		System.out.println(" \ngetMarcaModeloHorsePower -------------- ");
		System.out.println(CarService.getMarcaModeloHorsePower(10, 150));

		System.out.println(" \ngetMarcaModeloAutomaticos -------------- ");
		System.out.println(CarService.getMarcaModeloAutomaticos("Automatic transmission"));

		System.out.println(" \ngetMarcaModeloTraccionTrasera -------------- ");
		System.out.println(CarService.getMarcaModeloTraccionTrasera("Rear-wheel drive"));

		System.out.println(" \ngetMarcaModeloDiesel -------------- ");
		System.out.println(CarService.getMarcaModeloDiesel("Diesel fuel"));

		System.out.println(" \ngetMarcaModelo2011Potencias -------------- ");
		System.out.println(CarService.getMarcaModelo2011Potencia(30, 2011));

		System.out.println(" \nseptimaPosicion -------------- ");
		System.out.println(CarService.septimaPosicion(6));

		System.out.println(" \ngetMarcaModeloHibrido -------------- ");
		boolean hibrido = true;
		System.out.println(CarService.getMarcaModeloHibrido(hibrido));

		System.out.println(" \nvelocidades -------------- ");
		System.out.println(CarService.velocidades(6));

		System.out.println(" \ngetCochesConsumo -------------- ");
		System.out.println(CarService.getCochesConsumo(18));

		System.out.println(" \nhp -------------- ");
		System.out.println(CarService.hp("hp"));

	}

} */
