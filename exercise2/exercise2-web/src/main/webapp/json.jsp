<%@page import="java.io.UnsupportedEncodingException"%>
<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="com.practicas.model.Identification"%>
<%@page import="com.practicas.model.Car"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
List<String> identifications = (List<String>)request.getAttribute("makes");
List<Integer> years = (List<Integer>)request.getAttribute("years");
List<Car> cars = (List<Car>) request.getAttribute("cars");
%>
{
	'filters':{
		'makes':[
			<%
			int total = identifications.size();
			int contador = 0;
			String sep = ",";
			for (String make: identifications){ 
				contador ++;
				if(contador == total){
					sep="";
					
				}
			%>
				{
					'id': '<%=make %>',
					'value': '<%=make %>'
				}<%=sep %>
			<%} %>
		],
		'years':[
		
		]
	},
	'cars':[
	
	]
}