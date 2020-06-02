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
import com.proyecto.model.User;
import com.proyecto.services.CarService;
import com.proyecto.services.data.DatabaseJson;

@WebServlet(name = "RegisterServlet", urlPatterns = { "/register" })
public class RegisterServlet extends AbstractServlet {

	private static final long serialVersionUID = -1720688734823865429L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("./register.jsp").forward(request, response);
		;

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
		String email = request.getParameter("mail");
		String firstname = request.getParameter("fname");
		String lastname = request.getParameter("lname");
		String password = request.getParameter("password");
	

		// Validator
		if (email != null && !email.equals("") && firstname != null && !firstname.equals("")
				&& lastname != null && !lastname.equals("") && password != null
				&& !password.equals("")) {
			try {
				User user = new User();
			
				user.setEmail(email);
				user.setFirstName(firstname);
				user.setLastName(lastname);
				user.setPassword(password);
				user = carService.saveUser(user);
				carService.insertUser(user);

				request.setAttribute("executed", "ok");
				request.getRequestDispatcher("./login.jsp").forward(request, response);
				
			} catch (Exception e) {
				request.setAttribute("executed", "ok");
				request.getRequestDispatcher("./login.jsp").forward(request, response);
				try {
					mainController.insertarUser(request, response);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				//dispatcher = "./register.jsp";
			}
			
			

		}
	}

}