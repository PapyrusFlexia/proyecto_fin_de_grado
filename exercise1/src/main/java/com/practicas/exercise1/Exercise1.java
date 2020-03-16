package com.practicas.exercise1;

import org.json.JSONArray;

import com.practicas.exercise1.utils.DatabaseJson;



public class Exercise1 {

    public static void main(String[] args){

      
    	JSONArray array = DatabaseJson.loadDatabase().getData();
    	
    	funcionesEjercicio1 objeto1 = new funcionesEjercicio1();
    	objeto1.marcaModelo(array);
    	
    	System.out.println(" -------------- ");
    	
    	funcionesEjercicio1 objeto2 = new funcionesEjercicio1();
    	objeto2.marcaModeloHorsepower(array, 10, 150);
    	
    	
    }
    
}


