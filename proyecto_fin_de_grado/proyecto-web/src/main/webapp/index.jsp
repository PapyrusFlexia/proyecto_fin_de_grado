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
<style>
th {
	cursor: pointer;
}
</style>
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
<style>
#busqueda {
  background-position: 10px 12px; /* Position the search icon */
  background-repeat: no-repeat; /* Do not repeat the icon image */
  width: 100%; /* Full-width */
  font-size: 18px; /* Increase font-size */
  padding: 12px 20px 12px 40px; /* Add some padding */
  border: 1px solid #ddd; /* Add a grey border */
  margin-bottom: 12px; /* Add some space below the input */
}

#myTable {
  border-collapse: collapse; /* Collapse borders */
  width: 100%; /* Full-width */
  border: 1px solid #ddd; /* Add a grey border */
  font-size: 16px; /* Increase font-size */
}

#myTable th, #myTable td {
  padding: 13px; /* Add padding */
}

#myTable tr {
  /* Add a bottom border to all table rows */
  border-bottom: 1px solid #ddd;
}

.lds-roller {
    display: inline-block;
    position: relative;
    width: 64px;
    height: 64px;
}
.lds-roller div {
    animation: lds-roller 1.2s cubic-bezier(0.5, 0, 0.5, 1) infinite;
    transform-origin: 32px 32px;
}
.lds-roller div:after {
    content: " ";
    display: block;
    position: absolute;
    width: 6px;
    height: 6px;
    border-radius: 50%;
    background: #333;
    margin: -3px 0 0 -3px;
}
.lds-roller div:nth-child(1) {
    animation-delay: -0.036s;
}
.lds-roller div:nth-child(1):after {
    top: 50px;
    left: 50px;
}
.lds-roller div:nth-child(2) {
    animation-delay: -0.072s;
}
.lds-roller div:nth-child(2):after {
    top: 54px;
    left: 45px;
}
.lds-roller div:nth-child(3) {
    animation-delay: -0.108s;
}
.lds-roller div:nth-child(3):after {
    top: 57px;
    left: 39px;
}
.lds-roller div:nth-child(4) {
    animation-delay: -0.144s;
}
.lds-roller div:nth-child(4):after {
    top: 58px;
    left: 32px;
}
.lds-roller div:nth-child(5) {
    animation-delay: -0.18s;
}
.lds-roller div:nth-child(5):after {
    top: 57px;
    left: 25px;
}
.lds-roller div:nth-child(6) {
    animation-delay: -0.216s;
}
.lds-roller div:nth-child(6):after {
    top: 54px;
    left: 19px;
}
.lds-roller div:nth-child(7) {
    animation-delay: -0.252s;
}
.lds-roller div:nth-child(7):after {
    top: 50px;
    left: 14px;
}
.lds-roller div:nth-child(8) {
    animation-delay: -0.288s;
}
.lds-roller div:nth-child(8):after {
    top: 45px;
    left: 10px;
}
@keyframes lds-roller {
    0% {
        transform: rotate(0deg);
    }
    100% {
        transform: rotate(360deg);
    }
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
	String modeloFiltro = (String) request.getAttribute("make");
	int modeloFiltroInt = 0;
	if (modeloFiltro != null && !modeloFiltro.equals("") && !modeloFiltro.equals("null")) {
		try {

			modeloFiltroInt = Integer.valueOf(modeloFiltro);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	String annoFiltro = (String) request.getAttribute("year");
	int annoFiltroInt = 0;
	if (annoFiltro != null && !annoFiltro.equals("") && !annoFiltro.equals("null")) {
		try {

			annoFiltroInt = Integer.valueOf(annoFiltro);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	String hybridFiltro = (String) request.getAttribute("hybrid");
	boolean hybridFiltroInt;
	if (hybridFiltro != null && !hybridFiltro.equals("") && !hybridFiltro.equals("null")) {
		try {
			hybridFiltroInt = Boolean.valueOf(hybridFiltro);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	String classificationFiltro = (String) request.getAttribute("classification");
	int classificationFiltroInt = 0;
	if (classificationFiltro != null && !classificationFiltro.equals("") && !classificationFiltro.equals("null")) {
		try {
			classificationFiltroInt = Integer.valueOf(classificationFiltro);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	int paginaComienzo = Integer.valueOf(paginaActual);
	if (paginaComienzo > 1) {
		anterior = paginaComienzo - 1;
	}
	siguiente = paginaComienzo + 1;

	List<String> idTabla = (List<String>) request.getAttribute("id");
	List<String> modeloTabla = (List<String>) request.getAttribute("makes");
	List<Boolean> hybridTabla = (List<Boolean>) request.getAttribute("hybrids");
	List<Classification> classificationTabla = (List<Classification>) request.getAttribute("classifications");
	List<Integer> anno = (List<Integer>) request.getAttribute("years");
	List<Car> cochesTabla = (List<Car>) request.getAttribute("cars");
	%>


	<jsp:include page="head.jsp" />
	<br><br>
	<section class="mt-4">
	
		<div class="container">
			<div class="row">
				<div class="col-md-3 col-sm-3 ml-5">
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
								}
							%>
						</select>
					</div>
				</div>
				<div class="col-md-3 col-sm-3 ml-5">
					<div class="form-group">
						<select class="form-control" data-live-search="true"
							title="Filter by makes" id="make">
							<option value="-1">FILTRAR POR MARCA</option>
							<%
								for (String model : modeloTabla) {
							%>
							<option <%if (model.equals(modeloFiltro)) {%> selected <%}%>
								value="<%=model%>"><%=model%></option>
							<%
								}
							%>
						</select>
					</div>
				</div>

				<div class="col-md-3 col-sm-3 ml-5">
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
			</div>
			<div class="row row justify-content-center">
				<div class="col-lg-6 order-1 order-lg-2 hero-img"
					data-aos="fade-left" data-aos-delay="200"></div>

<input type="text" id="busqueda" onkeyup="buscar()" placeholder="Buscar por modelo...">
				<table class="table table-bordered table-striped text-center"
					id="myTable">
					<thead class="thead-light">
						<tr>
							<th scope="col"><p class="text-center">ID</p></th>
							<th scope="col" onclick="sortModel(0)"><p
									class="text-center">Modelo</p><span style="float:center;"><i class="icofont-expand-alt"></i></span>
								</th>
							<th scope="col" onclick="sortMake(0)"><p
									class="text-center">Marca</p><span style="float:center;"><i class="icofont-expand-alt"></i></span>
								</th>
							<th scope="col" onclick="sortYear(0)"><p
									class="text-center">Modelo</p><span style="float:center;"><i class="icofont-expand-alt"></i></span>
								</th>
							<th scope="col"><p class="text-center">Híbrido</p></th>
							<th scope="col"><p class="text-center">Clasificación</p></th>
							<th scope="col"><p class="text-center">Acciones</p></th>

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
							<td><%=c.isHybrid()%></td>
							<td><%=c.getClassification().getClassification()%></td>
							<td><a
								href="./?action=detalles&pk=<%=c.getId()%>&redirect=<%=encodeValue(request.getQueryString())%>">Detalles
									|</a> <a href="http://localhost:8080/proyecto-web/insert">Insertar</a>
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
		<div class="container">

				<div class="row">

					<div class="row ml-2 mb-2 d-flex justify-content-between">
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
								} else if (annoFiltro != null && modeloFiltro != null && hybridFiltro != null && classificationFiltro != null) {
							%>
							<li class="page-item"><a class="page-link"
								href="./?action=paginacion&year=<%=annoFiltro%>&make=<%=modeloFiltro%>&hybrid=<%=hybridFiltro%>&classification=<%=classificationFiltro%>&page=<%=anterior%>"><%=anterior%></a></li>
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
								} else if (annoFiltro != null || modeloFiltro != null || hybridFiltro != null || classificationFiltro != null) {
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

	<main id="main">

	
			
		
		<section id="about" class="about">

				<div class="section-title" data-aos="fade-up">
					<h2>Poblar tablas</h2>
				</div>

					<div class="container-fluid d-flex align-items-center ">
						<div style="float: none; margin: 0 auto;">
		<nav class="nav-menu d-none d-lg-block align-items-center">
			<ul>
	
				<li class="get-started"><a onclick="spinCar()">Coches</a>
				<div class="loader text-center" id="populateSpinCar" style="display: none">
   						 <div class="loader-inner">
       						 <div class="lds-roller mb-3">
           						 <div></div>
           						 <div></div>
            					 <div></div>
           						 <div></div>
           						 <div></div>
            					 <div></div>
           						 <div></div>
           						 <div></div>
      						  </div>
        

        					<h4 class="text-uppercase font-weight-bold">Cargando</h4>
        					<p class="font-italic text-muted">Poblando, esta acción puede tardar unos minutos.</p>
    					</div>
					</div>
					</li>
					
				<li class="get-started"><a onclick="spinEngine()">Motores</a>
				<div class="loader text-center" id="populateSpinEngine" style="display: none">
   						 <div class="loader-inner">
       						 <div class="lds-roller mb-3">
           						 <div></div>
           						 <div></div>
            					 <div></div>
           						 <div></div>
           						 <div></div>
            					 <div></div>
           						 <div></div>
           						 <div></div>
      						  </div>
        

        					<h4 class="text-uppercase font-weight-bold">Cargando</h4>
        					<p class="font-italic text-muted">Poblando, esta acción puede tardar unos minutos.</p>
    					</div>
					</div>
				</li>

				<li class="get-started"><a onclick="spinFuel()">Combustibles</a>
					<div class="loader text-center" id="populateSpinFuel" style="display: none">
   						 <div class="loader-inner">
       						 <div class="lds-roller mb-3">
           						 <div></div>
           						 <div></div>
            					 <div></div>
           						 <div></div>
           						 <div></div>
            					 <div></div>
           						 <div></div>
           						 <div></div>
      						  </div>
        

        					<h4 class="text-uppercase font-weight-bold">Cargando</h4>
        					<p class="font-italic text-muted">Poblando, esta acción puede tardar unos minutos.</p>
    					</div>
					</div>
				</li>
					
				<li class="get-started"><a onclick="spinDriveline()">Líneas de transmisión</a>
				<div class="loader text-center" id="populateSpinDriveline" style="display: none">
   						 <div class="loader-inner">
       						 <div class="lds-roller mb-3">
           						 <div></div>
           						 <div></div>
            					 <div></div>
           						 <div></div>
           						 <div></div>
            					 <div></div>
           						 <div></div>
           						 <div></div>
      						  </div>
        

        					<h4 class="text-uppercase font-weight-bold">Cargando</h4>
        					<p class="font-italic text-muted">Poblando, esta acción puede tardar unos minutos.</p>
    					</div>
					</div>
				</li>
					
				<li class="get-started"><a onclick="spinTransmission()">Transmisiones</a>
				<div class="loader text-center" id="populateSpinTransmission" style="display: none">
   						 <div class="loader-inner">
       						 <div class="lds-roller mb-3">
           						 <div></div>
           						 <div></div>
            					 <div></div>
           						 <div></div>
           						 <div></div>
            					 <div></div>
           						 <div></div>
           						 <div></div>
      						  </div>
        

        					<h4 class="text-uppercase font-weight-bold">Cargando</h4>
        					<p class="font-italic text-muted">Poblando, esta acción puede tardar unos minutos.</p>
    					</div>
					</div>
				</li>
					
				<li class="get-started"><a onclick="spinClassification()">Clasificaciones</a>
				<div class="loader text-center" id="populateSpinClassification" style="display: none">
   						 <div class="loader-inner">
       						 <div class="lds-roller mb-3">
           						 <div></div>
           						 <div></div>
            					 <div></div>
           						 <div></div>
           						 <div></div>
            					 <div></div>
           						 <div></div>
           						 <div></div>
      						  </div>
        

        					<h4 class="text-uppercase font-weight-bold">Cargando</h4>
        					<p class="font-italic text-muted">Poblando, esta acción puede tardar unos minutos.</p>
    					</div>
					</div>
				</li>
			</ul>
		</nav>
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
											<strong>Clientes felices</strong> que han probado la
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
											<strong>Aprobado</strong> en la creación y desarrollo del
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
							<h3>Gratuito</h3>
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
							<h3>Educativo</h3>
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
							<h3>Empresarial</h3>
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

	<script>
		function sortYear(n) {
			var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
			table = document.getElementById("myTable");
			switching = true;
			dir = "asc";

			while (switching) {
				switching = false;
				rows = table.rows;
				for (i = 1; i < (rows.length - 1); i++) {
					shouldSwitch = false;
					x = rows[i].getElementsByTagName("TD")[n];
					y = rows[i + 1].getElementsByTagName("TD")[n];
					if (dir == "asc") {
						if (x.innerHTML.toLowerCase() > y.innerHTML
								.toLowerCase()) {
							shouldSwitch = true;
							break;
						}
					} else if (dir == "desc") {
						if (x.innerHTML.toLowerCase() < y.innerHTML
								.toLowerCase()) {
							shouldSwitch = true;
							break;
						}
					}
				}
				if (shouldSwitch) {
					rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
					switching = true;

					switchcount++;
				} else {

					if (switchcount == 0 && dir == "asc") {
						dir = "desc";
						switching = true;
					}
				}
			}
		}

		function sortModel(n) {
			var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
			table = document.getElementById("myTable");
			switching = true;
			dir = "asc";

			while (switching) {
				switching = false;
				rows = table.rows;
				for (i = 1; i < (rows.length - 1); i++) {
					shouldSwitch = false;
					x = rows[i].getElementsByTagName("TD")[n];
					y = rows[i + 1].getElementsByTagName("TD")[n];
					if (dir == "asc") {
						if (x.innerHTML.toLowerCase() > y.innerHTML
								.toLowerCase()) {
							shouldSwitch = true;
							break;
						}
					} else if (dir == "desc") {
						if (x.innerHTML.toLowerCase() < y.innerHTML
								.toLowerCase()) {
							shouldSwitch = true;
							break;
						}
					}
				}
				if (shouldSwitch) {
					rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
					switching = true;

					switchcount++;
				} else {

					if (switchcount == 0 && dir == "asc") {
						dir = "desc";
						switching = true;
					}
				}
			}
		}

		function sortMake(n) {
			var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
			table = document.getElementById("myTable");
			switching = true;
			dir = "asc";

			while (switching) {
				switching = false;
				rows = table.rows;
				for (i = 1; i < (rows.length - 1); i++) {
					shouldSwitch = false;
					x = rows[i].getElementsByTagName("TD")[n];
					y = rows[i + 1].getElementsByTagName("TD")[n];
					if (dir == "asc") {
						if (x.innerHTML.toLowerCase() > y.innerHTML
								.toLowerCase()) {
							shouldSwitch = true;
							break;
						}
					} else if (dir == "desc") {
						if (x.innerHTML.toLowerCase() < y.innerHTML
								.toLowerCase()) {
							shouldSwitch = true;
							break;
						}
					}
				}
				if (shouldSwitch) {
					rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
					switching = true;

					switchcount++;
				} else {

					if (switchcount == 0 && dir == "asc") {
						dir = "desc";
						switching = true;
					}
				}
			}
		}
		
		function buscar() {
		  // Declare variables
		  var input, filter, table, tr, td, i, txtValue;
		  input = document.getElementById("busqueda");
		  filter = input.value.toUpperCase();
		  table = document.getElementById("myTable");
		  tr = table.getElementsByTagName("tr");

		  // Loop through all table rows, and hide those who don't match the search query
		  for (i = 0; i < tr.length; i++) {
		    td = tr[i].getElementsByTagName("td")[1];
		    if (td) {
		      txtValue = td.textContent || td.innerText;
		      if (txtValue.toUpperCase().indexOf(filter) > -1) {
		        tr[i].style.display = "";
		      } else {
		        tr[i].style.display = "none";
		      }
		    }
		  }
		}
		
		 function spinCar() {
	    	  var x = document.getElementById("populateSpinCar");
	    	  if (x.style.display === "none") {
	    	    x.style.display = "block";
	    	    location.href = 'http://localhost:8080/proyecto-web/populate?model=car';
	    	  }
	    	}
		 
		 function spinEngine() {
	    	  var x = document.getElementById("populateSpinEngine");
	    	  if (x.style.display === "none") {
	    	    x.style.display = "block";
	    	    location.href = 'http://localhost:8080/proyecto-web/populate?model=engine';
	    	  }
	    	}
		
		 function spinFuel() {
	    	  var x = document.getElementById("populateSpinFuel");
	    	  if (x.style.display === "none") {
	    	    x.style.display = "block";
	    	    location.href = 'http://localhost:8080/proyecto-web/populate?model=fuel';
	    	  }
	    	}
		 
		 function spinDriveline() {
	    	  var x = document.getElementById("populateSpinDriveline");
	    	  if (x.style.display === "none") {
	    	    x.style.display = "block";
	    	    location.href = 'http://localhost:8080/proyecto-web/populate?model=drive';
	    	  }
	    	}
		 
		 function spinTransmission() {
	    	  var x = document.getElementById("populateSpinTransmission");
	    	  if (x.style.display === "none") {
	    	    x.style.display = "block";
	    	    location.href = 'http://localhost:8080/proyecto-web/populate?model=transmission';
	    	  }
	    	}
		 
		 function spinClassification() {
	    	  var x = document.getElementById("populateSpinClassification");
	    	  if (x.style.display === "none") {
	    	    x.style.display = "block";
	    	    location.href = 'http://localhost:8080/proyecto-web/populate?model=classification';
	    	  }
	    	}
		
		// Spinner
	    $(window).on('load', function () {
	        var loadingCounter = setInterval(function () {
	            var count = parseInt($('.countdown').html());
	            if (count !== 0) {
	                $('.countdown').html(count - 1);
	            } else {
	                clearInterval();
	            }
	        }, 1000);
	    });
	    $('#reload').on('click', function (e) {
	        e.preventDefault();
	        location.reload();
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