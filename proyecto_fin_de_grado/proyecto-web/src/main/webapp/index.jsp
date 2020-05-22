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


	<jsp:include page="head.jsp" />

	<section id="hero">

		<div class="container">
			<div class="row">
				<div class="col-md-3 col-sm-3">
					<div class="form-group">
							<select class="form-control" data-live-search="true"
								title="Filter by year" id="year">
								<option value="-1">FILTRAR POR AÑO</option>
								<%
									for (Integer year : anno) {
								%>
								<option <%if (year.equals(annoFiltro)) {%> selected <%}%>
									value="<%=year%>"><%=year%></option>
								<%
									//ERRORES EN CARDAO, CREAR MYSQL QUERY Y MIRAR UTILSSERVICE
								}
								%>
							</select>
					</div>
				</div>
				<div class="col-md-3 col-sm-3">
					<div class="form-group">
						<select class="form-control" data-live-search="true"
							title="Filter by makes" id="make">
							<option value="-1">FILTRAR POR MARCA</option>
							<%
								if (modeloTabla != null) {
								for (Car model : modeloTabla) {
							%>
							<option <%if (model.getId() == modeloFiltroInt) {%> selected
								<%}%> value="<%=model.getId()%>"><%=model.getMake()%></option>
							<%
								}
							}
							%>
						</select>
					</div>
				</div>

				<div class="col-md-3 col-sm-3">
					<div class="form-group">
						<select class="form-control" data-live-search="true"
							title="Filter by hybrid" id="hybrid">
							<option value="-1">FILTRAR POR HÍBRIDOS</option>
							<%
								for (Boolean hybrid : hybridTabla) {
							%>
							<option <%if (hybrid.equals(hybridFiltro)) {%> selected <%}%>
								value="<%=hybrid%>"><%=hybrid%></option>
							<%
								}
							%>
						</select>
					</div>
				</div>
				<div class="col-md-3 col-sm-3">
					<div class="form-group">
						<select class="form-control" data-live-search="true"
							title="Filter by classification" id="classification">
							<option value="-1">FILTRAR POR CLASIFICACIÓN</option>
							<%
								if (classificationTabla != null) {
								for (Classification classification : classificationTabla) {
							%>
							<option
								<%if (classification.getId() == classificationFiltroInt) {%>
								selected <%}%> value="<%=classification.getId()%>"><%=classification.getClassification()%></option>
							<%
								}
							}
							%>
						</select>

					</div>
				</div>
			</div>
			<div class="row row justify-content-center">
				<div class="col-lg-6 order-1 order-lg-2 hero-img"
					data-aos="fade-left" data-aos-delay="200"></div>


				<table class="table table-bordered table-striped text-center">
					<thead class="thead-light">
						<tr>
							<th scope="col">ID<br> <a><span
									class="glyphicon glyphicon-chevron-up"></span><span
									class="glyphicon glyphicon-chevron-down"></span></a></th>
							<th scope="col">Modelo<br> <a><span
									class="glyphicon glyphicon-chevron-up"></span><span
									class="glyphicon glyphicon-chevron-down"></span></a></th>
							<th scope="col">Marca<br> <a><span
									class="glyphicon glyphicon-chevron-up"></span><span
									class="glyphicon glyphicon-chevron-down"></span></a></th>
							<th scope="col">Año<br> <a><span
									class="glyphicon glyphicon-chevron-up"></span><span
									class="glyphicon glyphicon-chevron-down"></span></a></th>
							<th scope="col">Híbrido<br> <a><span
									class="glyphicon glyphicon-chevron-up"></span><span
									class="glyphicon glyphicon-chevron-down"></span></a></th>
							<th scope="col">Clasificación<br> <a><span
									class="glyphicon glyphicon-chevron-up"></span><span
									class="glyphicon glyphicon-chevron-down"></span></a></th>
							<th scope="col">Acciones</th>

						</tr>
					</thead>
					<tbody>
						<%
							if (cochesTabla != null) {
							for (Car c : cochesTabla) {
								Engine e = new Engine();
						%>
						<tr>
							<th><%=c.getId()%></th>
							<td><%=c.getName()%></td>
							<td><%=c.getMake()%></td>
							<td><%=c.getYear()%></td>
							<td><%=e.isHybrid()%></td>
							<td><%=c.getClassification().getClassification()%></td>
							<td>
								<div class="dropdown">
									<button class="btn btn-primary dropdown-toggle" type="button"
										data-toggle="dropdown">
										Acciones <span class="caret"></span>
									</button>
									<ul class="dropdown-menu">
										<li><a
											href="./?action=detalles&pk=<%=c.getId()%>&redirect=<%=encodeValue(request.getQueryString())%>"><span
												class="glyphicon glyphicon-eye-open d-flex justify-content-center"></span></a></li>
										<li><a href="#"><span
												class="glyphicon glyphicon-trash d-flex justify-content-center"></span></a></li>
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

		<section id="about" class="about">
			<div class="container">

				<div class="section-title" data-aos="fade-up">
					<h2>Sobre Nosotros</h2>
				</div>

				<div class="row content">
					<div class="col-lg-6" data-aos="fade-up" data-aos-delay="150">
						<p>Nuestro objetivos es hacerte la vida más sencilla de forma
							rápida y efectiva</p>
						<ul>
							<li><i class="ri-check-double-line"></i> Organización total</li>
							<li><i class="ri-check-double-line"></i> Manejo de grandes
								cantidades de información</li>
							<li><i class="ri-check-double-line"></i> Servicio y
								asistencia las 24 horas</li>
						</ul>
					</div>
					<div class="col-lg-6 pt-4 pt-lg-0" data-aos="fade-up"
						data-aos-delay="300">
						<p>Disfruta de los servicios del producto Organizatium, donde
							quieras y cuando quieras. ¡Prueba nuestra app!</p>
						<a href="#" class="btn-learn-more">Conocer más</a>
					</div>
				</div>

			</div>
		</section>

		<section id="counts" class="counts">
			<div class="container">

				<div class="row">
					<div
						class="image col-xl-5 d-flex align-items-stretch justify-content-center justify-content-xl-start"
						data-aos="fade-right" data-aos-delay="150">
						<img src="assets/img/counts-img.svg" alt="" class="img-fluid">
					</div>

					<div class="col-xl-7 d-flex align-items-stretch pt-4 pt-xl-0"
						data-aos="fade-left" data-aos-delay="300">
						<div class="content d-flex flex-column justify-content-center">
							<div class="row">
								<div class="col-md-6 d-md-flex align-items-md-stretch">
									<div class="count-box">
										<i class="icofont-simple-smile"></i> <span
											data-toggle="counter-up">65</span>
										<p>
											<strong>Cientes felices</strong> que han probado la
											experiencia Organizatium.
										</p>
									</div>
								</div>

								<div class="col-md-6 d-md-flex align-items-md-stretch">
									<div class="count-box">
										<i class="icofont-document-folder"></i> <span
											data-toggle="counter-up">85</span>
										<p>
											<strong>Projectos</strong> organizados con eficiencia.
										</p>
									</div>
								</div>

								<div class="col-md-6 d-md-flex align-items-md-stretch">
									<div class="count-box">
										<i class="icofont-clock-time"></i> <span
											data-toggle="counter-up">3</span>
										<p>
											<strong>Meses de experiencia</strong> en los que se sigue
											mejorando la experiencia Organizatium continuamente.
										</p>
									</div>
								</div>

								<div class="col-md-6 d-md-flex align-items-md-stretch">
									<div class="count-box">
										<i class="icofont-award"></i> <span data-toggle="counter-up">1</span>
										<p>
											<strong>Aprobado</strong> en la cr
											eación y desarrollo del
											proyecto de aplicaciones web.
										</p>
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>

			</div>
		</section>

		<section id="services" class="services">
			<div class="container">

				<div class="section-title" data-aos="fade-up">
					<h2>Servicios</h2>

				</div>

				<div class="row">
					<div
						class="col-md-6 col-lg-3 d-flex align-items-stretch mb-5 mb-lg-0">
						<div class="icon-box" data-aos="fade-up" data-aos-delay="100">
							<div class="icon">
								<i class="bx bxl-dribbble"></i>
							</div>
							<h4 class="title">
								<a href="">Presencia en el mercado laboral</a>
							</h4>
							<p class="description">Política de aceptación y
								competitividad sana hacia nuestros competidores.</p>
						</div>
					</div>

					<div
						class="col-md-6 col-lg-3 d-flex align-items-stretch mb-5 mb-lg-0">
						<div class="icon-box" data-aos="fade-up" data-aos-delay="200">
							<div class="icon">
								<i class="bx bx-file"></i>
							</div>
							<h4 class="title">
								<a href="">Organización</a>
							</h4>
							<p class="description">Funcionalidades efectivas para un
								control absoluto de tu información.</p>
						</div>
					</div>

					<div
						class="col-md-6 col-lg-3 d-flex align-items-stretch mb-5 mb-lg-0">
						<div class="icon-box" data-aos="fade-up" data-aos-delay="300">
							<div class="icon">
								<i class="bx bx-tachometer"></i>
							</div>
							<h4 class="title">
								<a href="">Optimización</a>
							</h4>
							<p class="description">Tiempo mínimo de espera para tus
								consultas.</p>
						</div>
					</div>

					<div
						class="col-md-6 col-lg-3 d-flex align-items-stretch mb-5 mb-lg-0">
						<div class="icon-box" data-aos="fade-up" data-aos-delay="400">
							<div class="icon">
								<i class="bx bx-world"></i>
							</div>
							<h4 class="title">
								<a href="">Organización en todo el mundo</a>
							</h4>
							<p class="description">Organizatium funciona en todos los
								continenetes del planeta.</p>
						</div>
					</div>

				</div>

			</div>
		</section>



		<section id="portfolio" class="portfolio">
			<div class="container">

				<div class="section-title" data-aos="fade-up">
					<h2>Imágenes</h2>
				</div>

				<div class="row" data-aos="fade-up" data-aos-delay="200">
					<div class="col-lg-12 d-flex justify-content-center">
						<ul id="portfolio-flters">
							<li data-filter="*" class="filter-active">Todas</li>
							<li data-filter=".filter-app">App</li>
							<li data-filter=".filter-card">Cartas</li>
							<li data-filter=".filter-web">Web</li>
						</ul>
					</div>
				</div>

				<div class="row portfolio-container" data-aos="fade-up"
					data-aos-delay="400">

					<div class="col-lg-4 col-md-6 portfolio-item filter-app">
						<div class="portfolio-wrap">
							<img src="assets/img/portfolio/portfolio-1.jpg" class="img-fluid"
								alt="">
							<div class="portfolio-info">
								<h4>App 1</h4>
								<p>App</p>
								<div class="portfolio-links">
									<a href="assets/img/portfolio/portfolio-1.jpg"
										data-gall="portfolioGallery" class="venobox" title="App 1"><i
										class="bx bx-plus"></i></a> <a href="portfolio-details.html"
										title="More Details"><i class="bx bx-link"></i></a>
								</div>
							</div>
						</div>
					</div>

					<div class="col-lg-4 col-md-6 portfolio-item filter-web">
						<div class="portfolio-wrap">
							<img src="assets/img/portfolio/portfolio-2.jpg" class="img-fluid"
								alt="">
							<div class="portfolio-info">
								<h4>Web 3</h4>
								<p>Web</p>
								<div class="portfolio-links">
									<a href="assets/img/portfolio/portfolio-2.jpg"
										data-gall="portfolioGallery" class="venobox" title="Web 3"><i
										class="bx bx-plus"></i></a> <a href="portfolio-details.html"
										title="More Details"><i class="bx bx-link"></i></a>
								</div>
							</div>
						</div>
					</div>

					<div class="col-lg-4 col-md-6 portfolio-item filter-app">
						<div class="portfolio-wrap">
							<img src="assets/img/portfolio/portfolio-3.jpg" class="img-fluid"
								alt="">
							<div class="portfolio-info">
								<h4>App 2</h4>
								<p>App</p>
								<div class="portfolio-links">
									<a href="assets/img/portfolio/portfolio-3.jpg"
										data-gall="portfolioGallery" class="venobox" title="App 2"><i
										class="bx bx-plus"></i></a> <a href="portfolio-details.html"
										title="More Details"><i class="bx bx-link"></i></a>
								</div>
							</div>
						</div>
					</div>

					<div class="col-lg-4 col-md-6 portfolio-item filter-card">
						<div class="portfolio-wrap">
							<img src="assets/img/portfolio/portfolio-4.jpg" class="img-fluid"
								alt="">
							<div class="portfolio-info">
								<h4>Card 2</h4>
								<p>Card</p>
								<div class="portfolio-links">
									<a href="assets/img/portfolio/portfolio-4.jpg"
										data-gall="portfolioGallery" class="venobox" title="Card 2"><i
										class="bx bx-plus"></i></a> <a href="portfolio-details.html"
										title="More Details"><i class="bx bx-link"></i></a>
								</div>
							</div>
						</div>
					</div>

					<div class="col-lg-4 col-md-6 portfolio-item filter-web">
						<div class="portfolio-wrap">
							<img src="assets/img/portfolio/portfolio-5.jpg" class="img-fluid"
								alt="">
							<div class="portfolio-info">
								<h4>Web 2</h4>
								<p>Web</p>
								<div class="portfolio-links">
									<a href="assets/img/portfolio/portfolio-5.jpg"
										data-gall="portfolioGallery" class="venobox" title="Web 2"><i
										class="bx bx-plus"></i></a> <a href="portfolio-details.html"
										title="More Details"><i class="bx bx-link"></i></a>
								</div>
							</div>
						</div>
					</div>

					<div class="col-lg-4 col-md-6 portfolio-item filter-app">
						<div class="portfolio-wrap">
							<img src="assets/img/portfolio/portfolio-6.jpg" class="img-fluid"
								alt="">
							<div class="portfolio-info">
								<h4>App 3</h4>
								<p>App</p>
								<div class="portfolio-links">
									<a href="assets/img/portfolio/portfolio-6.jpg"
										data-gall="portfolioGallery" class="venobox" title="App 3"><i
										class="bx bx-plus"></i></a> <a href="portfolio-details.html"
										title="More Details"><i class="bx bx-link"></i></a>
								</div>
							</div>
						</div>
					</div>

					<div class="col-lg-4 col-md-6 portfolio-item filter-card">
						<div class="portfolio-wrap">
							<img src="assets/img/portfolio/portfolio-7.jpg" class="img-fluid"
								alt="">
							<div class="portfolio-info">
								<h4>Card 1</h4>
								<p>Card</p>
								<div class="portfolio-links">
									<a href="assets/img/portfolio/portfolio-7.jpg"
										data-gall="portfolioGallery" class="venobox" title="Card 1"><i
										class="bx bx-plus"></i></a> <a href="portfolio-details.html"
										title="More Details"><i class="bx bx-link"></i></a>
								</div>
							</div>
						</div>
					</div>

					<div class="col-lg-4 col-md-6 portfolio-item filter-card">
						<div class="portfolio-wrap">
							<img src="assets/img/portfolio/portfolio-8.jpg" class="img-fluid"
								alt="">
							<div class="portfolio-info">
								<h4>Card 3</h4>
								<p>Card</p>
								<div class="portfolio-links">
									<a href="assets/img/portfolio/portfolio-8.jpg"
										data-gall="portfolioGallery" class="venobox" title="Card 3"><i
										class="bx bx-plus"></i></a> <a href="portfolio-details.html"
										title="More Details"><i class="bx bx-link"></i></a>
								</div>
							</div>
						</div>
					</div>

					<div class="col-lg-4 col-md-6 portfolio-item filter-web">
						<div class="portfolio-wrap">
							<img src="assets/img/portfolio/portfolio-9.jpg" class="img-fluid"
								alt="">
							<div class="portfolio-info">
								<h4>Web 3</h4>
								<p>Web</p>
								<div class="portfolio-links">
									<a href="assets/img/portfolio/portfolio-9.jpg"
										data-gall="portfolioGallery" class="venobox" title="Web 3"><i
										class="bx bx-plus"></i></a> <a href="portfolio-details.html"
										title="More Details"><i class="bx bx-link"></i></a>
								</div>
							</div>
						</div>
					</div>

				</div>

			</div>
		</section>
		<section id="team" class="team section-bg">
			<div class="container">

				<div class="section-title" data-aos="fade-up">
					<h2>Equipo</h2>
				</div>

				<div class="row">

					<div class="col-lg-3 col-md-6 d-flex align-items-stretch">
						<div class="member" data-aos="fade-up" data-aos-delay="100">
							<div class="member-img">
								<img src="assets/img/team/team-1.png" class="img-fluid" alt="">
								<div class="social">
									<a href=""><i class="icofont-twitter"></i></a> <a href=""><i
										class="icofont-facebook"></i></a> <a href=""><i
										class="icofont-instagram"></i></a> <a href=""><i
										class="icofont-linkedin"></i></a>
								</div>
							</div>
							<div class="member-info">
								<h4>Pablo Vega</h4>
								<span>Director ejecutivo</span>
							</div>
						</div>
					</div>

					<div class="col-lg-3 col-md-6 d-flex align-items-stretch">
						<div class="member" data-aos="fade-up" data-aos-delay="200">
							<div class="member-img">
								<img src="assets/img/team/team-2.jpg" class="img-fluid" alt="">
								<div class="social">
									<a href=""><i class="icofont-twitter"></i></a> <a href=""><i
										class="icofont-facebook"></i></a> <a href=""><i
										class="icofont-instagram"></i></a> <a href=""><i
										class="icofont-linkedin"></i></a>
								</div>
							</div>
							<div class="member-info">
								<h4>Sarah Jhonson</h4>
								<span>Comercial</span>
							</div>
						</div>
					</div>

					<div class="col-lg-3 col-md-6 d-flex align-items-stretch">
						<div class="member" data-aos="fade-up" data-aos-delay="300">
							<div class="member-img">
								<img src="assets/img/team/team-3.jpg" class="img-fluid" alt="">
								<div class="social">
									<a href=""><i class="icofont-twitter"></i></a> <a href=""><i
										class="icofont-facebook"></i></a> <a href=""><i
										class="icofont-instagram"></i></a> <a href=""><i
										class="icofont-linkedin"></i></a>
								</div>
							</div>
							<div class="member-info">
								<h4>William Anderson</h4>
								<span>Administrador</span>
							</div>
						</div>
					</div>

					<div class="col-lg-3 col-md-6 d-flex align-items-stretch">
						<div class="member" data-aos="fade-up" data-aos-delay="400">
							<div class="member-img">
								<img src="assets/img/team/team-4.jpg" class="img-fluid" alt="">
								<div class="social">
									<a href=""><i class="icofont-twitter"></i></a> <a href=""><i
										class="icofont-facebook"></i></a> <a href=""><i
										class="icofont-instagram"></i></a> <a href=""><i
										class="icofont-linkedin"></i></a>
								</div>
							</div>
							<div class="member-info">
								<h4>Amanda Jepson</h4>
								<span>Asistencia al cliente</span>
							</div>
						</div>
					</div>

				</div>

			</div>
		</section>

		<section id="pricing" class="pricing">
			<div class="container">

				<div class="section-title">
					<h2>Precio</h2>
				</div>

				<div class="row">

					<div class="col-lg-4 col-md-6">
						<div class="box" data-aos="zoom-in-right" data-aos-delay="200">
							<h3>Gratis</h3>
							<h4>
								<sup>$</sup>0
							</h4>
							<ul>
								<li>15 días de prueba</li>
								<li>Organización básica</li>
								<li>Creación de cuenta</li>
								<li class="na">Control de usuarios</li>
								<li class="na">Organización total</li>
							</ul>
							<div class="btn-wrap">
								<a href="#" class="btn-buy">Comprar ahora</a>
							</div>
						</div>
					</div>

					<div class="col-lg-4 col-md-6 mt-4 mt-md-0">
						<div class="box recommended" data-aos="zoom-in"
							data-aos-delay="100">
							<h3>Educación</h3>
							<h4>
								<sup>$</sup>27,18
							</h4>
							<ul>
								<li>Licencia de por vida</li>
								<li>Organización básica</li>
								<li>Creación de cuenta</li>
								<li class="na">Control de usuarios</li>
								<li>Organización total</li>
							</ul>
							<div class="btn-wrap">
								<a href="#" class="btn-buy">Comprar ahora</a>
							</div>
						</div>
					</div>

					<div class="col-lg-4 col-md-6 mt-4 mt-lg-0">
						<div class="box" data-aos="zoom-in-left" data-aos-delay="200">
							<h3>Empresa</h3>
							<h4>
								<sup>$</sup>36,24
							</h4>
							<ul>
								<li>Licencia de por vida</li>
								<li>Organización básica</li>
								<li>Creación de cuenta</li>
								<li>Control de usuarios</li>
								<li>Organización total</li>
							</ul>
							<div class="btn-wrap">
								<a href="#" class="btn-buy">Comprar ahora</a>
							</div>
						</div>
					</div>

				</div>

			</div>
		</section>

		<section id="contact" class="contact">
			<div class="container">

				<div class="section-title" data-aos="fade-up">
					<h2>Contáctanos</h2>
				</div>

				<div class="row">

					<div class="col-lg-4 col-md-6" data-aos="fade-up"
						data-aos-delay="100">
						<div class="contact-about">
							<h3>Organizatium</h3>
							<div class="social-links">
								<a href="#" class="twitter"><i class="icofont-twitter"></i></a>
								<a href="#" class="facebook"><i class="icofont-facebook"></i></a>
								<a href="#" class="instagram"><i class="icofont-instagram"></i></a>
								<a href="#" class="linkedin"><i class="icofont-linkedin"></i></a>
							</div>
						</div>
					</div>

					<div class="col-lg-3 col-md-6 mt-4 mt-md-0" data-aos="fade-up"
						data-aos-delay="200">
						<div class="info">
							<div>
								<i class="ri-map-pin-line"></i>
								<p>C/ Luis Fuentes Bejarano nº37</p>
							</div>

							<div>
								<i class="ri-mail-send-line"></i>
								<p>pablo.vega@adaits.es</p>
							</div>

							<div>
								<i class="ri-phone-line"></i>
								<p>601 027 982</p>
							</div>

						</div>
					</div>

					<div class="col-lg-5 col-md-12" data-aos="fade-up"
						data-aos-delay="300">
						<form action="forms/contact.php" method="post" role="form"
							class="php-email-form">
							<div class="form-group">
								<input type="text" name="name" class="form-control" id="name"
									placeholder="Nombre" data-rule="minlen:4"
									data-msg="Mínimo 4 carácteres" />
								<div class="validate"></div>
							</div>
							<div class="form-group">
								<input type="email" class="form-control" name="email" id="email"
									placeholder="Email" data-rule="email"
									data-msg="Inserta un email válido" />
								<div class="validate"></div>
							</div>
							<div class="form-group">
								<input type="text" class="form-control" name="subject"
									id="subject" placeholder="Tema" data-rule="minlen:4"
									data-msg="Mínimo 8 carácteres" />
								<div class="validate"></div>
							</div>
							<div class="form-group">
								<textarea class="form-control" name="message" rows="5"
									data-rule="required" data-msg="Escríbenos"
									placeholder="Mensaje"></textarea>
								<div class="validate"></div>
							</div>
							<div class="mb-3">
								<div class="loading">Cargando</div>
								<div class="error-message"></div>
								<div class="sent-message">Tu mensaje a sido enviado
									¡Gracias!</div>
							</div>
							<div class="text-center">
								<button type="submit">Enviar mensaje</button>
							</div>
						</form>
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
														+ '&hybrid='
														+ $('#hybridFilterValue')
														.val()
														+ '&classification='
														+ $('#classificationFilterValue')
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
														+ '&hybrid='
														+ $('#hybridFilterValue')
														.val()
														+ '&classification='
														+ $('#classificationFilterValue')
														.val()
														+ '&page=0';
											});
							$('#hybrid')
							.change(
									function() {
										var valor = $(this).children(
												"option:selected")
												.val();
										location.href = './?action=paginacion&year='
												+ $('#yearFilterValue')
														.val()
												+ '&make='
												+ $('#makeFilterValue')
														.val()
												+ '&hybrid='
												+ valor
												+ '&classification='
												+ $('#classificationFilterValue')
												.val()
												+ '&page=0';
									});
							
							$('#classification')
							.change(
									function() {
										var valor = $(this).children(
												"option:selected")
												.val();
										location.href = './?action=paginacion&year='
												+ $('#yearFilterValue')
														.val()
												+ '&make='
												+ $('#makeFilterValue')
														.val()
												+ '&hybrid='
														+ $('#hybridFilterValue')
														.val()
												+ '&classification='
												+ valor
												+ '&page=0';
									});
							
							<%if (anno != null) {%>
							$("#year option[value=<%=anno%>]").attr('selected', 'selected');<%}%>
							<%if (modeloTabla != null) {%>
							$("#make option[value=<%=modeloTabla%>']").attr('selected','selected');<%}%>
							<%if (hybridTabla != null) {%>
							$("#hybrid option[value=<%=hybridTabla%>]").attr('selected','selected');<%}%>
							<%if (classificationTabla != null) {%>
							$("#classification option[value=<%=classificationTabla%>']").attr('selected', 'selected');
	<%}%>
		});
	</script>


	<script src="assets/vendor/jquery/jquery.min.js"></script>
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