<%@page import="java.io.UnsupportedEncodingException"%>
<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.List"%>
<%@page import="com.proyecto.model.Car"%>
<%@page import="com.proyecto.model.Booking"%>
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
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">


<link href="assets/css/style.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.21/css/dataTables.bootstrap4.min.css">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.21/js/dataTables.bootstrap4.min.js"></script>
<style>
.reserva input {
	float: left;
}

#bookingid {
	text-align: center;
	margin: 0 auto; . star-rating { line-height : 32px;
	font-size: 1.25em;
}

.star-rating .fa-star {
	color: yellow;
}
}
</style>
</head>

<body>
	<%
	
	List<String> nameTabla = (List<String>) request.getAttribute("names");
	List<Booking> bookingsTabla = (List<Booking>) request.getAttribute("bookings");

	String nameSelect = (String) request.getAttribute("carname");
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
	
<div class="section-title" data-aos="fade-up">
				<h2>Reservas</h2>
			</div>
		<table class="table table-bordered table-striped text-center"
			id="booking" class="display">
			<thead class="thead-light">
				<tr>
					<th scope="col">Nombre<br> <a><span
							class="glyphicon glyphicon-chevron-up"></span><span
							class="glyphicon glyphicon-chevron-down"></span></a></th>
					<th scope="col">Lugar<br> <a><span
							class="glyphicon glyphicon-chevron-up"></span><span
							class="glyphicon glyphicon-chevron-down"></span></a></th>
					<th scope="col">Número de usuarios<br> <a><span
							class="glyphicon glyphicon-chevron-up"></span><span
							class="glyphicon glyphicon-chevron-down"></span></a></th>
					<th scope="col">Fecha de inicio<br> <a><span
							class="glyphicon glyphicon-chevron-up"></span><span
							class="glyphicon glyphicon-chevron-down"></span></a></th>
					<th scope="col">Fecha de fin<br> <a><span
							class="glyphicon glyphicon-chevron-up"></span><span
							class="glyphicon glyphicon-chevron-down"></span></a></th>
					<th scope="col">Valoración<br> <a><span
							class="glyphicon glyphicon-chevron-up"></span><span
							class="glyphicon glyphicon-chevron-down"></span></a></th>


				</tr>
			</thead>
			<tbody>
				<%
					if (bookingsTabla != null) {
					for (Booking b : bookingsTabla) {
				%>
				<tr>
					<td><%=b.getCarname()%></td>
					<td><%=b.getPlace()%></td>
					<td><%=b.getNumberofusers()%></td>
					<td><%=b.getStartdate()%></td>
					<td><%=b.getFinishdate()%></td>
					<td>
								<div class="star-rating">
									<span class="fa fa-star-o" data-rating="1" name="valorar" ></span> <span
										class="fa fa-star-o" data-rating="2"></span> <span
										class="fa fa-star-o" data-rating="3"></span> <span
										class="fa fa-star-o" data-rating="4"></span> <span
										class="fa fa-star-o" data-rating="5"></span> <input
										type="hidden" name="valorar" id="valorar" class="rating-value"
										value="">
								</div>
						</a></td>
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

	<section id="booking" class="booking">
		<div class="container">

			<div class="section-title" data-aos="fade-up">
				<h2>Reservar</h2>
			</div>

			<div class="row">

				<div class="col-lg-5 col-md-12" data-aos="fade-up"
					data-aos-delay="300" id="bookingid">
					<form action="./booking" method="post">
						<div class="form-group">
							<input name="numberofusers" id="numberofusers" type="number"
								class="form-control" placeholder="Número de personas" min="1"
								max="5" required />

						</div>
						<div class="form-group">
							<select name="place" id="place" class="form-control"
								placeholder="Lugar" required>
								<option value="Reserva" disabled selected>Selecciona un
									lugar donde hacer tu reserva</option>
								<option value="Andalucia">Andalucía</option>
								<option value="Aragon">Aragón</option>
								<option value="Asturias">Asturias</option>
								<option value="Islas Baleares">Islas Baleares</option>
								<option value="Islas Canarias">Islas Canarias</option>
								<option value="Cantabria">Cantabria</option>
								<option value="Castilla La Mancha">Castilla La Mancha</option>
								<option value="Castilla y Leon">Castilla y León</option>
								<option value="Catalunya">Cataluña</option>
								<option value="Valencia">Valencia</option>
								<option value="Extremadura">Extremadura</option>
								<option value="Galicia">Galicia</option>
								<option value="Madrid">Madrid</option>
								<option value="Murcia">Murcia</option>
								<option value="Navarra">Navarra</option>
								<option value="Euskadi">País Vasco</option>
							</select>
						</div>
						<div class="form-group">
							<input name="startdate" id="startdate" type="text"
								class="form-control" placeholder="Fecha de inicio"  required/>

						</div>
						<div class="form-group">
							<input name="finishdate" id="finishdate" type="text"
								class="form-control" placeholder="Fecha de finalización" required />

						</div>
						
						<div class="form-group">
							<select class="form-control" data-live-search="true"
								title="Filter by name" name="carname" id="carname" required>
								<option value="-1">Nombre del coche</option>
								<%
									for (String name : nameTabla) {
								%>
								<option <%if (name.equals(nameSelect)) {%> selected <%}%>
									value="<%=name%>"><%=name%></option>
								<%
									}
								%>
							</select>
						</div>



						<div class="form-group">
							<label for="reserved">Reservado</label> <input type="checkbox"
								name="reserved" id="reserved" checked onclick="return false;">
						</div>
						<button class="btn btn-primary btn-lg" type="submit">Reservar</button>
					</form>
				</div>

			</div>

		</div>
	</section>


	<footer id="footer" class="pt-5 mt-5">
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
		$(document)
				.ready(
						function() {

							$('#booking thead tr').clone(true).appendTo(
									'#booking thead');
							$('#booking thead tr:eq(1) th')
									.each(
											function(i) {
												var title = $(this).text();
												$(this)
														.html(
																'<input type="text" placeholder="Buscar por '+title+'" />');

												$('input', this)
														.on(
																'keyup change',
																function() {
																	if (table
																			.column(
																					i)
																			.search() !== this.value) {
																		table
																				.column(
																						i)
																				.search(
																						this.value)
																				.draw();
																	}
																});
											});

							var table = $('#booking')
									.DataTable(
											{
												language : {
													"url" : "//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Spanish.json"
												},
												bLengthChange : true,
												"lengthMenu" : [
														[ 10, 15, 25, 50, 100,
																-1 ],
														[ 10, 15, 25, 50, 100,
																"All" ] ],
												"iDisplayLength" : 10,
												bInfo : false,
												responsive : true,
												"bAutoWidth" : false,
												orderCellsTop : true,
												fixedHeader : true
											});
						});
	</script>


	<script>
		$(function() {
			let $dt1 = $("#startdate").datepicker({
				minDate : 0,
				dateFormat : "yy-mm-dd",
				onSelect : function(dateString, instance) {

					let date = $dt1.datepicker('getDate');

					date.setDate(date.getDate() + 1)

					$dt2.datepicker('option', 'minDate', date);

				}
			});

			var $dt2 = $("#finishdate").datepicker({
				minDate : 0,
				dateFormat : "yy-mm-dd",

				onSelect : function(dateString, instance) {

					let date = $dt1.datepicker('getDate');

					date.setDate(date.getDate())

					$dt2.datepicker('option', 'maxDate', date);

				},
				maxDate : "+1m"
			});
		});

		var $star_rating = $('.star-rating .fa');

		var SetRatingStar = function(hermanos) {
			 return $(hermanos)
					.each(function() {
						if (parseInt($star_rating
								.siblings('input.rating-value').val()) >= parseInt($(
								this).data('rating'))) {
							return $(this).removeClass('fa-star-o').addClass(
									'fa-star');
						} else {
							return $(this).removeClass('fa-star').addClass(
									'fa-star-o');
						}
					});
		};

		$star_rating.on('click', function() {
			$star_rating.siblings('input.rating-value').val(
					$(this).data('rating'));
			return SetRatingStar($(this).siblings('.fa').andSelf());
		});

		SetRatingStar();
		$(document).ready(function() {

		});
		
	</script>


</body>

</html>