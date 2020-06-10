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
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" crossorigin="anonymous">
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-fileinput/5.0.9/css/fileinput.min.css" media="all" rel="stylesheet" type="text/css" />
<!-- if using RTL (Right-To-Left) orientation, load the RTL CSS file after fileinput.css by uncommenting below -->
<!-- link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-fileinput/5.0.9/css/fileinput-rtl.min.css" media="all" rel="stylesheet" type="text/css" /-->
<!-- the font awesome icon library if using with `fas` theme (or Bootstrap 4.x). Note that default icons used in the plugin are glyphicons that are bundled only with Bootstrap 3.x. -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.min.js" crossorigin="anonymous"></script>
<!-- piexif.min.js is needed for auto orienting image files OR when restoring exif data in resized images and when you
    wish to resize images before upload. This must be loaded before fileinput.min.js -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-fileinput/5.0.9/js/plugins/piexif.min.js" type="text/javascript"></script>
<!-- sortable.min.js is only needed if you wish to sort / rearrange files in initial preview. 
    This must be loaded before fileinput.min.js -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-fileinput/5.0.9/js/plugins/sortable.min.js" type="text/javascript"></script>
<!-- purify.min.js is only needed if you wish to purify HTML content in your preview for 
    HTML files. This must be loaded before fileinput.min.js -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-fileinput/5.0.9/js/plugins/purify.min.js" type="text/javascript"></script>
<!-- popper.min.js below is needed if you use bootstrap 4.x (for popover and tooltips). You can also use the bootstrap js 
   3.3.x versions without popper.min.js. -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<!-- bootstrap.min.js below is needed if you wish to zoom and preview file content in a detail modal
    dialog. bootstrap 4.x is supported. You can also use the bootstrap js 3.3.x versions. -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<!-- the main fileinput plugin file -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-fileinput/5.0.9/js/fileinput.min.js"></script>
<!-- following theme script is needed to use the Font Awesome 5.x theme (`fas`) -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-fileinput/5.0.9/themes/fas/theme.min.js"></script>
<!-- optionally if you need translation for your language then include the locale file as mentioned below (replace LANG.js with your language locale) -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-fileinput/5.0.9/js/locales/LANG.js"></script>
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
	%>

	<%
		String executed = (String) request.getAttribute("executed");
	if ("ok".equals(executed)) {
	%>
<div aria-live="polite" aria-atomic="true" class="d-flex justify-content-center align-items-center" style="min-height: 200px;">	



<div class="toast" role="alert" aria-live="assertive" aria-atomic="true" data-delay="10000">
  <div class="toast-header">
    <strong class="mr-auto">¡INSERTADO!</strong>
    <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
      <span aria-hidden="true">&times;</span>
    </button>
  </div>
  <div class="toast-body">
   El coche se ha insertado correctamente
  </div>
</div>
</div>
	<%
		}
	%>
	<br>
<section id="cover" class="min-vh-100">
    <div id="cover-caption">
        <div class="container">
            <div class="row">
<div class="col-xl-5 col-lg-6 col-md-8 col-sm-10 mx-auto text-center form p-4">
                                       <h1 class="display-4 py-2 text-truncate">Insertar</h1>
                    

		
		<h2 class="m-5">Información del motor</h2>
	<form action="./insert" method="post" enctype="multipart/form-data">
		<input type="hidden" name="action" value="insertCar" />
		
			<div class="form-group">
				<label>Transmission</label> <select class="custom-select"
					name="transmission" id="transmission" required>
					<%
						List<Transmission> transmissions = (List<Transmission>) request.getAttribute("transmissions");
					if (transmissions != null) {
						for (Transmission tr : transmissions) {
					%>
					<option value="<%=tr.getId()%>"><%=tr.getTransmission()%></option>
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
					required>
				
			</div>


		
				<h2 class="m-5">Estadísticas del motor</h2>
				<div>
					<label for="validationServer03">Caballos de potencia</label> <input
						type="text" class="form-control "
						placeholder=""
						name="horsepower" id="horsepower" id="horsepower"  pattern="[0-9]{1,19}" title="Solo acepta números, 1 valor mínimo" 
						required>
					
				</div>
				<div>
					<label for="validationServer04">Torque</label> <input type="text"
						class="form-control " 
						placeholder=""
						name="torque" id="torque" pattern="[0-9]{1,19}" title="Solo acepta números, 1 valor mínimo"
						required>
					
				</div>

			<div class="form-group">
				<div class="form-row">
					<label class="mt-2 col-form-label" for="hybrid">Híbrido:</label>
					<div class="form-check ml-1 mt-3">
					<%
							Car c = new Car();
						String hybridSelected = c.isHybrid() ? " checked=''checked'" : "";
						%>
						<input class="form-check-input valid" type="checkbox"
							name="hybrid" id="hybrid" <%=hybridSelected%>>
					</div>
				</div>
			</div>
			<div>
				<label for="validationServer05">Número de marchas delanteras</label> <input
					type="text" class="form-control "
					name="numberofforwardgears" id="numberofforwardgears" pattern="[0-9]{0,19}" title="Solo acepta números"
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
					<option value="<%=dl.getId()%>"><%=dl.getDriveLine()%></option>
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
					name="make" id="make" pattern="^[A-Z][A-Za-z]{2,19}$" title="La marca solo acepta letras y la primera en mayúsculas" required>
				
			</div>
			<div>
				<label for="validationServer08">Año del modelo</label> <input
					type="text" class="form-control " 
					placeholder=""
					name="modelyear" id="modelyear"  required>
				
			</div>
			<div>
				<label for="validationServer09">Nombre</label> <input type="text"
					class="form-control "
					placeholder=""
					name="name" id="name" data-toggle="tooltip" data-placement="right" title="El nombre debe ser único" required>
				
			</div>
			<div class="form-group">
				<label>Clasificación</label> <select class="custom-select"
					name="classification" id="classification" required>
					<%
						List<Classification> classifications = (List<Classification>) request.getAttribute("classifications");
					if (classifications != null) {
						for(Classification cl: classifications){
					%>
					<option value="<%=cl.getId()%>"><%=cl.getClassification()%></option>
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
					required>
				
			</div>

		<h2 class="m-5">Dimensiones</h2>

			<div>
				<label for="validationServer12">Anchura</label> <input type="text"
					name="width" id="width" pattern="[0-9]{0,19}" title="Solo acepta números" class="form-control "
					placeholder=""
					required>
				
			</div>
			<div>
				<label for="validationServer13">Longitud</label> <input type="text"
					class="form-control " 
					name="length" id="length" pattern="[0-9]{0,19}" title="Solo acepta números" placeholder=""
					required>
				
			</div>
			<div>
				<label for="validationServer14">Altura</label> <input type="text"
					class="form-control "
					name="height" id="height" pattern="[0-9]{0,19}" title="Solo acepta números" placeholder=""
					required>
				
			</div>

		<h2 class="m-5">Información del combustible</h2>
			<div>
				<label for="validationServer15">Mpg en carretera</label> <input
					type="text" class="form-control " 
					name="highwaympg" id="highwaympg" pattern="[0-9]{0,19}" title="Solo acepta números" placeholder=""
					required>
				
			</div>
			<div>
				<label for="validationServer16">Mph en ciudad</label> <input type="text"
					class="form-control "
					name="citymph" id="citymph" pattern="[0-9]{0,19}" title="Solo acepta números" placeholder=""
					required>
				
			</div>
			<div class="form-group">
				<label>Tipo de combustible</label> <select class="custom-select" name="fuelType" id="fuelType"
					required>
					<%
						List<Fuel> fueltypes = (List<Fuel>) request.getAttribute("fueltypes");
					if (fueltypes != null) {
						for(Fuel ft: fueltypes){
					%>
					<option value="<%=ft.getId()%>"><%=ft.getFuelType()%></option>
					<%
						}
					}
					%>
				</select>
				
					
			</div>
			
			<div class="file-loading">
				<input id="input-id" name="image" type="file" class="file"  data-preview-file-type="text" multiple
					accept="image" multiple>
			
			</div>
		
		<button class="btn btn-primary btn-lg" type="submit">Insertar</button>
		
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
	
	// initialize with defaults
	$("#input-id").fileinput();
	 
	// with plugin options
	$("#input-id").fileinput({'showUpload':false, 'previewFileType':'any'});


	
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
	<script>
$(document).ready(function(){
	  $('.toast').toast('show');
	});
	
$(function () {
	  $('[data-toggle="tooltip"]').tooltip()
	})
	
	$(document).ready(function(){
    $(window).on('load', function () {
        setTimeout(function () {
            $('.loader').hide(300);
        }, 2000);
    });

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