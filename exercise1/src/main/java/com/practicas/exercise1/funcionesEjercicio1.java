package com.practicas.exercise1;

import java.util.ArrayList;
import java.util.Collections;

import org.json.JSONArray;
import org.json.JSONObject;

public class FuncionesEjercicio1 {

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
	
	public void marcaModeloAutomaticos(JSONArray array, String automatico) {
		
		//todo el array
		int coches = array.length();
		
		int marcaModeloComienzo = 0;
	

		//busca en todo el array
		while (marcaModeloComienzo < coches) {
			// búsqueda de los automaticos
			String tipoAutomatico = ((JSONObject) array.get(marcaModeloComienzo)).getJSONObject("Identification").getString("Classification");
			// si el string es "Automatic transmission" muestra la marca el modelo y el tipo
			if (tipoAutomatico.equals(automatico)) {
				// búsqueda de las marcas
				String marca = ((JSONObject) array.get(marcaModeloComienzo)).getJSONObject("Identification")
						.getString("Model Year");
				// búsqueda de los modelos
				String modelo = ((JSONObject) array.get(marcaModeloComienzo)).getJSONObject("Identification")
						.getString("Make");
				System.out.println("Coche: " + (marcaModeloComienzo + 1) + ", Modelo: " + marca + ", Marca: " + modelo
						+ ", Tipo: " + tipoAutomatico + ".");
			
			} else if (!tipoAutomatico.equals(automatico)) {
				System.out.println("No es automático");
			}
			marcaModeloComienzo++;
		}
		
	}
	
public void marcaModeloTraccionTrasera(JSONArray array, String trasera) {
		
		//todo el array
		int coches = array.length();
		
		int marcaModeloComienzo = 0;
	

		//busca en todo el array
		while (marcaModeloComienzo < coches) {
			// búsqueda de los automaticos
			String tipoTraccionTrasera = ((JSONObject) array.get(marcaModeloComienzo)).getJSONObject("Engine Information").getString("Driveline");
			// si el string es "Rear-wheel drive" muestra la marca el modelo y el tipo
			if (tipoTraccionTrasera.equals(trasera)) {
				// búsqueda de las marcas
				String marca = ((JSONObject) array.get(marcaModeloComienzo)).getJSONObject("Identification")
						.getString("Model Year");
				// búsqueda de los modelos
				String modelo = ((JSONObject) array.get(marcaModeloComienzo)).getJSONObject("Identification")
						.getString("Make");
				System.out.println("Coche: " + (marcaModeloComienzo + 1) + ", Modelo: " + marca + ", Marca: " + modelo
						+ ", Tipo: " + tipoTraccionTrasera + ".");
			
			} else if (!tipoTraccionTrasera.equals(trasera)) {
				System.out.println("No tiene tracción trasera");
			}
			marcaModeloComienzo++;
		}
		
	}

public void marcaModeloDiesel(JSONArray array, String diesel) {
	
	//todo el array
	int coches = array.length();
	
	int marcaModeloComienzo = 0;

	//busca en todo el array
	while (marcaModeloComienzo < coches) {
		// búsqueda de los automaticos
		String tipoDiesel = ((JSONObject) array.get(marcaModeloComienzo)).getJSONObject("Fuel Information").getString("Fuel Type");
		// si el string es "Diesel fuel" muestra la marca el modelo y el tipo
		if (tipoDiesel.equals(diesel)) {
			// búsqueda de las marcas
			String marca = ((JSONObject) array.get(marcaModeloComienzo)).getJSONObject("Identification")
					.getString("Model Year");
			// búsqueda de los modelos
			String modelo = ((JSONObject) array.get(marcaModeloComienzo)).getJSONObject("Identification")
					.getString("Make");
			System.out.println("Coche: " + (marcaModeloComienzo + 1) + ", Modelo: " + marca + ", Marca: " + modelo
					+ ", Combustible: " + tipoDiesel + ".");
		
		} else if (!tipoDiesel.equals(diesel)) {
			System.out.println("No es de diesel");
		}
		marcaModeloComienzo++;
	}
	
}



public void marcaModelo2011Potencia(JSONArray array, int anno) {
	
	//todo el array
	int coches = array.length();
	
	int marcaModeloComienzo = 0;

	//busca en todo el array
	while (marcaModeloComienzo < coches) {
		// búsqueda de los automaticos
		int tipo2011Potencia = ((JSONObject) array.get(marcaModeloComienzo)).getJSONObject("Identification").getInt("Year");
		// si el int es "2011" muestra la marca el modelo y el tipo
		if (tipo2011Potencia == anno) {
			// búsqueda de las marcas
			String marca = ((JSONObject) array.get(marcaModeloComienzo)).getJSONObject("Identification")
					.getString("Model Year");
			// búsqueda de los modelos
			String modelo = ((JSONObject) array.get(marcaModeloComienzo)).getJSONObject("Identification")
					.getString("Make");
			// transforma JSONArray en ArryList
			ArrayList<String> list = new ArrayList<String>();     
			if (array != null) { 
			   int len = array.length();
			   for (int i=0;i<len;i++){ 
			    list.add(array.get(i).toString());
			   } 
			} 
			
			// ordena el ArrayList
			Collections.sort(list);
			
			System.out.println("Coche: " + (marcaModeloComienzo + 1) + ", Modelo: " + marca + ", Marca: " + modelo
					+ ", Año: " + tipo2011Potencia + ".");
		
		} else if (tipo2011Potencia != anno) {
			System.out.println("No es de 2011");
		}
		marcaModeloComienzo++;
	}
	
}

public void septimaPosicion(JSONArray array) {
	
	//todo el array
	int coches = array.length();
	
	int marcaModeloComienzo = 0;

	//busca en todo el array
	while (marcaModeloComienzo < coches) {
		if(((CharSequence) array).charAt(6) == 0 || ((CharSequence) array).charAt(6) == 1 || ((CharSequence) array).charAt(6) == 2 || ((CharSequence) array).charAt(6) == 3 || ((CharSequence) array).charAt(6) == 4 || ((CharSequence) array).charAt(6) == 5 || ((CharSequence) array).charAt(6) == 6 || ((CharSequence) array).charAt(6) == 7 || ((CharSequence) array).charAt(6) == 8 || ((CharSequence) array).charAt(6) == 9) {

		}
		marcaModeloComienzo++;
	}
	
}

}
