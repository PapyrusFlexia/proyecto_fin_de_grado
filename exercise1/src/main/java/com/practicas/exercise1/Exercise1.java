package com.practicas.exercise1;

import org.json.JSONArray;

import com.practicas.exercise1.utils.DatabaseJson;

public class Exercise1 {

	public static void main(String[] args) {

		JSONArray array = DatabaseJson.loadDatabase().getData();

		FuncionesEjercicio1 objeto1 = new FuncionesEjercicio1();
		objeto1.marcaModelo(array);

		System.out.println(" -------------- ");

		FuncionesEjercicio1 objeto2 = new FuncionesEjercicio1();
		objeto2.marcaModeloHorsepower(array, 10, 150);

		System.out.println(" -------------- ");

		FuncionesEjercicio1 objeto3 = new FuncionesEjercicio1();
		objeto3.marcaModeloAutomaticos(array, "Automatic transmission");

		System.out.println(" -------------- ");

		FuncionesEjercicio1 objeto4 = new FuncionesEjercicio1();
		objeto4.marcaModeloTraccionTrasera(array, "Rear-wheel drive");

		System.out.println(" -------------- ");

		FuncionesEjercicio1 objeto5 = new FuncionesEjercicio1();
		objeto5.marcaModeloDiesel(array, "Diesel fuel");

		System.out.println(" -------------- ");

		FuncionesEjercicio1 objeto6 = new FuncionesEjercicio1();
		boolean asc = true;
		objeto6.marcaModelo2011Potencia(array, 2011, asc);

		System.out.println(" -------------- ");

		FuncionesEjercicio1 objeto7 = new FuncionesEjercicio1();
		System.out.print(objeto7.septimaPosicion(array, 6));

		System.out.println(" -------------- ");

		FuncionesEjercicio1 objeto8 = new FuncionesEjercicio1();
		boolean hibrido = true;
		System.out.print(objeto8.marcaModeloHibrido(array, hibrido));

		System.out.println(" -------------- ");

		FuncionesEjercicio1 objeto9 = new FuncionesEjercicio1();
		System.out.println(objeto9.velocidades(array, 6));

		System.out.println(" -------------- ");

		FuncionesEjercicio1 objeto10 = new FuncionesEjercicio1();
		boolean desc = true;
		System.out.print(objeto10.marcaCochesConsumo(array, 18, desc));

		System.out.println(" -------------- ");

		FuncionesEjercicio1 objeto11 = new FuncionesEjercicio1();
		objeto11.hp(array, "hp");

	}

}
