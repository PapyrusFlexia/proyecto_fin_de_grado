package com.proyecto.servlet;

import java.io.IOException;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
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

@WebServlet(name = "InsertCarServlet", urlPatterns = { "/insert" })
public class InsertCarServlet extends AbstractServlet {

	private static final long serialVersionUID = -1720688734823865429L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("pk", utilsService.getCarsPk());
		request.setAttribute("years", utilsService.getCarsYears());
		request.setAttribute("makes", utilsService.getCarsMakes());
		request.setAttribute("hybrids", utilsService.getCarsHybrids());
		request.setAttribute("classifications", utilsService.getCarsClassificationsTabla());
		request.setAttribute("transmissions", utilsService.getCarsTransmissions());
		request.setAttribute("drivelines", utilsService.getCarsDriveLines());
		request.setAttribute("fueltypes", utilsService.getCarsFuelTypes());

		request.getRequestDispatcher("/insert.jsp").forward(request, response);
		;

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		String dispatcher = "./insert.jsp";
		String transmission = request.getParameter("transmission");
		String enginetype = request.getParameter("enginetype");
		String driveline = request.getParameter("driveline");
		String horsepower = request.getParameter("horsepower");
		String torque = request.getParameter("torque");

		// String id = request.getParameter("pk");
		String numberofforwardgears = request.getParameter("numberofforwardgears");
		String make = request.getParameter("make");
		String hybrid = request.getParameter("hybrid");
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
		String pk = request.getParameter("pk");
		String redirect = request.getParameter("redirect");

		// Validator
		//&& pk != null && !pk.equals("")
		if (transmission != null && !transmission.equals("") && enginetype != null && !enginetype.equals("")
				&& horsepower != null && Integer.valueOf(horsepower) > 0 && torque != null
				&& Integer.valueOf(torque) > 0 && numberofforwardgears != null && !numberofforwardgears.equals("")
				&& driveline != null && !driveline.equals("") && make != null
				&& !make.equals("") && hybrid != null && modelyear != null && !modelyear.equals("") && classification != null
				&& !classification.equals("") && year != null && !year.equals("") && Integer.valueOf(year) >= 2009
				&& Integer.valueOf(year) <= 2020 && width != null && Integer.valueOf(width) > 0 && length != null
				&& Integer.valueOf(length) > 0 && height != null && Integer.valueOf(height) > 0 && highwaympg != null
				&& Integer.valueOf(highwaympg) > 0 && citymph != null && Integer.valueOf(citymph) > 0
				&& fuelType != null && !fuelType.equals("") && name != null && !name.equals("")) {
			try {
				Car car = new Car();
				// car.setId(Integer.valueOf(id));
				car.setCitymph(Integer.valueOf(citymph));
				car.setEnginetype(enginetype);
				car.setHeight(Integer.valueOf(height));
				car.setHighwaympg(Integer.valueOf(highwaympg));
				car.setHorsepower(Integer.valueOf(horsepower));
				car.setLength(Integer.valueOf(length));
				car.setMake(make);
				car.setHybrid(Boolean.valueOf(hybrid));
				car.setModelyear(modelyear);
				car.setName(name);
				car.setNumberofforwardgears(Integer.valueOf(numberofforwardgears));
				car.setPk(0);
				car.setTorque(Integer.valueOf(torque));
				car.setWidth(Integer.valueOf(width));
				car.setYear(Integer.valueOf(year));
				car.setClassification(utilsService.getClassificationById(Integer.valueOf(classification)));
				car.setDriveline(utilsService.getDriveLineById(Integer.valueOf(driveline)));
				car.setFueltype(utilsService.getFuelTypeById(Integer.valueOf(fuelType)));
				car.setTransmission(utilsService.getTransmissionById(Integer.valueOf(transmission)));
				car = carService.save(car);
				carService.insert(car);

				request.setAttribute("executed", "ok");

			} catch (Exception e) {
				System.out.println("Error" + e.getMessage());
			}

		}
	}

}