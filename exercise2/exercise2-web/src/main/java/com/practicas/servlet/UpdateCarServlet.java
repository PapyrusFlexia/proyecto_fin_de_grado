package com.practicas.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practicas.model.Car;
import com.practicas.services.CarService;
import com.practicas.services.data.DatabaseJson;

public class UpdateCarServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String engineType = request.getParameter("enginetype");
		String driveline = request.getParameter("driveline");
		
		String pk = request.getParameter("pk");
		
		String redirect = request.getParameter("redirect");
		
		// Validar 
		
		
		Optional<Car> carOp = CarService.getCarByPk(Integer.valueOf(pk));
		
		if(carOp.isPresent()) {
			
			Car car = carOp.get();
			
			car.getEngineinformation().setDriveline(driveline);
			car.getEngineinformation().setEnginetype(engineType);
			
			int contador = 0;
			for(Car c :DatabaseJson.loadDatabase().getDataParsed()) {
				if(c.getPk() == Integer.valueOf(pk)) {
					DatabaseJson.loadDatabase().getDataParsed().set(contador, c);
				}
				contador ++;
			}
		}
		
		request.getRequestDispatcher("./?"+decodeValue(redirect)).forward(request, response);;
	
	}
	
	
	public static String decodeValue(String value) {
		String result = "";
		try{
	    	result = java.net.URLDecoder.decode(value, StandardCharsets.UTF_8.name());
		} catch (UnsupportedEncodingException e) {
		    // not going to happen - value came from JDK's own StandardCharsets
		}
		return result;
	}

}