<%@page import="com.practicas.model.Car"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Exercise 2</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<%
		String paginaActual = (String) request.getAttribute("page");
	int siguiente = -1;
	int anterior = -1;
	if (paginaActual == null) {
		paginaActual = "1";
	}
	String modelo = (String) request.getAttribute("page");

	int paginaComienzo = Integer.valueOf(paginaActual);
	if (paginaComienzo > 1) {
		anterior = paginaComienzo - 1;
	}
	siguiente = paginaComienzo + 1;

	List<String> idTabla = (List<String>) request.getAttribute("id");
	List<String> modeloTabla = (List<String>) request.getAttribute("makes");
	List<Car> cochesTabla = (List<Car>) request.getAttribute("cars");
	%>

	<div class="tablaCoches">
		<h2>Listado de Coches</h2>
		<span class="navbar">Acciones</span>
		<div class="navbar-collapse"></div>
		<table class="table table-responsive w-50 p-6">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Modelo</th>
					<th scope="col">Marca</th>

				</tr>
			</thead>
			<tbody>
				<%
					List<Car> cars = (List<Car>) request.getAttribute("cars");
				if (cars != null) {
					for (Car c : cars) {
				%>
				<tr>
					<th><%=c.getPk()%></th>
					<td><%=c.getIdentification().getId()%></td>
					<td><%=c.getIdentification().getMake()%></td>
				</tr>
				<%
					}
				} else {
				%>
				<%
					}
				%>
			</tbody>
		</table>
		<%
			
		%>
		

	</div>

</body>
</html>