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
#cover {

    height: 100%;
    text-align: center;
    display: flex;
    align-items: center;
    position: relative;
}

#cover-caption {
    width: 100%;
    position: relative;

}

/* only used for background overlay not needed for centering */
form:before {
    content: '';
    height: 100%;
    left: 0;
    position: absolute;
    top: 0;
    width: 100%;
    z-index: -1;
    border-radius: 10px;
}

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
						onclick="location.href = 'http://localhost:8080/proyecto-web/login';">Acceso</a></li>

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
<section id="cover" class="min-vh-100">
    <div id="cover-caption">
        <div class="container">
            <div class="row">
<div class="col-xl-5 col-lg-6 col-md-8 col-sm-10 mx-auto text-center form p-4">
                                       <h1 class="display-4 py-2 text-truncate">Actualizar</h1>
                        <form action="./update" method="post" enctype="multipart/form-data" class="justify-content-center">
		<input type="hidden" name="action" value="updateCar" /> <input type="hidden" name="pk" value="<%=car.getId()%>" /> <input type="hidden" name="redirect" value="./<%=encodeValue(request.getAttribute("redirect").toString()) %>" />

		
		<h2 class="m-5">Información del motor</h2>
			<div class="form-group">
				<label>Transmisión</label> <select class="custom-select"
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
				
					
			</div>
                           
			<div>
				<label for="validationServer02">Tipo de motor</label> <input
					type="text" class="form-control " id="validationServer02"
					placeholder="" name="enginetype" 
					value="<%=car.getEnginetype()%>" required>
				
			</div>


		
				<h2 class="m-5">Estadísticas del motor</h2>
				<div>
					<label for="validationServer03">Caballos de potencia</label> <input
						type="text" class="form-control "
						placeholder=""
						name="horsepower" id="horsepower" id="horsepower"  pattern="[0-9]{1,19}" title="Solo acepta números, 1 valor mínimo" value="<%=car.getHorsepower()%>"
						required>
					
				</div>
				<div>
					<label for="validationServer04">Torque</label> <input type="text"
						class="form-control " 
						placeholder=""
						name="torque" id="torque" pattern="[0-9]{1,19}" title="Solo acepta números, 1 valor mínimo" value="<%=car.getTorque()%>"
						required>
					
				</div>

		
			<div class="form-group">
				<div class="form-row">
					<label class="mt-2 col-form-label" for="hybrid">Híbrido:</label>
					<div class="form-check ml-1 mt-3">
					<% 
					Car c = new Car();
					String hybridSelected = c.isHybrid()?" checked=''checked'":""; %>
						<input class="form-check-input valid" type="checkbox"
							name="hybrid" id="hybrid" <%=hybridSelected%>>
					</div>
				</div>
			</div>
			<div>
				<label for="validationServer05">Número de marchas delanteras</label> <input
					type="text" class="form-control "
					name="numberofforwardgears" id="numberofforwardgears" pattern="[0-9]{0,19}" title="Solo acepta números" value="<%=car.getNumberofforwardgears()%>"
					required>
			</div>
			<div class="form-group">
				<label>Línea motriz</label> <select class="custom-select"
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
				
					
			</div>

		<h2 class="m-5">Identificación</h2>
			<div>
				<label for="validationServer08">Marca</label> <input
					type="text" class="form-control " 
					placeholder=""
					name="make" id="make" pattern="^[A-Z][A-Za-z]{2,19}$" title="La marca solo acepta letras y la primera en mayúsculas" value="<%=car.getMake()%>" required>
				
			</div>
			<div>
				<label for="validationServer08">Año del modelo</label> <input
					type="text" class="form-control " 
					placeholder=""
					name="modelyear" id="modelyear" value="<%=car.getModelyear()%>" required>
				
			</div>
			<div>
				<label for="validationServer09">Nombre</label> <input type="text"
					class="form-control "
					placeholder=""
					name="name" id="name" data-toggle="tooltip" data-placement="right" title="El nombre debe ser único" value="<%=car.getName()%>" required>
				
			</div>
			<div class="form-group">
				<label>Clasificación</label> <select class="custom-select"
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
				
			</div>
			<div>
				<label for="validationServer10">Año</label> <input type="text"
					class="form-control "
					name="year" id="year" pattern="^(2009|2010|2011|2012)" title="El año solo acepta años del 2009 al 2012" placeholder="Year"
					value="<%=car.getYear()%>" required>
				
			</div>

		<h2 class="m-5">Dimensiones</h2>

			<div>
				<label for="validationServer12">Anchura</label> <input type="text"
					name="width" id="width" pattern="[0-9]{0,19}" title="Solo acepta números" class="form-control "
					placeholder=""
					value="<%=car.getWidth()%>" required>
				
			</div>
			<div>
				<label for="validationServer13">Longitud</label> <input type="text"
					class="form-control " 
					name="length" id="length" pattern="[0-9]{0,19}" title="Solo acepta números" placeholder=""
					value="<%=car.getLength()%>" required>
				
			</div>
			<div>
				<label for="validationServer14">Altura</label> <input type="text"
					class="form-control "
					name="height" id="height" pattern="[0-9]{0,19}" title="Solo acepta números" placeholder=""
					value="<%=car.getHeight()%>" required>
				
			</div>

		<h2 class="m-5">Información del combustible</h2>
			<div>
				<label for="validationServer15">Mpg en carretera</label> <input
					type="text" class="form-control " 
					name="highwaympg" id="highwaympg" pattern="[0-9]{0,19}" title="Solo acepta números" placeholder=""
					value="<%=car.getHighwaympg()%>" required>
				
			</div>
			<div>
				<label for="validationServer16">Mph en ciudad</label> <input type="text"
					class="form-control "
					name="citymph" id="citymph" pattern="[0-9]{0,19}" title="Solo acepta números" placeholder=""
					value="<%=car.getCitymph()%>" required>
				
			</div>
			<div class="form-group">
				<label>Tipo de combustible</label> <select class="custom-select" name="fuelType" id="fuelType"
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
				
					
			</div>
			
			<div class="file-loading">
				<input id="input-id" name="image" type="file" multiple>
			
			</div>
		
		<button class="btn btn-primary btn-lg" type="submit">Actualizar</button>
		
                        </form>
                        <form action="./delete" method="post" enctype="multipart/form-data">
		<input type="hidden" name="action" value="deleteCar" /> <input type="hidden" name="id" value="<%=car.getId()%>" /> <input type="hidden" name="redirect" value="./<%=encodeValue(request.getAttribute("redirect").toString()) %>" />
		<button class="btn btn-primary btn-lg" type="submit">Eliminar</button>
	</form> 
	<button class="btn btn-primary hBack" onclick="location.href = 'http://localhost:8080/proyecto-web/';">REGRESAR A
		LOS COCHES</button>
                    </div>
                </div>
            </div>
        </div>
</section>
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
				<div>
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