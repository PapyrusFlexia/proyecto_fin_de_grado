<%@page import="java.io.UnsupportedEncodingException"%>
<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.List"%>
<%@page import="com.proyecto.model.Car"%>
<%@page import="com.proyecto.model.Make"%>
<%@page import="com.proyecto.model.Classification"%>
<%@page import="com.proyecto.model.Engine"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Organizatium</title>
<meta content="" name="descriptison">
<meta content="" name="keywords">

<link href="assets/img/icon1.png" rel="icon">
<link href="assets/img/icon1.png" rel="apple-touch-icon">

<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<link href="assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="assets/vendor/icofont/icofont.min.css" rel="stylesheet">
<link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
<link href="assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link href="assets/vendor/owl.carousel/assets/owl.carousel.min.css"
	rel="stylesheet">
<link href="assets/vendor/venobox/venobox.css" rel="stylesheet">
<link href="assets/vendor/aos/aos.css" rel="stylesheet">

<link href="assets/css/style.css" rel="stylesheet">
<script src="assets/vendor/jquery/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css">
	<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.21/css/dataTables.bootstrap4.min.css">

<script type="text/javascript" charset="utf8" src="/DataTables/datatables.js"></script>

</head>

<body>
	<%
		String paginaActual = (String) request.getAttribute("page");
	int siguiente = -1;
	int anterior = -1;
	if (paginaActual == null) {
		paginaActual = "1";
	}
	String modeloFiltro = (String) request.getAttribute("make");
	int modeloFiltroInt = 0;
	if (modeloFiltro != null && !modeloFiltro.equals("") && !modeloFiltro.equals("null")) {
		modeloFiltroInt = Integer.valueOf(modeloFiltro);
	}
	String annoFiltro = (String) request.getAttribute("year");
	int annoFiltroInt = 0;
	if (annoFiltro != null && !annoFiltro.equals("") && !annoFiltro.equals("null")) {
		annoFiltroInt = Integer.valueOf(annoFiltro);
	}
	String hybridFiltro = (String) request.getAttribute("hybrid");
	int hybridFiltroInt = 0;
	if (hybridFiltro != null && !hybridFiltro.equals("") && !hybridFiltro.equals("null")) {
		hybridFiltroInt = Integer.valueOf(hybridFiltro);
	}
	String classificationFiltro = (String) request.getAttribute("classification");
	int classificationFiltroInt = 0;
	if (classificationFiltro != null && !classificationFiltro.equals("") && !classificationFiltro.equals("null")) {
		classificationFiltroInt = Integer.valueOf(classificationFiltro);
	}
	int paginaComienzo = Integer.valueOf(paginaActual);
	if (paginaComienzo > 1) {
		anterior = paginaComienzo - 1;
	}
	siguiente = paginaComienzo + 1;

	List<String> idTabla = (List<String>) request.getAttribute("id");
	List<Car> modeloTabla = (List<Car>) request.getAttribute("makes");
	List<Boolean> hybridTabla = (List<Boolean>) request.getAttribute("hybrids");
	List<Classification> classificationTabla = (List<Classification>) request.getAttribute("classifications");
	List<Integer> anno = (List<Integer>) request.getAttribute("years");
	List<Car> cochesTabla = (List<Car>) request.getAttribute("cars");
	%>


	<header id="header" class="fixed-top d-flex align-items-center">
		<div class="container d-flex align-items-center">

			<div class="logo mr-auto">
				<h1 class="text-light">
					<a onclick="location.href = 'http://localhost:8080/proyecto-web/';"><span>Organizatium</span></a>
				</h1>

			</div>

			<nav class="nav-menu d-none d-lg-block">
				<ul>


					<li class="get-started"><a
						onclick="location.href = 'http://localhost:8080/proyecto-web/login';">Login</a></li>

					<li class="get-started"><a
						onclick="location.href = 'http://localhost:8080/proyecto-web/';">Home</a></li>
			</nav>


		</div>
	</header>

	<section id="hero">

		<div class="container">
		
			
			<div class="row row justify-content-center">
				<div class="col-lg-6 order-1 order-lg-2 hero-img"
					data-aos="fade-left" data-aos-delay="200"></div>
					
					<div class="row row justify-content-center">
				<div class="col-lg-6 order-1 order-lg-2 hero-img"
					data-aos="fade-left" data-aos-delay="200"></div>
					
		


				<table class="table table-bordered table-striped text-center" id="booking" class="display">
					<thead class="thead-light">
						<tr>
							<th scope="col">Modelo<br> <a><span
									class="glyphicon glyphicon-chevron-up"></span><span
									class="glyphicon glyphicon-chevron-down"></span></a></th>
							<th scope="col">Marca<br> <a><span
									class="glyphicon glyphicon-chevron-up"></span><span
									class="glyphicon glyphicon-chevron-down"></span></a></th>
							<th scope="col">Año<br> <a><span
									class="glyphicon glyphicon-chevron-up"></span><span
									class="glyphicon glyphicon-chevron-down"></span></a></th>
							<th scope="col">Reservar</th>

						</tr>
					</thead>
					<tbody>
						<%
							if (cochesTabla != null) {
							for (Car c : cochesTabla) {
								Engine e = new Engine();
						%>
						<tr>
							<td><%=c.getName()%></td>
							<td><%=c.getMake()%></td>
							<td><%=c.getYear()%></td>
							<td>
									<button class="btn btn-primary reserved" type="button"
										data-toggle="dropdown">
										Reservar <span class="caret"></span>
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
					value="<%=modeloFiltro%>" /> <input type="hidden"
					name="yearFilterValue" id="yearFilterValue" value="<%=annoFiltro%>" />
				<input type="hidden" name="hybridFilterValue" id="hybridFilterValue"
					value="<%=hybridFiltro%>" /> <input type="hidden"
					name="classificationFilterValue" id="classificationFilterValue"
					value="<%=classificationFiltro%>" />
			</div>
		</div>
	

	</section>

	<main id="main">

		<section id="clients" class="clients clients">
			<div class="container">

				<div class="row">

					<div class="row ml-2 mt-3 mb-2 d-flex justify-content-between">
						<%
							
						%>

						<ul class="pagination">

							<li class="page-item" <%if (anterior < 0) {%> disabled="disabled"
								<%}%>><a class="page-link" <%if (anterior > 0) {%>
								href="./?action=paginacion&page=<%=anterior%>" <%}%>
								<%if (anterior < 0 && annoFiltro != null && modeloFiltro != null && hybridFiltro != null
		&& classificationFiltro != null) {%>
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
								} else if (annoFiltro != null && modeloFiltro != null && hybridFiltro != null && classificationFiltro != null) {
							%>
							<li class="page-item"><a class="page-link"
								href="./?action=paginacion&year=<%=annoFiltro%>&make=<%=modeloFiltro%>&hybrid=<%=hybridFiltro%>&classification=<%=classificationFiltro%>&page=<%=siguiente%>"><%=siguiente%></a></li>
							<%
								}
							%>
							<%
								if (annoFiltro == null && modeloFiltro == null && hybridFiltro == null && classificationFiltro == null) {
							%>
							<li class="page-item"><a class="page-link"
								href="./?action=paginacion&page=<%=siguiente%>">Siguiente</a></li>
							<%
								} else if (annoFiltro != null && modeloFiltro != null && hybridFiltro != null && classificationFiltro != null) {
							%>
							<li class="page-item"><a class="page-link"
								href="./?action=paginacion&year=<%=annoFiltro%>&make=<%=modeloFiltro%>&hybrid=<%=hybridFiltro%>&classification=<%=classificationFiltro%>&page=<%=siguiente%>">Siguiente</a></li>
							<%
								}
							%>
							<li class="page-item"><a class="page-link" href="./">VOLVER
									A VALORES POR DEFECTO</a></li>
						</ul>

					</div>

				</div>

			</div>
		</section>
		

		<jsp:include page="footer.jsp" />

	</main>

	<a href="#" class="back-to-top"><i class="icofont-simple-up"></i></a>

	<%!private static String encodeValue(String value) {
		String url = "";
		try {
			url = URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
		} catch (Exception ex) {

		}
		return url;
	}%>
	<script>
	$(document).ready(function() {
	    $('#booking').DataTable( {
	        "order": [[ 3, "desc" ]]
	    } );
	} );
	</script>
	<script type="text/javascript">
	
		$(document)
				.ready(
						
						function() {
							$("button.reserved").click(function(){
							      $(this).prop("disabled",true);
							});
						
		});
		
		
	</script>
	


	
	<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="assets/vendor/jquery.easing/jquery.easing.min.js"></script>
	<script src="assets/vendor/php-email-form/validate.js"></script>
	<script src="assets/vendor/waypoints/jquery.waypoints.min.js"></script>
	<script src="assets/vendor/counterup/counterup.min.js"></script>
	<script src="assets/vendor/owl.carousel/owl.carousel.min.js"></script>
	<script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
	<script src="assets/vendor/venobox/venobox.min.js"></script>
	<script src="assets/vendor/aos/aos.js"></script>


	<script src="assets/js/main.js"></script>




</body>

</html>