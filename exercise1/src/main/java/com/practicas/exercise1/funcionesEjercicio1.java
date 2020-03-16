package com.practicas.exercise1;

import org.json.JSONArray;
import org.json.JSONObject;

import com.practicas.exercise1.utils.DatabaseJson;

public class funcionesEjercicio1 {
	
	public void marcaModelo(JSONArray array) {
  
    	String[] cadena1 = new String[8];
    	String[] cadena2 = new String[8];
    	int marcaModeloComienzo = 23;
    	for(int i = 0; i< 8; i++) {
    		cadena1[i] = ((JSONObject)array.get(marcaModeloComienzo)).getJSONObject("Identification").getString("Model Year");
    		cadena2[i] = ((JSONObject)array.get(marcaModeloComienzo)).getJSONObject("Identification").getString("Make");
    		
    		System.out.println("Coche: " + (marcaModeloComienzo+1)+ ", Modelo: "+ cadena1[i] + ", Marca: " + cadena2[i] + ".");
    		marcaModeloComienzo++;
    	}
    	
    	
    
	}

}
