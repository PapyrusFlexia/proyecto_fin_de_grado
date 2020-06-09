package com.proyecto.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LogoutServlet", 
	urlPatterns = { "/logout" }, 
	initParams = {@WebInitParam(name = "login", value = "test") , @WebInitParam(name = "pass", value = "test") })
public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = -1720688734823865429L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		request.getSession().invalidate();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doGet(request, response);
		
		
	}

	

}