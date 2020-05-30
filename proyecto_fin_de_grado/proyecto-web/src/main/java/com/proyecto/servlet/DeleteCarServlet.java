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
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)

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
		String dispatcher = "./index.jsp";
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
		request.setAttribute("hybrids", utilsService.getCarsHybrids());
		request.setAttribute("classifications",  utilsService.getCarsClassificationsTabla());
		
		request.getRequestDispatcher("/delete.jsp").forward(request, response);
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