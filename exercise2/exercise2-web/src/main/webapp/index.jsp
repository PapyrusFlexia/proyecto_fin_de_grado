<%@page import="java.io.UnsupportedEncodingException"%>
<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="com.practicas.model.Identification"%>
<%@page import="com.practicas.model.Car"%>
<%@page import="java.util.List"%>
<%@page import="com.practicas.model.Identification"%>
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
<link rel="stylesheet" type="text/css" href="css/css.css">

</head>
<body>

	<div class="bs-example">

		<nav class="navbar navbar-expand-md navbar-dark bg-dark">



			<button type="button" class="navbar-toggler" data-toggle="collapse"
				data-target="#navbarCollapse">

				<span class="navbar-toggler-icon"></span>

			</button>

			<div class="collapse navbar-collapse" id="navbarCollapse">

				<div class="navbar-nav">

					<a href="#"
						class="nav-item nav-link active font-weight-bold text-uppercase"
						data-toggle="tooltip" data-placement="bottom" title="">Coches</a>
				</div>
			</div>


		</nav>


		<%
			String paginaActual = (String) request.getAttribute("page");
		int siguiente = -1;
		int anterior = -1;
		if (paginaActual == null) {
			paginaActual = "1";
		}
		String modeloFiltro = (String) request.getAttribute("make");
		String annoFiltro = (String) request.getAttribute("year");
		if (annoFiltro == null) {
			annoFiltro = "0";
		}
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
	</div>
	<div class="row ml-2 mt-3 mb-2 d-flex justify-content-between">
		<h2 class="float-left align-self-center">Filtros:</h2>
		<div class="form-group col-2"></div>
	</div>



	<div class="form-group col-2 align-self-center">
		<ul class="navbar-nav">
			<li class="nav-item active"><select class="form-control"
				data-live-search="true" title="Filter by makes" id="make">
					<option value="-1">FILTRAR POR MARCA</option>
					<%
						for (String model : modeloTabla) {
					%>
					<option <%if (model.equals(modeloFiltro)) {%> selected <%}%>
						value="<%=model%>"><%=model%></option>
					<%
						}
					%>
			</select></li>
			<li class="nav-item"><select class="form-control"
				data-live-search="true" title="Filter by year" id="year">
					<option value="-1">FILTRAR POR AÑO</option>
					<%
						for (Integer year : anno) {
					%>
					<option <%if (year.equals(annoFiltro)) {%> selected <%}%>
						value="<%=year%>"><%=year%></option>
					<%
						}
					%>
			</select></li>
		</ul>
	</div>

	<table class="table table-hover table-responsive ">
		<thead class="thead-light">
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Modelo</th>
				<th scope="col">Marca</th>
				<th scope="col">Año</th>
				<th scope="col">Acciones</th>

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
					<div class="dropdown">
									  <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Acciones
									  <span class="caret"></span></button>
									  <ul class="dropdown-menu">
									    <li><a href="./?action=detalles&pk=<%=c.getPk() %>&redirect=<%=encodeValue(request.getQueryString())%>"><span class="glyphicon glyphicon-eye-open"></span></a></li>
									    <li><a href="#"><span class="glyphicon glyphicon-trash"></span></a></li>
									  </ul>
									</div>
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
		value="<%=modeloFiltro%>" />
	<input type="hidden" name="yearFilterValue" id="yearFilterValue"
		value="<%=annoFiltro%>" />
	<div class="row ml-2 mt-3 mb-2 d-flex justify-content-between">
		<h2 class="float-left align-self-center">Paginación:</h2>
		<div class="form-group col-2"></div>
		<div class="navbar-collapse"></div>


		<%
			
		%>

		<ul class="pagination">

			<li class="page-item" <%if (anterior < 0) {%> disabled="disabled"
				<%}%>><a class="page-link" <%if (anterior > 0) {%>
				href="./?action=paginacion&page=<%=anterior%>" <%}%>
				<%if (anterior < 0 && annoFiltro != null && modeloFiltro != null) {%>
				tabindex="-1" aria-disabled="true" <%}%>>Anterior</a></li>
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
				} else if (annoFiltro != null && modeloFiltro != null) {
			%>
			<li class="page-item"><a class="page-link"
				href="./?action=paginacion&year=<%=annoFiltro%>&make=<%=modeloFiltro%>&page=<%=siguiente%>"><%=siguiente%></a></li>
			<%
				}
			%>
			<%
				if (annoFiltro == null && modeloFiltro == null) {
			%>
			<li class="page-item"><a class="page-link"
				href="./?action=paginacion&page=<%=siguiente%>">Siguiente</a></li>
			<%
				} else if (annoFiltro != null && modeloFiltro != null) {
			%>
			<li class="page-item"><a class="page-link"
				href="./?action=paginacion&year=<%=annoFiltro%>&make=<%=modeloFiltro%>&page=<%=siguiente%>">Siguiente</a></li>
			<%
				}
			%>
			<li class="page-item"><a class="page-link"
				href="http://localhost:8080/exercise2-web/">VOLVER A VALORES POR
					DEFECTO</a></li>
		</ul>



	</div>

	<%!  private static String encodeValue(String value) {
        String url = "";
		try {
			url = URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (Exception ex) {
            
        }
		return url;
    } %>
	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							$('#year')
									.change(
											function() {
												var valor = $(this).children(
														"option:selected")
														.val();
												location.href = './?action=paginacion&year='
														+ valor
														+ '&make='
														+ $('#makeFilterValue')
																.val()
														+ '&page=0';
											});
							$('#make')
									.change(
											function() {
												var valor = $(this).children(
														"option:selected")
														.val();
												location.href = './?action=paginacion&year='
														+ $('#yearFilterValue')
																.val()
														+ '&make='
														+ valor
														+ '&page=0';
											});
							
							<%if (anno != null) {%>
							$("#year option[value=<%=anno%>]").attr('selected', 'selected');
							<%}%>
							<%if (modeloTabla != null) {%>
							$("#make option[value=<%=modeloTabla%>']").attr('selected',
							'selected');
	<%}%>
		});
	</script>

</body>
</html>