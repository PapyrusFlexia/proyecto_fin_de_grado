package com.practicas.exercise1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.json.JSONArray;
import org.json.JSONObject;

import com.practicas.exercise1.utils.DatabaseJson;

public class FuncionesEjercicio1 {

	public static JSONArray getMarcaModelo(int start, int stop) {

		// comprobamos los parámetros de entrada

		if (start > stop) {
			return null;
		}
		JSONArray array = DatabaseJson.loadDatabase().getData();
		JSONArray arrayReturn = new JSONArray();

		int begin = start;
		if (begin < 0) {
			begin = 0;
		}
		int end = stop;
		// si end es mayor que la longitud, end lo asignamos a la longitud
		if (end <= 0 || end > array.length()) {
			end = array.length();
		}

		for (int i = begin; i < end; i++) {
			JSONObject objReturn = new JSONObject();
			JSONObject jObj = array.getJSONObject(i);
			objReturn.put("make", jObj.getJSONObject("Identification").getString("Make"));
			objReturn.put("model", jObj.getJSONObject("Identification").getString("ID"));
			// Añadimos una modificación para permitir automáticos
			objReturn.put("transmission", jObj.getJSONObject("Engine Information").getString("Transmission"));
			objReturn.put("year", jObj.getJSONObject("Identification").getInt("Year"));
			objReturn.put("horsepower",
					jObj.getJSONObject("Engine Information").getJSONObject("Engine Statistics").getInt("Horsepower"));
			arrayReturn.put(objReturn);
		}

		return arrayReturn;
	}

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

		// todo el array
		int coches = array.length();

		int marcaModeloComienzo = 0;

		// busca en todo el array
		while (marcaModeloComienzo < coches) {
			// búsqueda de los automaticos
			String tipoAutomatico = ((JSONObject) array.get(marcaModeloComienzo)).getJSONObject("Identification")
					.getString("Classification");
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

		// todo el array
		int coches = array.length();

		int marcaModeloComienzo = 0;

		// busca en todo el array
		while (marcaModeloComienzo < coches) {
			// búsqueda de los automaticos
			String tipoTraccionTrasera = ((JSONObject) array.get(marcaModeloComienzo))
					.getJSONObject("Engine Information").getString("Driveline");
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

		// todo el array
		int coches = array.length();

		int marcaModeloComienzo = 0;

		// busca en todo el array
		while (marcaModeloComienzo < coches) {
			// búsqueda de los automaticos
			String tipoDiesel = ((JSONObject) array.get(marcaModeloComienzo)).getJSONObject("Fuel Information")
					.getString("Fuel Type");
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

	public void marcaModelo2011Potencia(JSONArray array, int anno, boolean asc) {
		JSONArray arrayReturn = new JSONArray();
		// todo el array
		int coches = array.length();

		int marcaModeloComienzo = 0;

		// busca en todo el array
		while (marcaModeloComienzo < coches) {
			// búsqueda de los automaticos
			int tipo2011Potencia = ((JSONObject) array.get(marcaModeloComienzo)).getJSONObject("Identification")
					.getInt("Year");
			// si el int es "2011" muestra la marca el modelo y el tipo
			if (tipo2011Potencia == anno) {
				// búsqueda de las marcas
				String marca = ((JSONObject) array.get(marcaModeloComienzo)).getJSONObject("Identification")
						.getString("Model Year");
				// búsqueda de los modelos
				String modelo = ((JSONObject) array.get(marcaModeloComienzo)).getJSONObject("Identification")
						.getString("Make");
				// transforma JSONArray en ArrayList

				ArrayList<JSONObject> list = new ArrayList<>();
				/**
				 * if (array != null) { int len = array.length(); for (int i = 0; i < len; i++)
				 * { list.add(array.get(i).toString()); } }
				 */

				// ordena el ArrayList
				Collections.sort(list, new Comparator<JSONObject>() {
					// You can change "Name" with "ID" if you want to sort by ID
					private static final String KEY_NAME = "horsepower";

					@Override
					public int compare(JSONObject a, JSONObject b) {

						int valA = a.getInt(KEY_NAME);
						int valB = b.getInt(KEY_NAME);

						int multiplicator = 1;
						if (!asc) {
							multiplicator = -1;
						}

						if (valA < valB) {
							return multiplicator * -1;
						} else if (valA > valB) {
							return multiplicator * 1;
						} else {
							return multiplicator * (a.getString("model").compareTo(b.getString("model")));
						}
					}
				});

				for (JSONObject jsonObject : list) {
					arrayReturn.put(jsonObject);
				}

				System.out.println("Coche: " + (marcaModeloComienzo + 1) + ", Modelo: " + marca + ", Marca: " + modelo
						+ ", Año: " + tipo2011Potencia + ".");

			} else if (tipo2011Potencia != anno) {
				System.out.println("No es de 2011");
			}
			marcaModeloComienzo++;
		}

	}

	public JSONArray septimaPosicion(JSONArray array, int nCharacter) {
		JSONArray arrayReturn = new JSONArray();

		int coches = array.length();
		int marcaModeloComienzo = 0;
		while (marcaModeloComienzo < coches) {
			char tipoNumero = ((JSONObject) array.get(marcaModeloComienzo)).getJSONObject("Identification").getString("ID")
					.charAt(nCharacter);

			boolean comprobacion = Character.isDigit(tipoNumero);
			if (comprobacion == true) {
				JSONObject objetoReturn = new JSONObject();
				JSONObject jObjeto = array.getJSONObject(marcaModeloComienzo);
				objetoReturn.put("model", jObjeto.getJSONObject("Identification").getString("ID"));
				arrayReturn.put(objetoReturn);
			}
			marcaModeloComienzo++;
		}
		return arrayReturn;

	}

	public JSONArray marcaModeloHibrido(JSONArray array, boolean hibrido) {
		JSONArray arrayReturn = new JSONArray(); // todo el array
		int coches = array.length();
		int marcaModeloComienzo = 0; // busca en todo el array
		while (marcaModeloComienzo < coches) {

			boolean tipoHibrido = ((JSONObject) array.get(marcaModeloComienzo)).getJSONObject("Engine Information")
					.getBoolean("Hybrid"); // si el string es "Hybrid" muestra la marca el modeloy el tipo
			if (tipoHibrido == hibrido) {
				JSONObject objetoReturn = new JSONObject();
				JSONObject jObjeto = array.getJSONObject(marcaModeloComienzo);
				// busca marca y modelo
				objetoReturn.put("tipo", jObjeto.getJSONObject("Engine Information").getBoolean("Hybrid"));
				objetoReturn.put("make", jObjeto.getJSONObject("Identification").getString("Make"));
				objetoReturn.put("model", jObjeto.getJSONObject("Identification").getString("ID"));
				arrayReturn.put(objetoReturn);

			}

			marcaModeloComienzo++;
		}
		return arrayReturn;

	}

	/**
	 * public void marcaModeloHibrido(JSONArray array, boolean hibrido) {
	 * 
	 * // todo el array int coches = array.length();
	 * 
	 * int marcaModeloComienzo = 0;
	 * 
	 * // busca en todo el array while (marcaModeloComienzo < coches) { // búsqueda
	 * de los automaticos boolean tipoHibrido = ((JSONObject)
	 * array.get(marcaModeloComienzo)).getJSONObject("Engine Information")
	 * .getBoolean("Hybrid"); // si el string es "Diesel fuel" muestra la marca el
	 * modelo y el tipo if (tipoHibrido == hibrido) { // búsqueda de las marcas
	 * String marca = ((JSONObject)
	 * array.get(marcaModeloComienzo)).getJSONObject("Identification")
	 * .getString("Model Year"); // búsqueda de los modelos String modelo =
	 * ((JSONObject) array.get(marcaModeloComienzo)).getJSONObject("Identification")
	 * .getString("Make"); System.out.println("Coche: " + (marcaModeloComienzo + 1)
	 * + ", Modelo: " + marca + ", Marca: " + modelo + ", Tipo: " + tipoHibrido +
	 * ".");
	 * 
	 * } else if (tipoHibrido != (hibrido)) { System.out.println("No es de diesel");
	 * } marcaModeloComienzo++; }
	 * 
	 * }
	 */

	public JSONArray velocidades(JSONArray array, int velocidades) {
		JSONArray arrayReturn = new JSONArray();
		// todo el array
		int coches = array.length();

		int marcaModeloComienzo = 0;

		// busca en todo el array
		while (marcaModeloComienzo < coches) {
			// búsqueda de las velocidades
			int tipoVelocidades = ((JSONObject) array.get(marcaModeloComienzo)).getJSONObject("Engine Information")
					.getInt("Number of Forward Gears");
			// si el string es "Rear-wheel drive" muestra la marca el modelo y el tipo
			if (tipoVelocidades == velocidades) {
				// búsqueda de las marcas
				JSONObject objReturn = new JSONObject();
				JSONObject jObj = array.getJSONObject(marcaModeloComienzo);
				objReturn.put("make", jObj.getJSONObject("Identification").getString("Make"));
				objReturn.put("model", jObj.getJSONObject("Identification").getString("ID"));
				// Añadimos una modificación para permitir automáticos
				objReturn.put("transmission", jObj.getJSONObject("Engine Information").getString("Transmission"));
				objReturn.put("year", jObj.getJSONObject("Identification").getInt("Year"));
				objReturn.put("velocidades",
						jObj.getJSONObject("Engine Information").getInt("Number of Forward Gears"));
				objReturn.put("horsepower", jObj.getJSONObject("Engine Information").getJSONObject("Engine Statistics")
						.getInt("Horsepower"));
				arrayReturn.put(objReturn);

			} else if (tipoVelocidades != velocidades) {
				System.out.println("No tiene 6 velocidades");
			}
			marcaModeloComienzo++;
		}
		return arrayReturn;

	}
	
	public JSONArray marcaCochesConsumo(JSONArray array, int consumo, boolean asc) {
		JSONArray arrayReturn = new JSONArray();
		// todo el array
		int coches = array.length();

		int marcaModeloComienzo = 0;

		// busca en todo el array
		while (marcaModeloComienzo < coches) {
			// búsqueda del consumo
			int tipoConsumo = ((JSONObject) array.get(marcaModeloComienzo)).getJSONObject("Fuel Information")
					.getInt("City mph");
			// si el int es "City mph" muestra la marca y el coche
			if (tipoConsumo < consumo) {
				// búsqueda de las marcas
				JSONObject objReturn = new JSONObject();
				JSONObject jObj = array.getJSONObject(marcaModeloComienzo);
				objReturn.put("model", jObj.getJSONObject("Identification").getString("ID"));
				// búsqueda de los coches
				objReturn.put("make", jObj.getJSONObject("Identification").getString("Make"));
				
				objReturn.put("consumo",
						jObj.getJSONObject("Fuel Information").getInt("City mph"));
				arrayReturn.put(objReturn);
				// transforma JSONArray en ArrayList

				ArrayList<JSONObject> list = new ArrayList<>();

				// ordena el ArrayList
				Collections.sort(list, new Comparator<JSONObject>() {
					// You can change "Name" with "ID" if you want to sort by ID
					private static final String KEY_NAME = "horsepower";

					@Override
					public int compare(JSONObject a, JSONObject b) {

						int valA = a.getInt(KEY_NAME);
						int valB = b.getInt(KEY_NAME);

						int multiplicator = -1;
						if (!asc) {
							multiplicator = 1;
						}

						if (valB  < valA) {
							return multiplicator * 1;
						} else if (valB > valA) {
							return multiplicator * -1;
						} else {
							return multiplicator * (a.getString("model").compareTo(b.getString("model")));
						}
					}
				});

				for (JSONObject jsonObject : list) {
					arrayReturn.put(jsonObject);
				}

			} else if (tipoConsumo >= consumo) {
				System.out.println("El consumo es mayor a lo indicado");
			}
			marcaModeloComienzo++;
		}
		return arrayReturn;

	}
	
	/**public JSONArray hp(JSONArray array, int velocidades) {
		JSONArray arrayReturn = new JSONArray();
		// todo el array
		int coches = array.length();

		int marcaModeloComienzo = 0;

		// busca en todo el array
		while (marcaModeloComienzo < coches) {
			// búsqueda de las velocidades
			int tipoVelocidades = ((JSONObject) array.get(marcaModeloComienzo)).getJSONObject("Engine Information")
					.getInt("Number of Forward Gears");
			// si el string es "Rear-wheel drive" muestra la marca el modelo y el tipo
			if (tipoVelocidades == velocidades) {
				// búsqueda de las marcas
				JSONObject objReturn = new JSONObject();
				JSONObject jObj = array.getJSONObject(marcaModeloComienzo);
				objReturn.put("make", jObj.getJSONObject("Identification").getString("Make"));
				objReturn.put("model", jObj.getJSONObject("Identification").getString("ID"));
				// Añadimos una modificación para permitir automáticos
				objReturn.put("transmission", jObj.getJSONObject("Engine Information").getString("Transmission"));
				objReturn.put("year", jObj.getJSONObject("Identification").getInt("Year"));
				objReturn.put("velocidades",
						jObj.getJSONObject("Engine Information").getInt("Number of Forward Gears"));
				objReturn.put("horsepower", jObj.getJSONObject("Engine Information").getJSONObject("Engine Statistics")
						.getInt("Horsepower"));
				arrayReturn.put(objReturn);

			} else if (tipoVelocidades != velocidades) {
				System.out.println("No tiene 6 velocidades");
			}
			marcaModeloComienzo++;
		}
		return arrayReturn;

	}*/

}
