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
import com.practicas.model.Classification;
import com.practicas.model.Dimensions;
import com.practicas.model.DriveLine;
import com.practicas.model.FuelType;
import com.practicas.model.Make;
import com.practicas.model.Transmission;
import com.practicas.services.UtilsService;
import com.practicas.services.data.DatabaseJson;

@WebServlet(name = "PopulateServlet", urlPatterns = { "/populate" })
public class PopulateServlet extends AbstractServlet {

	private static final long serialVersionUID = -1720688734823865429L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String param = request.getParameter("model");
		int start = 0;
		if(request.getParameter("start") != null && !request.getParameter("start").equals("")){
			start = Integer.valueOf(request.getParameter("start"));
		}
		if(param.equals("test")) {
			try {
				Make m = utilsService.getMakeByName("AUDI");
				System.out.println(m);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		JSONArray array = DatabaseJson.loadDatabase().getData();
		System.out.println("total --> "+array.length());
		for(int i=start ; i < array.length(); i++) {

			JSONObject json = array.getJSONObject(i);
			if (param != null && param.equals("makes")) {
				String make = json.getJSONObject("identification").getString("make");
				Make m = new Make();
				m.setMake(make);
				utilsService.saveMake(m);
			} else if (param != null && param.equals("fuel")) {
				String fuel = json.getJSONObject("fuelinformation").getString("fueltype");
				FuelType f = new FuelType();
				f.setFuelType(fuel);
				utilsService.saveFuelType(f);
			} else if (param != null && param.equals("drive")) {
				String driveline = json.getJSONObject("engineinformation").getString("driveline");
				DriveLine d = new DriveLine();
				d.setDriveLine(driveline);
				utilsService.saveDriveLine(d);
			} else if (param != null && param.equals("transmission")) {
				String transmission = json.getJSONObject("engineinformation").getString("transmission");
				Transmission t = new Transmission();
				t.setTransmission(transmission);
				utilsService.saveTransmission(t);
			} else if (param != null && param.equals("classification")) {
				String classification = json.getJSONObject("identification").getString("classification");
				Classification c = new Classification();
				c.setClassification(classification);
				utilsService.saveClassification(c);
			} else if (param != null && param.equals("car")) {
				try {
					Car c = new Car();
					c.setCitymph(json.getJSONObject("fuelinformation").getInt("citymph"));
					c.setHighwaympg(json.getJSONObject("fuelinformation").getInt("highwaympg"));
					c.setFueltype(utilsService
							.getFuelTypeByName(json.getJSONObject("fuelinformation").getString("fueltype")));
					c.setTorque(
							json.getJSONObject("engineinformation").getJSONObject("enginestatistics").getInt("torque"));
					c.setHorsepower(json.getJSONObject("engineinformation").getJSONObject("enginestatistics")
							.getInt("horsepower"));
					c.setDriveLine(utilsService
							.getDriveLineByName(json.getJSONObject("engineinformation").getString("driveline")));
					c.setTransmission(utilsService
							.getTransmissionByName(json.getJSONObject("engineinformation").getString("transmission")));
					c.setEnginetype(json.getJSONObject("engineinformation").getString("enginetype"));
					c.setMake(utilsService.getMakeByName(json.getJSONObject("identification").getString("make")));
					c.setClassification(utilsService
							.getClassificationByName(json.getJSONObject("identification").getString("classification")));
					c.setName(json.getJSONObject("identification").getString("id"));
					c.setYear(json.getJSONObject("identification").getInt("year"));
					c.setModelyear(json.getJSONObject("identification").getString("modelyear"));
					c.setWidth(json.getJSONObject("dimensions").getInt("width"));
					c.setLength(json.getJSONObject("dimensions").getInt("length"));
					c.setHeight(json.getJSONObject("dimensions").getInt("height"));
					c = carService.save(c);
					//System.out.println(c);
				
				} catch (Exception e) {
					System.out.println(json);
					System.out.println("Error" + e.getMessage());
				}
			}

		}

	}

}