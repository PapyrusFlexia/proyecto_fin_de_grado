package com.practicas.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "CarsFilter", urlPatterns = {"/*"})
public class CarsFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest hRequest = (HttpServletRequest)request;
		HttpServletResponse hResponse = (HttpServletResponse)response;
		
		System.out.println(hRequest.getRequestURI());
		
		/*if(hRequest.getRequestURI().indexOf("login") > 0 || (hRequest.getSession(false) != null && hRequest.getSession(false).getAttribute("username") != null)) {
			*/
		chain.doFilter(request, response);
		/*}else {
			hRequest.setAttribute("message", "Unauthorized");
			hRequest.getRequestDispatcher("/error.jsp").forward(request, response);;
			//hResponse.sendRedirect("./error.jsp");
			//hResponse.sendError(403, "no autorizado");
		}*/
		
		
		
		
		
	}

	@Override
	public void destroy() {

	}

}