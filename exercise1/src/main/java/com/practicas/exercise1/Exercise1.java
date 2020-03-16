package com.practicas.exercise1;

import org.json.JSONArray;

import com.practicas.exercise1.utils.DatabaseJson;



public class Exercise1 {

    public static void main(String[] args){

      
    	JSONArray array = DatabaseJson.loadDatabase().getData();
    	
    	FuncionesEjercicio1 objeto1 = new FuncionesEjercicio1();
    	objeto1.MarcaModelo(array);
    	
    	System.out.println(" -------------- ");
    	
    	FuncionesEjercicio1 objeto2 = new FuncionesEjercicio1();
    	objeto2.MarcaModeloHorsepower(array, 10, 150);
    	
    	System.out.println(" -------------- ");
    	
    	FuncionesEjercicio1 objeto3 = new FuncionesEjercicio1();
    	objeto3.MarcaModeloAutomaticos(array, "Automatic transmission");
    	
    	
    }
    
}


