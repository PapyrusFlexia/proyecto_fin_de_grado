<%@page import="java.io.UnsupportedEncodingException"%>
<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.List"%>
<%@page import="com.proyecto.model.Car"%>
<%@page import="com.proyecto.model.Classification"%>
<%@page import="com.proyecto.model.Engine"%>
<%@page import="com.proyecto.model.Fuel"%>
<%@page import="com.proyecto.model.DriveLine"%>
<%@page import="com.proyecto.model.Make"%>
<%@page import="com.proyecto.model.Transmission"%>
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
	<%
		Car car = (Car) request.getAttribute("car");
	Engine engine = (Engine) request.getAttribute("engine");
	%>

	<%
		String executed = (String) request.getAttribute("executed");
	if ("ok".equals(executed)) {
	%>
	<div aria-live="polite" aria-atomic="true"
		style="position: relative; min-height: 200px;">
		<div class="toast" style="position: absolute; top: 0; right: 0;">
			<div class="toast-header">
				<img src="..." class="rounded mr-2" alt="..."> <strong
					class="mr-auto">Bootstrap</strong> <small>11 mins ago</small>
				<button type="button" class="ml-2 mb-1 close" data-dismiss="toast"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="toast-body">Hello, world! This is a toast message.
			</div>
		</div>
	</div>
	<%
		}
	%>
	<br>

	</div>
	<div class="col-md-4 mb-3">
		<label for="validationServer02">Id</label> <input type="text"
			class="form-control is-valid" id="validationServer02"
			placeholder="Last name" name="id" value="<%=car.getId()%>"
			required>
		<div class="valid-feedback">Looks good!</div>
	</div>
	<h2>Engine Information</h2>
	<form action="./insert" method="post" enctype="multipart/form-data">
		<input type="hidden" name="action" value="insertCar" /> <input
			type="hidden" name="pk" value="<%=car.getId()%>" /> <input
			type="hidden" name="redirect"
			value="./<%=encodeValue(request.getAttribute("redirect").toString())%>" />
		<fieldset class="form-row">
			<div class="form-group">
				<label>Transmission</label> <select class="custom-select"
					name="transmission" id="transmission" required>
					<%
						List<Transmission> transmissions = (List<Transmission>) request.getAttribute("transmissions");
					if (transmissions != null) {
						for (Transmission tr : transmissions) {
					%>
					<option value="<%=tr.getId()%>"
						<%if (car.getTransmission().getId() == tr.getId()) {%>
						selected="selected" <%}%>><%=tr.getTransmission()%></option>
					<%
						}
					}
					%>
				</select>
				<div class="invalid-feedback">Example invalid custom select
					feedback</div>
			</div>
			<div class="col-md-4 mb-3">
				<label for="validationServer02">Engine Type</label> <input
					type="text" class="form-control is-valid" id="validationServer02"
					placeholder="Last name" name="enginetype"
					value="<%=car.getEnginetype()%>" required>
				<div class="valid-feedback">Looks good!</div>
			</div>


			<fieldset class="col-md-4 mb-3">
				<h3>Engine Statistics</h3>
				<div class="col-md-4 mb-3">
					<label for="validationServer03">Horsepower</label> <input
						type="text" class="form-control is-valid" placeholder="First name"
						name="horsepower" id="horsepower" value="<%=car.getHorsepower()%>"
						required>
					<div class="valid-feedback">Looks good!</div>
				</div>
				<div class="col-md-4 mb-3">
					<label for="validationServer04">Torque</label> <input type="text"
						class="form-control is-valid" placeholder="Last name"
						name="torque" id="torque" value="<%=car.getTorque()%>" required>
					<div class="valid-feedback">Looks good!</div>
				</div>

			</fieldset>
			<div class="form-group">
				<div class="form-row">
					<label class="mt-2 col-form-label" for="hybrid">Hybrid:</label>
					<div class="form-check ml-1 mt-3">
						<%
							Engine e = new Engine();
						String hybridSelected = e.isHybrid() ? " checked=''checked'" : "";
						%>
						<input class="form-check-input valid" type="checkbox"
							name="hybrid" id="hybrid" <%=hybridSelected%>>
					</div>
				</div>
			</div>
			<div class="col-md-4 mb-3">
				<label for="validationServer05">Number of Forward Gears</label> <input
					type="text" class="form-control is-valid"
					name="numberofforwardgears" id="numberofforwardgears"
					value="<%=car.getNumberofforwardgears()%>" required>
				<div class="invalid-feedback">Please provide a valid number.</div>
			</div>
			<div class="form-group">
				<label>Driveline</label> <select class="custom-select"
					name="driveline" id="driveline" required>
					<%
						List<DriveLine> drivelines = (List<DriveLine>) request.getAttribute("drivelines");
					if (drivelines != null) {
						for (DriveLine dl : drivelines) {
					%>
					<option value="<%=dl.getId()%>"
						<%if (car.getDriveline().getId() == dl.getId()) {%>
						selected="selected" <%}%>><%=dl.getDriveLine()%></option>
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
				<label for="validationServer08">Make</label> <input type="text"
					class="form-control is-valid" placeholder="Last name" name="make"
					id="make" value="<%=car.getMake()%>" required>
				<div class="valid-feedback">Looks good!</div>
			</div>
			<div class="col-md-4 mb-3">
				<label for="validationServer08">Model Year</label> <input
					type="text" class="form-control is-valid" placeholder="Last name"
					name="modelyear" id="modelyear" value="<%=car.getModelyear()%>"
					required>
				<div class="valid-feedback">Looks good!</div>
			</div>
			<div class="col-md-4 mb-3">
				<label for="validationServer09">Name</label> <input type="text"
					class="form-control is-valid" placeholder="Last name" name="name"
					id="name" value="<%=car.getName()%>" required>
				<div class="valid-feedback">Looks good!</div>
			</div>
			<div class="form-group">
				<label>Classification</label> <select class="custom-select"
					name="classification" id="classification" required>
					<%
						List<Classification> classifications = (List<Classification>) request.getAttribute("classifications");
					if (classifications != null) {
						for (Classification cl : classifications) {
					%>
					<option value="<%=cl.getId()%>"
						<%if (car.getClassification().getId() == cl.getId()) {%>
						selected="selected" <%}%>><%=cl.getClassification()%></option>
					<%
						}
					}
					%>
				</select>
				<div class="invalid-feedback">Example invalid custom select
					feedback</div>
			</div>
			<div class="col-md-4 mb-3">
				<label for="validationServer10">Year</label> <input type="text"
					class="form-control is-valid" name="year" id="year"
					placeholder="Year" value="<%=car.getYear()%>" required>
				<div class="valid-feedback">Looks good!</div>
			</div>
		</fieldset>

		<h2>Dimensions</h2>
		<fieldset class="form-row">
			<div class="col-md-4 mb-3">
				<label for="validationServer12">Width</label> <input type="text"
					name="width" id="width" class="form-control is-valid"
					placeholder="First name" value="<%=car.getWidth()%>" required>
				<div class="valid-feedback">Looks good!</div>
			</div>
			<div class="col-md-4 mb-3">
				<label for="validationServer13">Length</label> <input type="text"
					class="form-control is-valid" name="length" id="length"
					placeholder="Last name" value="<%=car.getLength()%>" required>
				<div class="valid-feedback">Looks good!</div>
			</div>
			<div class="col-md-4 mb-3">
				<label for="validationServer14">Height</label> <input type="text"
					class="form-control is-valid" name="height" id="height"
					placeholder="Last name" value="<%=car.getHeight()%>" required>
				<div class="valid-feedback">Looks good!</div>
			</div>

		</fieldset>

		<h2>Fuel Information</h2>
		<fieldset class="form-row">
			<div class="col-md-4 mb-3">
				<label for="validationServer15">Highway mpg</label> <input
					type="text" class="form-control is-valid" name="highwaympg"
					id="highwaympg" placeholder="First name"
					value="<%=car.getHighwaympg()%>" required>
				<div class="valid-feedback">Looks good!</div>
			</div>
			<div class="col-md-4 mb-3">
				<label for="validationServer16">City mph</label> <input type="text"
					class="form-control is-valid" name="citymph" id="citymph"
					placeholder="Last name" value="<%=car.getCitymph()%>" required>
				<div class="valid-feedback">Looks good!</div>
			</div>
			<div class="form-group">
				<label>Fuel Type</label> <select class="custom-select"
					name="fuelType" id="fuelType" required>
					<%
						List<Fuel> fueltypes = (List<Fuel>) request.getAttribute("fueltypes");
					if (fueltypes != null) {
						for (Fuel ft : fueltypes) {
					%>
					<option value="<%=ft.getId()%>"
						<%if (car.getFueltype().getId() == ft.getId()) {%>
						selected="selected" <%}%>><%=ft.getFuelType()%></option>
					<%
						}
					}
					%>
				</select>
				<div class="invalid-feedback">Example invalid custom select
					feedback</div>
			</div>


			<div class="file-loading">
				<input id="input-ke-1" name="image" type="file" multiple
					accept="image" multiple>
			</div>

		</fieldset>
		<button class="btn btn-primary btn-lg" type="submit">Insertar</button>
	</form>

	

	<button class="btn btn-primary hBack"
		onclick="location.href = 'http://localhost:8080/proyecto-web/';">REGRESAR
		A LOS COCHES</button>




	<jsp:include page="footer.jsp" />
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
		$("#input-ke-1")
				.fileinput(
						{
							theme : "explorer",
							uploadUrl : "/file-upload-batch/2",
							allowedFileExtensions : [ 'jpg', 'png', 'gif' ],
							overwriteInitial : false,
							initialPreviewAsData : true,
							maxFileSize : 10000,
							removeFromPreviewOnError : true,
							initialPreview : [
									"https://picsum.photos/1920/1080?image=101",
									"https://picsum.photos/1920/1080?image=102",
									"https://picsum.photos/1920/1080?image=103" ],
							initialPreviewConfig : [ {
								caption : "picture-1.jpg",
								size : 329892,
								width : "120px",
								url : "/site/file-delete",
								key : 101
							}, {
								caption : "picture-2.jpg",
								size : 872378,
								width : "120px",
								url : "/site/file-delete",
								key : 102
							}, {
								caption : "picture-3.jpg",
								size : 632762,
								width : "120px",
								url : "/site/file-delete",
								key : 103
							} ],
							initialPreviewDownloadUrl : 'https://picsum.photos/1920/1080?image={key}'
						});
	</script>
</body>

</html>