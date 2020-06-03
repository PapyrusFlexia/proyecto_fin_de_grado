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

@WebServlet(name = "UpdateCarServlet", urlPatterns = { "/update" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)

public class UpdateCarServlet extends AbstractServlet {
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
		//String hybrid = request.getParameter("hybrid");
		//if (hybrid == null) {
		//	hybrid = "false";
		//}

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

		
		List<Part> fileParts = request.getParts().stream()
				.filter(part -> part.getName().contains("image") && part.getSize() > 0).collect(Collectors.toList());
		List<CarImage> cImages = new ArrayList<>();
		for (Part p : fileParts) {

			byte[] bytes = IOUtils.toByteArray(p.getInputStream());
			String nameImage = p.getName();
			CarImage cImage = new CarImage();
			cImage.setImage(bytes);
			cImage.setName(nameImage);
			cImage.setCarid(Integer.parseInt(pk));
			cImages.add(cImage);
			carService.insertImage(cImage);
		}
		

		// Validator
		
		if (transmission != null && !transmission.equals("") && enginetype != null && !enginetype.equals("")
				&& horsepower != null && Integer.valueOf(horsepower) > 0 && torque != null
				&& Integer.valueOf(torque) > 0 && numberofforwardgears != null
				&& !numberofforwardgears.equals("") && driveline != null && !driveline.equals("") && make != null
				&& !make.equals("") && modelyear != null && !modelyear.equals("") && classification != null
				&& !classification.equals("") && year != null && !year.equals("") && Integer.valueOf(year) >= 2009
				&& Integer.valueOf(year) <= 2020 && width != null && Integer.valueOf(width) > 0 && length != null
				&& Integer.valueOf(length) > 0 && height != null && Integer.valueOf(height) > 0 && highwaympg != null
				&& Integer.valueOf(highwaympg) > 0 && citymph != null && Integer.valueOf(citymph) > 0
				&& fuelType != null && !fuelType.equals("") && name != null && !name.equals("")) {

			carService.update(Integer.parseInt(pk), transmission, enginetype, Integer.parseInt(horsepower),
					Integer.parseInt(horsepower), Integer.parseInt(numberofforwardgears),
					driveline, make, Boolean.parseBoolean(hybrid),  modelyear, name, classification, Integer.parseInt(year), Integer.parseInt(width),
					Integer.parseInt(length), Integer.parseInt(height), Integer.parseInt(highwaympg),
					Integer.parseInt(citymph), fuelType);

			request.setAttribute("executed", "ok");

		}
		try {
			mainController.detalles(request, response);
			dispatcher = "./detalles.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			dispatcher = "./error.jsp";
		}
		request.setAttribute("pk", utilsService.getCarsPk());
		request.setAttribute("years", utilsService.getCarsYears());
		request.setAttribute("makes", utilsService.getCarsMakes());
		request.setAttribute("hybrids", utilsService.getCarsHybrids());
		request.setAttribute("classifications",  utilsService.getCarsClassificationsTabla());

		request.getRequestDispatcher("/detalles.jsp").forward(request, response);
		;

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