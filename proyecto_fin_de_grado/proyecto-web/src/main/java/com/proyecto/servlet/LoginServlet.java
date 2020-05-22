package com.proyecto.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", 
	urlPatterns = { "/login" }, 
	initParams = {@WebInitParam(name = "login", value = "root") , @WebInitParam(name = "pass", value = "root") })
public class LoginServlet extends HttpServlet {
	
	

	private static final long serialVersionUID = -1720688734823865429L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		request.getRequestDispatcher("./login.jsp").forward(request, response);
		HttpSession session = request.getSession();
		
		String captcha = (String) session.getAttribute("captcha");
		String code = (String) request.getParameter("code");
		if (captcha != null && code != null) {
			if (captcha.equals(code)) {
				System.out.print("<p class='alert'>Correct</p>");
			} else {
				System.out.print("<p class='alert'>Incorrect</p>");
			}
		}
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