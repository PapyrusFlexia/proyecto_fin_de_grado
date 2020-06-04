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


<link href="assets/css/style.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css">
	<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.21/css/dataTables.bootstrap4.min.css">
	
<script type="text/javascript" charset="utf8" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.21/js/dataTables.bootstrap4.min.js"></script>
</head>

<body>
	<%

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
		
		<div class="pt-5 mt-5">
				<table class="table table-bordered table-striped text-center" id="booking" class="display" style="display:none;">
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

	    $('#booking thead tr').clone(true).appendTo( '#booking thead' );
	    $('#booking thead tr:eq(1) th').each( function (i) {
	        var title = $(this).text();
	        $(this).html( '<input type="text" placeholder="Buscar por '+title+'" />' );
	 
	        $( 'input', this ).on( 'keyup change', function () {
	            if ( table.column(i).search() !== this.value ) {
	                table
	                    .column(i)
	                    .search( this.value )
	                    .draw();
	            }
	        } );
	    } );
	 
	    var table = $('#booking').DataTable( {
	    	language: {
  	          "url": "//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Spanish.json"
  	        },
  	      bLengthChange: true,
  	    "lengthMenu": [ [10, 15, 25, 50, 100, -1], [10, 15, 25, 50, 100, "All"] ],
  	    "iDisplayLength": 50,
  	    bInfo: false,
  	    responsive: true,
  	    "bAutoWidth": false,
	        orderCellsTop: true,
	        fixedHeader: true
	    } );
	} );
	
		$(document)
				.ready(
						
						function() {
							$("button.reserved").click(function(){
							      $(this).prop("disabled",true);
							});					
		});
		
		
	</script>


</body>

</html>