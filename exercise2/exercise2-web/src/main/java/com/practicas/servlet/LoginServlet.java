package com.practicas.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", 
	urlPatterns = { "/login" }, 
	initParams = {@WebInitParam(name = "login", value = "") , @WebInitParam(name = "pass", value = "") })
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -1720688734823865429L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		request.getRequestDispatcher("./login.jsp").forward(request, response);
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
		
			request.getRequestDispatcher("./login.jsp").forward(request, response);
		}
		
		
	}

	

}