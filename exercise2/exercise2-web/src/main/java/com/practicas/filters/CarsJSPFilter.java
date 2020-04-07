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

@WebFilter(filterName = "CarsJSPFilter", urlPatterns = {"*.jsp"})
public class CarsJSPFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest hRequest = (HttpServletRequest)request;
		HttpServletResponse hResponse = (HttpServletResponse)response;
		
		System.out.println(hRequest.getRequestURI());
		
		hResponse.sendError(403, "no autorizado");
	}

	@Override
	public void destroy() {

	}

}

