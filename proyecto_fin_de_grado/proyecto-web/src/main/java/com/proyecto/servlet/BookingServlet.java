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

import com.proyecto.services.UtilsService;
import com.proyecto.servlet.controller.MainController;

@WebServlet(name = "BookingServlet", urlPatterns = { "/booking" })
public class BookingServlet extends AbstractServlet {

	private static final long serialVersionUID = -1720688734823865429L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String action = request.getParameter("action");
		String dispatcher = "./booking.jsp";
		String filterMake = request.getParameter("make");
		String filterYear = request.getParameter("year");
		String filterHybrid = request.getParameter("hybrid");
		String filterClassification = request.getParameter("classification");
		if (action == null || action.equals("") && (filterMake == null && filterYear == null && filterHybrid == null && filterClassification == null)) {
			mainController.MainAction(request, response);
		} else if ("paginacion".contentEquals(action) && (filterMake == null && filterYear == null && filterHybrid == null && filterClassification == null)) {
			mainController.paginacion(request, response);
		}
		if (filterMake != null || filterYear != null || filterHybrid != null || filterClassification != null) {
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
			
		}else if("booking".equals(action)) {
			dispatcher = "./booking.jsp";
			try {
				mainController.detalles(request, response);
				dispatcher = "./booking.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("message", e.getMessage());
				dispatcher = "./error.jsp";
			}
		}
		
		if(request.getParameter("parse") != null && !request.getParameter("parse").equals("")) {
			dispatcher = "./json.jsp";
		} 

		request.setAttribute("years", utilsService.getCarsYears());
		request.setAttribute("makes", utilsService.getCarsMakes());
		request.setAttribute("hybrids", utilsService.getEngineHybrids());
		request.setAttribute("classifications",  utilsService.getCarsClassificationsTabla());
		request.getRequestDispatcher(dispatcher).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String pass = request.getParameter("pass");
		
		if(getInitParameter("login").equals(login) && 
				getInitParameter("pass").equals(pass)){
			
			request.getSession(true).setAttribute("username", login);
			response.sendRedirect("./");
		}else {
		
			request.getRequestDispatcher("./booking.jsp").forward(request, response);
		}
		
		
	}

	

}