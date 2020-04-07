<%@page import="java.io.UnsupportedEncodingException"%>
<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="com.practicas.model.Identification"%>
<%@page import="com.practicas.model.Car"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.practicas.model.Car"%>
<%@page import="java.util.List"%>

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
			Car car = (Car) request.getAttribute("car");

		String paginaActual = (String) request.getAttribute("page");
		String modeloFiltro = (String) request.getAttribute("make");
		String annoFiltro = (String) request.getAttribute("year");
		String hybridFiltro = (String) request.getAttribute("hybrid");

		List<String> idTabla = (List<String>) request.getAttribute("id");
		List<String> modeloTabla = (List<String>) request.getAttribute("makes");
		List<Integer> anno = (List<Integer>) request.getAttribute("years");
		List<Boolean> hybridTabla = (List<Boolean>) request.getAttribute("hybrids");
		List<Car> cochesTabla = (List<Car>) request.getAttribute("cars");
		%>
	</div>
	<br>
	<h2>Engine Information</h2>
	<form action="./update" method="post">
		<input type="hidden" name="action" value="updateCar" /> <input
			type="hidden" name="pk" value="<%=car.getPk()%>" /> <input
			type="hidden" name="redirect"
			value="<%=encodeValue(request.getAttribute("redirect").toString())%>" />
		<fieldset class="form-row">
			<div class="col-md-4 mb-3">
				<label for="validationServer01">Transmission</label> <input
					type="text" class="form-control is-valid" id="validationServer01"
					placeholder="First name"
					value="<%=car.getEngineinformation().getTransmission()%>" required>
				<div class="valid-feedback">Looks good!</div>
			</div>
			<div class="col-md-4 mb-3">
				<label for="validationServer02">Engine Type</label> <input
					type="text" class="form-control is-valid" id="validationServer02"
					placeholder="Last name"
					value="<%=car.getEngineinformation().getEnginetype()%>" required>
				<div class="valid-feedback">Looks good!</div>
			</div>


			<fieldset class="col-md-4 mb-3">
				<h3>Engine Statistics</h3>
				<div class="col-md-4 mb-3">
					<label for="validationServer03">Horsepower</label> <input
						type="text" class="form-control is-valid" id="validationServer03"
						placeholder="First name"
						value="<%=car.getEngineinformation().getEnginestatistics().getHorsepower()%>"
						required>
					<div class="valid-feedback">Looks good!</div>
				</div>
				<div class="col-md-4 mb-3">
					<label for="validationServer04">Torque</label> <input type="text"
						class="form-control is-valid" id="validationServer04"
						placeholder="Last name"
						value="<%=car.getEngineinformation().getEnginestatistics().getTorque()%>"
						required>
					<div class="valid-feedback">Looks good!</div>
				</div>

			</fieldset>
			<div class="form-group">
				<div class="form-row">
					<label class="mt-2 col-form-label" for="hybrid">Hybrid:</label>
					<div class="form-check ml-1 mt-3">
					<% String hybridSelected = car.getEngineinformation().isHybrid()?" checked=''checked'":""; %>
						<input class="form-check-input valid" type="checkbox"
							name="hybrid" id="hybrid" <%=hybridSelected%>>
					</div>
				</div>
			</div>
			<div class="col-md-4 mb-3">
				<label for="validationServer05">Number of Forward Gears</label> <input
					type="text" class="form-control is-valid" id="validationServer05"
					value="<%=car.getEngineinformation().getNumberofforwardgears()%>"
					required>
				<div class="invalid-feedback">Please provide a valid number.</div>
			</div>
			<div class="form-group">
				<label>Driveline</label> <select class="custom-select"
					id="driveline" required>
					<%
						List<String> drivelines = (List<String>) request.getAttribute("drivelines");
					if (drivelines != null) {
						for (String dr : drivelines) {
					%>
					<option value="<%=dr%>"><%=dr%></option>
					<%
						}
					}
					%>
				</select>
				<div class="invalid-feedback">Example invalid custom select
					feedback</div>
			</div>
		</fieldset>
		<h2>Identification</h2>
		<fieldset class="form-row">
			<div class="col-md-4 mb-3">
				<label for="validationServer07">Make</label> <input type="text"
					class="form-control is-valid" id="validationServer07"
					placeholder="First name"
					value="<%=car.getIdentification().getMake()%>" required>
				<div class="valid-feedback">Looks good!</div>
			</div>
			<div class="col-md-4 mb-3">
				<label for="validationServer08">Model Year</label> <input
					type="text" class="form-control is-valid" id="validationServer08"
					placeholder="Last name"
					value="<%=car.getIdentification().getModelyear()%>" required>
				<div class="valid-feedback">Looks good!</div>
			</div>
			<div class="col-md-4 mb-3">
				<label for="validationServer09">Id</label> <input type="text"
					class="form-control is-valid" id="validationServer09"
					placeholder="Last name"
					value="<%=car.getIdentification().getId()%>" required>
				<div class="valid-feedback">Looks good!</div>
			</div>
			<div class="form-group">
				<label>Classification</label> <select class="custom-select"
					id="classification" required>
					<%
						List<String> classifications = (List<String>) request.getAttribute("classifications");
					if (classifications != null) {
						for (String cl : classifications) {
					%>
					<option value="<%=cl%>"><%=cl%></option>
					<%
						}
					}
					%>
				</select>
				<div class="invalid-feedback">Example invalid custom select
					feedback</div>
			</div>
			<div class="form-group">
				<label>Year</label> <select class="custom-select" id="year" required>
					<%
						List<Integer> years = (List<Integer>) request.getAttribute("years");
					if (years != null) {
						for (Integer ye : years) {
					%>
					<option value="<%=ye%>"><%=ye%></option>
					<%
						}
					}
					%>
				</select>
				<div class="invalid-feedback">Example invalid custom select
					feedback</div>
			</div>
		</fieldset>

		<h2>Dimensions</h2>
		<fieldset class="form-row">
			<div class="col-md-4 mb-3">
				<label for="validationServer12">Width</label> <input type="text"
					class="form-control is-valid" id="validationServer12"
					placeholder="First name"
					value="<%=car.getDimensions().getWidth()%>" required>
				<div class="valid-feedback">Looks good!</div>
			</div>
			<div class="col-md-4 mb-3">
				<label for="validationServer13">Length</label> <input type="text"
					class="form-control is-valid" id="validationServer13"
					placeholder="Last name"
					value="<%=car.getDimensions().getLength()%>" required>
				<div class="valid-feedback">Looks good!</div>
			</div>
			<div class="col-md-4 mb-3">
				<label for="validationServer14">Height</label> <input type="text"
					class="form-control is-valid" id="validationServer14"
					placeholder="Last name"
					value="<%=car.getDimensions().getHeight()%>" required>
				<div class="valid-feedback">Looks good!</div>
			</div>

		</fieldset>

		<h2>Fuel Information</h2>
		<fieldset class="form-row">
			<div class="col-md-4 mb-3">
				<label for="validationServer15">Highway mpg</label> <input
					type="text" class="form-control is-valid" id="validationServer15"
					placeholder="First name"
					value="<%=car.getFuelinformation().getHighwaympg()%>" required>
				<div class="valid-feedback">Looks good!</div>
			</div>
			<div class="col-md-4 mb-3">
				<label for="validationServer16">City mph</label> <input type="text"
					class="form-control is-valid" id="validationServer16"
					placeholder="Last name"
					value="<%=car.getFuelinformation().getCitymph()%>" required>
				<div class="valid-feedback">Looks good!</div>
			</div>
			<div class="form-group">
				<label>Fuel Type</label> <select class="custom-select" id="fuelType"
					required>
					<%
						List<String> fueltypes = (List<String>) request.getAttribute("fueltypes");
					if (fueltypes != null) {
						for (String fu : fueltypes) {
					%>
					<option value="<%=fu%>"><%=fu%></option>
					<%
						}
					}
					%>
				</select>
				<div class="invalid-feedback">Example invalid custom select
					feedback</div>
			</div>

		</fieldset>
		<button class="btn btn-primary btn-lg" type="submit">Actualizar</button>
	</form>

	<%
		String id = (String) request.getAttribute("id");
	String pagei = (String) request.getAttribute("page");
	String filterMake = (String) request.getAttribute("filterMake");
	String filterYear = (String) request.getAttribute("filterYear");
	String filterHybrid = (String) request.getAttribute("filterHybrid");

	String carDriveline = (String) car.getEngineinformation().getDriveline();
	String carClassification = (String) car.getIdentification().getClassification();
	String carYear = String.valueOf(car.getIdentification().getYear());
	String carFuelType = (String) car.getFuelinformation().getFueltype();
	%>

	<button class="btn btn-primary hBack" type="button">REGRESAR A
		LOS COCHES</button>
	<%!public static String encodeValue(String value) {
		String result = "";
		try {
			result = java.net.URLDecoder.decode(value, StandardCharsets.UTF_8.name());
		} catch (UnsupportedEncodingException e) {
			// not going to happen - value came from JDK's own StandardCharsets
		}
		return result;
	}%>
	<script>
		$(".hBack").on("click", function(e) {
			e.preventDefault();
			window.history.back();
		});

	</script>
</body>
</html>