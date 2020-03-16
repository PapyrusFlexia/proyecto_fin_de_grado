package com.practicas.exercise1;

import org.json.JSONArray;
import org.json.JSONObject;

import com.practicas.exercise1.utils.DatabaseJson;

public class funcionesEjercicio1 {

	public void marcaModelo(JSONArray array) {

		String[] cadena1 = new String[8];
		String[] cadena2 = new String[8];
		int marcaModeloComienzo = 23;
		for (int i = 0; i < 8; i++) {
			cadena1[i] = ((JSONObject) array.get(marcaModeloComienzo)).getJSONObject("Identification")
					.getString("Model Year");
			cadena2[i] = ((JSONObject) array.get(marcaModeloComienzo)).getJSONObject("Identification")
					.getString("Make");

			System.out.println(
					"Coche: " + (marcaModeloComienzo + 1) + ", Modelo: " + cadena1[i] + ", Marca: " + cadena2[i] + ".");
			marcaModeloComienzo++;
		}

	}

	public void marcaModeloHorsepower(JSONArray array, int coches, int caballos) {

		// int que indica la posición inicial
		int marcaModeloComienzo = 0;
		// int que indica la posición final y recorre los coches
		int marcaModeloFinal = 0;
		while (marcaModeloComienzo < coches) {
			// búsqueda de los caballos
			int Horsepower = ((JSONObject) array.get(marcaModeloFinal)).getJSONObject("Engine Information")
					.getJSONObject("Engine Statistics").getInt("Horsepower");
			System.out.println(Horsepower);
			// si tienes mas caballos que los indicados en Exercide1.java los muestra
			if (Horsepower > caballos) {
				// búsqueda de las marcas
				String marca = ((JSONObject) array.get(marcaModeloComienzo)).getJSONObject("Identification")
						.getString("Model Year");
				// búsqueda de los modelos
				String modelo = ((JSONObject) array.get(marcaModeloComienzo)).getJSONObject("Identification")
						.getString("Make");
				System.out.println("Coche: " + (marcaModeloComienzo + 1) + ", Modelo: " + marca + ", Marca: " + modelo
						+ ", Caballos: " + Horsepower + ".");
				marcaModeloComienzo++;
			}
			marcaModeloFinal++;
		}

	}
}
