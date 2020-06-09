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
<%@page import="com.proyecto.model.CarImage"%>
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
<script src="https://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>
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

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" crossorigin="anonymous">
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-fileinput/5.0.9/css/fileinput.min.css" media="all" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" crossorigin="anonymous">
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-fileinput/5.0.9/js/plugins/piexif.min.js" type="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-fileinput/5.0.9/js/plugins/sortable.min.js" type="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-fileinput/5.0.9/js/plugins/purify.min.js" type="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-fileinput/5.0.9/js/fileinput.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-fileinput/5.0.9/themes/fas/theme.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-fileinput/5.0.9/js/locales/es.js"></script>
<link href="assets/css/style.css" rel="stylesheet">

<style>
form[action*="./delete"] {
    display: inline;
}
form[action*="./update"] {
    display: inline;
}

.loader {
    width: 100vw;
    height: 100vh;
    background: #fff;
    position: fixed;
    top: 0;
    left: 0;
}

.loader-inner {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
}


/* Spinner */
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
			CarImage carImage = (CarImage) request.getAttribute("carImage");
		
		%>
	
	<%
	String executed = (String)request.getAttribute("executed");
	if("ok".equals(executed)){%>
<div aria-live="polite" aria-atomic="true" class="d-flex justify-content-center align-items-center" style="min-height: 200px;">	



<div class="toast" role="alert" aria-live="assertive" aria-atomic="true" data-delay="10000">
  <div class="toast-header">
    <strong class="mr-auto">¡ACTUALIZADO!</strong>
    <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
      <span aria-hidden="true">&times;</span>
    </button>
  </div>
  <div class="toast-body">
   El coche se ha actualizado correctamente
  </div>
</div>
</div>
<%}%>
	<br>
	<h2>Engine Information</h2>
	<form action="./update" method="post" enctype="multipart/form-data">
		<input type="hidden" name="action" value="updateCar" /> <input type="hidden" name="pk" value="<%=car.getId()%>" /> <input type="hidden" name="redirect" value="./<%=encodeValue(request.getAttribute("redirect").toString()) %>" />
		<fieldset class="form-row m-5 pb-5 ">
			<div class="form-group w-50">
				<label>Transmission</label> <select class="custom-select"
					name="transmission" id="transmission" required>
					<%
						List<Transmission> transmissions = (List<Transmission>) request.getAttribute("transmissions");
					if (transmissions != null) {
						for(Transmission tr: transmissions){
						
					%>
					<option value="<%=tr.getId()%>" <%if(car.getTransmission().getId() == tr.getId()){ %> selected="selected"  <%}%>><%=tr.getTransmission()%></option>
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
						type="text" class="form-control is-valid"
						placeholder="First name"
						name="horsepower" id="horsepower" id="horsepower"  pattern="[0-9]{1,19}" title="Solo acepta números, 1 valor mínimo" value="<%=car.getHorsepower()%>"
						required>
					<div class="valid-feedback">Looks good!</div>
				</div>
				<div class="col-md-4 mb-3">
					<label for="validationServer04">Torque</label> <input type="text"
						class="form-control is-valid" 
						placeholder="Last name"
						name="torque" id="torque" pattern="[0-9]{1,19}" title="Solo acepta números, 1 valor mínimo" value="<%=car.getTorque()%>"
						required>
					<div class="valid-feedback">Looks good!</div>
				</div>

			</fieldset>
			<div class="form-group">
				<div class="form-row">
					<label class="mt-2 col-form-label" for="hybrid">Hybrid:</label>
					<div class="form-check ml-1 mt-3">
					<% 
					Car c = new Car();
					String hybridSelected = c.isHybrid()?" checked=''checked'":""; %>
						<input class="form-check-input valid" type="checkbox"
							name="hybrid" id="hybrid" <%=hybridSelected%>>
					</div>
				</div>
			</div>
			<div class="col-md-4 mb-3">
				<label for="validationServer05">Number of Forward Gears</label> <input
					type="text" class="form-control is-valid"
					name="numberofforwardgears" id="numberofforwardgears" pattern="[0-9]{0,19}" title="Solo acepta números" value="<%=car.getNumberofforwardgears()%>"
					required>
				<div class="invalid-feedback">Please provide a valid number.</div>
			</div>
			<div class="form-group w-50">
				<label>Driveline</label> <select class="custom-select"
					name="driveline" id="driveline" required>
					<%
						List<DriveLine> drivelines = (List<DriveLine>) request.getAttribute("drivelines");
					if (drivelines != null) {
						for(DriveLine dl: drivelines){
						
					%>
					<option value="<%=dl.getId()%>" <%if(car.getDriveline().getId() == dl.getId()){ %> selected="selected"  <%}%>><%=dl.getDriveLine()%></option>
					<%
						}
					}
					%>
				</select>
				<div class="invalid-feedback">Example invalid custom select
					feedback</div>
			</div>
		</fieldset>
		<h2 class="m-5 pb-5">Identification</h2>
		<fieldset class="form-row m-5 pb-5">
			<div class="col-md-4 mb-3">
				<label for="validationServer08">Make</label> <input
					type="text" class="form-control is-valid" 
					placeholder="Last name"
					name="make" id="make" pattern="^[A-Z][A-Za-z]{2,19}$" title="La marca solo acepta letras y la primera en mayúsculas" value="<%=car.getMake()%>" required>
				<div class="valid-feedback">Looks good!</div>
			</div>
			<div class="col-md-4 mb-3">
				<label for="validationServer08">Model Year</label> <input
					type="text" class="form-control is-valid" 
					placeholder="Last name"
					name="modelyear" id="modelyear" value="<%=car.getModelyear()%>" required>
				<div class="valid-feedback">Looks good!</div>
			</div>
			<div class="col-md-4 mb-3">
				<label for="validationServer09">Name</label> <input type="text"
					class="form-control is-valid"
					placeholder="Last name"
					name="name" id="name" data-toggle="tooltip" data-placement="right" title="El nombre debe ser único" value="<%=car.getName()%>" required>
				<div class="valid-feedback">Looks good!</div>
			</div>
			<div class="form-group w-50">
				<label>Classification</label> <select class="custom-select"
					name="classification" id="classification" required>
					<%
						List<Classification> classifications = (List<Classification>) request.getAttribute("classifications");
					if (classifications != null) {
						for(Classification cl: classifications){
					%>
					<option value="<%=cl.getId()%>" <%if(car.getClassification().getId() == cl.getId()){ %> selected="selected"  <%}%>><%=cl.getClassification()%></option>
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
					class="form-control is-valid"
					name="year" id="year" pattern="^(2009|2010|2011|2012)" title="El año solo acepta años del 2009 al 2012" placeholder="Year"
					value="<%=car.getYear()%>" required>
				<div class="valid-feedback">Looks good!</div>
			</div>
		</fieldset>

		<h2 class="m-5 pb-5">Dimensions</h2>
		<fieldset class="form-row m-5 pb-5">
			<div class="col-md-4 mb-3">
				<label for="validationServer12">Width</label> <input type="text"
					name="width" id="width" pattern="[0-9]{0,19}" title="Solo acepta números" class="form-control is-valid"
					placeholder="First name"
					value="<%=car.getWidth()%>" required>
				<div class="valid-feedback">Looks good!</div>
			</div>
			<div class="col-md-4 mb-3">
				<label for="validationServer13">Length</label> <input type="text"
					class="form-control is-valid" 
					name="length" id="length" pattern="[0-9]{0,19}" title="Solo acepta números" placeholder="Last name"
					value="<%=car.getLength()%>" required>
				<div class="valid-feedback">Looks good!</div>
			</div>
			<div class="col-md-4 mb-3">
				<label for="validationServer14">Height</label> <input type="text"
					class="form-control is-valid"
					name="height" id="height" pattern="[0-9]{0,19}" title="Solo acepta números" placeholder="Last name"
					value="<%=car.getHeight()%>" required>
				<div class="valid-feedback">Looks good!</div>
			</div>

		</fieldset>

		<h2 class="m-5 pb-5">Fuel Information</h2>
		<fieldset class="form-row m-5 pb-5">
			<div class="col-md-4 mb-3">
				<label for="validationServer15">Highway mpg</label> <input
					type="text" class="form-control is-valid" 
					name="highwaympg" id="highwaympg" pattern="[0-9]{0,19}" title="Solo acepta números" placeholder="First name"
					value="<%=car.getHighwaympg()%>" required>
				<div class="valid-feedback">Looks good!</div>
			</div>
			<div class="col-md-4 mb-3">
				<label for="validationServer16">City mph</label> <input type="text"
					class="form-control is-valid"
					name="citymph" id="citymph" pattern="[0-9]{0,19}" title="Solo acepta números" placeholder="Last name"
					value="<%=car.getCitymph()%>" required>
				<div class="valid-feedback">Looks good!</div>
			</div>
			<div class="form-group w-50">
				<label>Fuel Type</label> <select class="custom-select" name="fuelType" id="fuelType"
					required>
					<%
						List<Fuel> fueltypes = (List<Fuel>) request.getAttribute("fueltypes");
					if (fueltypes != null) {
						for(Fuel ft: fueltypes){
					%>
					<option value="<%=ft.getId()%>" <%if(car.getFueltype().getId() == ft.getId()){ %> selected="selected"  <%}%>><%=ft.getFuelType()%></option>
					<%
						}
					}
					%>
				</select>
				<div class="invalid-feedback">Example invalid custom select
					feedback</div>
			</div>
			
			<div class="file-loading">
				<input id="input-id" name="image" type="file" multiple>
			
			</div>

		</fieldset>
		
		
		<button class="btn btn-primary btn-lg" type="submit">Actualizar</button>
	</form>
	
	 <form action="./delete" method="post" enctype="multipart/form-data">
		<input type="hidden" name="action" value="deleteCar" /> <input type="hidden" name="id" value="<%=car.getId()%>" /> <input type="hidden" name="redirect" value="./<%=encodeValue(request.getAttribute("redirect").toString()) %>" />
		<button class="btn btn-primary btn-lg" type="submit">Eliminar</button>
	</form> 

	
	<button class="btn btn-primary hBack" onclick="location.href = 'http://localhost:8080/proyecto-web/';">REGRESAR A
		LOS COCHES</button>
		
		<div class="loader text-center">
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
        <p class="font-italic text-muted">Cargando dentro de <strong class="countdown text-dark font-weight-bold">3 </strong> segundos</p>
    </div>
</div>
		
		
	
		
		<footer id="footer">
		<div class="container">
			<div class="row d-flex align-items-center">
				<div class="col-lg-6 text-lg-left text-center">
					<div class="copyright">
						&copy; Copyright <strong>Organizatium</strong>. Todos los derechos
						reservados.
					</div>
				</div>
			</div>
		</div>
	</footer>
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
	(function() {
		  'use strict';
		  window.addEventListener('load', function() {
		    var forms = document.getElementsByClassName('needs-validation');
		    var validation = Array.prototype.filter.call(forms, function(form) {
		      form.addEventListener('submit', function(event) {
		        if (form.checkValidity() === false) {
		          event.preventDefault();
		          event.stopPropagation();
		        }
		        form.classList.add('was-validated');
		      }, false);
		    });
		  }, false);
		})();

//Imagenes
$(document).ready(function(){	 
	$("#input-id").fileinput({
		 initialPreview: [
			 <%
			 if(carImage !=null){
					%> 
					'<img width="213px" src="data:image/jpg;base64, <%= carImage.getImageInBase64() %>" class="file-preview-image" alt="Imagen1" title="Imagen1">'
			 <% } %>
		    ],
		    initialPreviewConfig: [
				
				<% 
				if(carImage != null){
					

			 %> {   
				
				caption: '<%=carImage.getName()%>',
				width: '120px',
				key: <%=carImage.getId()%>,
				
				},
				<%}%>	
				
			],
			initialPreviewAsData : false,
			overwriteInitial : false,
			maxFileSize : 5000,
			browseClass : "btn btn-warning",
			browseLabel : "Pick Images",
			browseIcon : "<i class=\"glyphicon glyphicon-picture\"></i> ",
		 
		});
});

</script>
<script>

// Toast
$(document).ready(function(){
	  $('.toast').toast('show');
	});
	
$(function () {
	  $('[data-toggle="tooltip"]').tooltip()
	});
	
$(document).ready(function(){
    $(window).on('load', function () {
        setTimeout(function () {
            $('.loader').hide(300);
        }, 2000);
    });


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
});
</script>
</body>

</html>