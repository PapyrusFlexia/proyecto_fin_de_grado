package com.practicas.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practicas.controller.MainController;
import com.practicas.model.Car;
import com.practicas.services.CarService;

public class MainServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		String dispatcher = "./index.jsp";
		String filterMake = request.getParameter("make");
		String filterYear = request.getParameter("year");
		MainController controller = new MainController();
		if (action == null || action.equals("") && (filterMake == null && filterYear == null)) {
			controller.MainAction(request, response);
		} else if ("paginacion".contentEquals(action) && (filterMake == null && filterYear == null)) {
			controller.paginacion(request, response);
		}
		if (filterMake != null || filterYear != null) {
			controller.filtrar(request, response);
		} else if ("detalles".equals(action)) {
			try {
				controller.detalles(request, response);
				dispatcher = "./detalles.jsp";
			} catch (Exception e) {
				request.setAttribute("message", e.getMessage());
				dispatcher = "./error.jsp";
			}

		}

		request.setAttribute("years", CarService.getCarsYears());
		request.setAttribute("makes", CarService.getCarsMakes());
		request.getRequestDispatcher(dispatcher).forward(request, response);;
		

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		super.doPost(request, response);
	}

}
