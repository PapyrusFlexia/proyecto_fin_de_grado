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
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<style>
.table .thead-light th {
	margin: auto;
	width: 50% !important;
	color: #401500;
	background-color: #FFDDCC;
	border-color: #792700;
}
</style>
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
	List<Integer> anno = (List<Integer>) request.getAttribute("years");
	List<Car> cochesTabla = (List<Car>) request.getAttribute("cars");
	%>

	<div class="row ml-2 mt-3 mb-2 d-flex justify-content-between">
		<h2>Filtros:</h2>
		<div class="form-group col-2">
			<select class="form-control" id="sel1">
				<option value="">Por Modelo</option>
				<%
					if (modeloTabla != null) {

					for (String m : modeloTabla) {
				%>
				<option value="<%=m%>"><%=m%></option>
				<%
					}

				}
				%>
			</select>
		</div>
		<div class="form-group col-2 ">
			<select class="form-control">
				<option value="">Por año</option>
				<%
					if (anno != null) {

					for (Integer a : anno) {
				%>
				<option value="<%=a%>"><%=a%></option>
				<%
					}

				}
				%>
			</select>
		</div>
	</div>

	<div class="table-responsive tablaCoches">
		<h3>Coches</h3>
		<table class="table table-hover table-responsive ">
			<thead class="thead-light">
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Modelo</th>
					<th scope="col">Marca</th>
					<th scope="col">Año</th>

				</tr>
			</thead>
			<tbody>
				<%
					if (cochesTabla != null) {
					for (Car c : cochesTabla) {
				%>
				<tr>
					<th><%=c.getPk()%></th>
					<td><%=c.getIdentification().getId()%></td>
					<td><%=c.getIdentification().getMake()%></td>
					<td><%=c.getIdentification().getYear()%></td>
					<td>
						<button type="button" class="btn btn-default">
							<span class="glyphicon glyphicon-eye-open"></span>
						</button>
					</td>
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
		<input type="hidden" name="page" id="page" value="<%=paginaActual%>" />
		<input type="hidden" name="makeFilterValue" id="makeFilterValue"
			value="<%=modeloTabla%>" /> <input type="hidden"
			name="yearFilterValue" id="yearFilterValue" value="<%=anno%>" /> <span
			class="navbar">Acciones</span>
		<div class="navbar-collapse"></div>
		<%
			
		%>

		<ul class="pagination">
			<li class="page-item" <%if (anterior < 0) {%> disabled="disabled"
				<%}%>><a class="page-link" <%if (anterior > 0) {%>
				href="./?action=paginacion&page=<%=anterior%>" <%}%>
				<%if (anterior < 0) {%> tabindex="-1" aria-disabled="true" <%}%>>Anterior</a>
			</li>
			<%
				if (anterior > 0) {
			%>
			<li class="page-item"><a class="page-link"
				href="./?action=paginacion&page=<%=anterior%>"><%=anterior%></a></li>
			<%
				}
			%>
			<li class="page-item active" aria-current="page"><a
				class="page-link" href="#"><%=paginaActual%> <span
					class="sr-only"><%=paginaActual%></span></a></li>
			<%
				if (siguiente > 0) {
			%>
			<li class="page-item"><a class="page-link"
				href="./?action=paginacion&page=<%=siguiente%>"><%=siguiente%></a></li>
			<%
				}
			%>
			<li class="page-item"><a class="page-link"
				href="./?action=paginacion&page=<%=siguiente%>">Siguiente</a></li>
		</ul>



	</div>
	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							$('.filterYear')
									.change(
											function() {
												var valor = $(this).children(
														"option:selected")
														.val();
												location.href = './?action=paginacion&filterYear='
														+ valor
														+ '&filterMake='
														+ $('#makeFilterValue')
																.val()
														+ '&page='
														+ $('#page').val();
											});
							$('.filterMake')
									.change(
											function() {
												var valor = $(this).children(
														"option:selected")
														.val();
												location.href = './?action=paginacion&filterMake='
														+ valor
														+ '&filterYear='
														+ $('#yearFilterValue')
																.val()
														+ '&page='
														+ $('#page').val();
											});
						});
	</script>

</body>
</html>