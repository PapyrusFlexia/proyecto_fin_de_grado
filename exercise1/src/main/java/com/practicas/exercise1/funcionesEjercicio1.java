package com.practicas.exercise1;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

import com.practicas.exercise1.utils.DatabaseJson;

public class FuncionesEjercicio1 {

	public void MarcaModelo(JSONArray array) {

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

	public void MarcaModeloHorsepower(JSONArray array, int coches, int caballos) {

		// int que indica la posición inicial
		int marcaModeloComienzo = 0;
		// int que indica la posición final y recorre los coches
		int marcaModeloFinal = 0;
		while (marcaModeloComienzo < coches) {
			// búsqueda de los caballos
			int Horsepower = ((JSONObject) array.get(marcaModeloFinal)).getJSONObject("Engine Information")
					.getJSONObject("Engine Statistics").getInt("Horsepower");
			// si tienes mas caballos que los indicados en Exercise1.java los muestra
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
	
	public void MarcaModeloAutomaticos(JSONArray array, String automatico) {
		
		//todo el array
		int coches = array.length();
		
		int marcaModeloComienzo = 0;
	

		//busca en todo el array
		while (marcaModeloComienzo < coches) {
			// búsqueda de los automaticos
			String tipoAutomatico = ((JSONObject) array.get(marcaModeloComienzo)).getJSONObject("Identification").getString("Classification");
			// si tienes mas caballos que los indicados en Exercide1.java los muestra
			if (tipoAutomatico.equals(automatico)) {
				// búsqueda de las marcas
				String marca = ((JSONObject) array.get(marcaModeloComienzo)).getJSONObject("Identification")
						.getString("Model Year");
				// búsqueda de los modelos
				String modelo = ((JSONObject) array.get(marcaModeloComienzo)).getJSONObject("Identification")
						.getString("Make");
				System.out.println("Coche: " + (marcaModeloComienzo + 1) + ", Modelo: " + marca + ", Marca: " + modelo
						+ ", Tipo: " + tipoAutomatico + ".");
			
			}
			marcaModeloComienzo++;
		}

	}
}
