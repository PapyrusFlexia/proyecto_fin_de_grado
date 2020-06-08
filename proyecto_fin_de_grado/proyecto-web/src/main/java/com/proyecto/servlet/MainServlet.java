package com.proyecto.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.proyecto.model.CarImage;
import com.proyecto.services.UtilsService;
import com.proyecto.servlet.controller.MainController;

@WebServlet(name = "MainServlet", urlPatterns = {
		"" }, initParams = @WebInitParam(name = "location", value = "Hola"), loadOnStartup = 1)
public class MainServlet extends AbstractServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		String dispatcher = "./index.jsp";
		String filterMake = request.getParameter("make");
		String filterYear = request.getParameter("year");
		String filterHybrid = request.getParameter("hybrid");

		if (action == null || action.equals("") && (filterMake == null && filterYear == null && filterHybrid == null)) {
			mainController.MainAction(request, response);
		} else if ("paginacion".contentEquals(action)
				&& (filterMake == null && filterYear == null && filterHybrid == null)) {
			mainController.paginacion(request, response);
		}
		if (filterMake != null || filterYear != null || filterHybrid != null) {
			mainController.filtrar(request, response);
		} else if ("detalles".equals(action)) {
			try {
				mainController.detalles(request, response);
				dispatcher = "./detalles.jsp";

			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("message", e.getMessage());
				dispatcher = "./error.jsp";
			}
		} else if ("booking".equals(action)) {
			dispatcher = "./booking.jsp";
			try {
				mainController.detalles(request, response);
				dispatcher = "./booking.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("message", e.getMessage());
				dispatcher = "./error.jsp";
			}

		} else if ("insert".equals(action)) {
			dispatcher = "./insert.jsp";
			try {
				mainController.detalles(request, response);
				dispatcher = "./insert.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("message", e.getMessage());
				dispatcher = "./error.jsp";
			}
		}

		if (request.getParameter("parse") != null && !request.getParameter("parse").equals("")) {
			dispatcher = "./json.jsp";
		}

		request.setAttribute("years", utilsService.getCarsYears());
		request.setAttribute("makes", utilsService.getCarsMakes());
		request.setAttribute("hybrids", utilsService.getCarsHybrids());
		request.getRequestDispatcher(dispatcher).forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		super.doPost(request, response);
	}

}