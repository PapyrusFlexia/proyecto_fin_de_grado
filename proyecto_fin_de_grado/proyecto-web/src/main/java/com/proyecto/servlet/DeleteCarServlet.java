package com.proyecto.servlet;

import java.io.IOException;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import com.proyecto.model.Car;
import com.proyecto.model.CarImage;
import com.proyecto.services.CarService;
import com.proyecto.services.data.DatabaseJson;

@WebServlet(name = "DeleteCarServlet", urlPatterns = { "/delete" })

public class DeleteCarServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doGet(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dispatcher = "./detalles.jsp";
		String transmission = request.getParameter("transmission");
		String enginetype = request.getParameter("enginetype");
		String driveline = request.getParameter("driveline");
		String horsepower = request.getParameter("horsepower");
		String torque = request.getParameter("torque");
		String numberofforwardgears = request.getParameter("numberofforwardgears");
		String make = request.getParameter("make");
		String modelyear = request.getParameter("modelyear");
		String name = request.getParameter("name");
		String classification = request.getParameter("classification");
		String year = request.getParameter("year");
		String width = request.getParameter("width");
		String length = request.getParameter("length");
		String height = request.getParameter("height");
		String highwaympg = request.getParameter("highwaympg");
		String citymph = request.getParameter("citymph");
		String fuelType = request.getParameter("fuelType");
		String id = request.getParameter("id");
		String redirect = request.getParameter("redirect");

		// Validator

		if (id != null && !id.equals("")) {

			carService.delete(Integer.parseInt(id));

			request.setAttribute("executed", "ok");

		}
		try {
			mainController.delete(request, response);
			dispatcher = "./detalles.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			dispatcher = "./error.jsp";
		}

		request.setAttribute("id", utilsService.getCarsId());
		request.setAttribute("years", utilsService.getCarsYears());
		request.setAttribute("makes", utilsService.getCarsMakes());
		request.setAttribute("hybrids", utilsService.getEngineHybrids());
		request.setAttribute("classifications",  utilsService.getCarsClassificationsTabla());
		
		request.getRequestDispatcher("/detalles.jsp").forward(request, response);

	}

	public static String decodeValue(String value) {
		String result = "";
		try {
			result = java.net.URLDecoder.decode(value, StandardCharsets.UTF_8.name());
		} catch (UnsupportedEncodingException e) {
			// not going to happen - value came from JDK's own StandardCharsets
		}
		return result;
	}

}