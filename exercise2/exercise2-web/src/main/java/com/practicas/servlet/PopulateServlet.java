package com.practicas.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.practicas.model.Car;
import com.practicas.model.DriveLine;
import com.practicas.model.FuelType;
import com.practicas.model.Make;
import com.practicas.model.Transmission;
import com.practicas.services.UtilsService;
import com.practicas.services.data.DatabaseJson;

@WebServlet(name = "PopulateServlet", 
	urlPatterns = { "/populate" })
public class PopulateServlet extends AbstractServlet {

	private static final long serialVersionUID = -1720688734823865429L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String param = request.getParameter("model");
		
		JSONArray array = DatabaseJson.loadDatabase().getData();
		for(int i=0 ; i < array.length(); i++) {
			
			JSONObject json = array.getJSONObject(i);
			if(param != null && param.equals("makes")) {
				String make = json.getJSONObject("identification").getString("make");
				Make m = new Make();
				m.setMake(make);
				utilsService.saveMake(m);
			}else if(param != null && param.equals("fuel")) {
				String fuel = json.getJSONObject("fuelinformation").getString("fueltype");
				FuelType f = new FuelType();
				f.setFuelType(fuel);
				utilsService.saveFuelType(f);
			}else if(param != null && param.equals("drive")) {
				String driveline = json.getJSONObject("engineinformation").getString("driveline");
				DriveLine d = new DriveLine();
				d.setDriveLine(driveline);
				utilsService.saveDriveLine(d);
			}else if(param != null && param.equals("transmission")) {
				String transmission = json.getJSONObject("engineinformation").getString("transmission");
				Transmission t = new Transmission();
				t.setTransmission(transmission);
				utilsService.saveTransmission(t);
			}
			Car c = new Car();
			
		}

	}

}