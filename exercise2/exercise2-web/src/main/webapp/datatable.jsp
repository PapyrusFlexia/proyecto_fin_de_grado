
<%@page import="java.io.UnsupportedEncodingException"%>
<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="com.practicas.model.Identification"%>
<%@page import="com.practicas.model.Car"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.css">
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

				<div class="navbar-nav ml-auto">

					<div class="input-group">

						<div class="btn-group" role="group">

							<button type="button" class="btn btn-light mr-2"
								data-toggle="tooltip" data-placement="bottom" title="Volver al modo clásico"
								onclick="location.href = './';">Servlet</button>

							<button type="button" class="btn btn-light mr-2"
								data-toggle="tooltip" data-placement="bottom" title="Loguearte"
								onclick="location.href = 'login.jsp';">Login</button>

						</div>

					</div>

				</div>
			</div>


		</nav>
	</div>
	<%
		System.out.println(request.getQueryString());

	String pageActual = (String) request.getAttribute("page");
	Long total = (Long) request.getAttribute("total");
	String make = (String) request.getAttribute("make");
	Integer yearP = (Integer) request.getAttribute("year");
	String hybridFiltro = (String) request.getAttribute("hybrid");
	String classificationFiltro = (String) request.getAttribute("classification");
	if (yearP == null) {
		yearP = 0;
	}

	List<String> identifications = (List<String>) request.getAttribute("makes");
	List<Integer> years = (List<Integer>) request.getAttribute("years");
	List<Boolean> hybridTabla = (List<Boolean>) request.getAttribute("hybrids");
	List<String> classificationTabla = (List<String>) request.getAttribute("classifications");
	List<Car> cochesTabla = (List<Car>) request.getAttribute("cars");
	%>
	<div class="container-fluid">
		<div class="row"></div>
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8">
				<input type="hidden" name="page" id="page" value="<%=pageActual%>" />
				<input type="hidden" name="makeFilterValue" id="makeFilterValue"
					value="<%=make%>" /> <input type="hidden" name="yearFilterValue"
					id="yearFilterValue" value="<%=yearP%>" /> <input type="hidden"
					name="hybridFilterValue" id="hybridFilterValue"
					value="<%=hybridFiltro%>" /> <input type="hidden"
					name="classificationFilterValue" id="classificationFilterValue"
					value="<%=classificationFiltro%>" />
				<h1>Listado de coches</h1>



				<table id="carsTable" class="display" style="width: 100%">
					<thead>
						<tr>
							<th>ID</th>
							<th>Modelo</th>
							<th>Marca</th>
							<th>Año</th>
							<th>Híbrido</th>
							<th>Clasificación</th>
							<th scope="col">Acciones</th>
						</tr>
						<tr>
							<th scope="col"><br>
							<a><span ></span><span
									></span></a></th>
							<th scope="col"><br>
							<a><span ></span><span
									></span></a></th>
							<th scope="col"><br>
							<a><span ></span><span
									></span></a></th>
							<th scope="col"><br>
							<a><span ></span><span
									></span></a></th>
							<th scope="col"><br>
							<a><span></span><span
									></span></a></th>
							<th scope="col"><br>
							<a><span></span><span
								></span></a></th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
						<tr>
					
				</table>
				<%
					
				%>

			</div>

			<div class="col-sm-2"></div>
		</div>
		<ul>
			<li class="page-item"><a class="page-link"
				href="./?action=datatable">VOLVER
					A VALORES POR DEFECTO</a></li>
		</ul>
	</div>
	<%!private static String encodeValue(String value) {
		String url = "";
		try {
			url = URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
		} catch (Exception ex) {

		}
		return url;
	}%>

	<script src="https://code.jquery.com/jquery-3.4.1.min.js"
		integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
		crossorigin="anonymous"></script>
	<script src="./js/popper.min.js"></script>
	<script src="./js/bootstrap-select.min.js"></script>
	<script src="./js/bootstrap.min.js"></script>
	<script type="text/javascript" charset="utf8"
		src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript">


   
	 $(document).ready(function() {
	        var table = $('#carsTable').DataTable( {
	        	"processing": true,
	            "serverSide": true,
	        	language: {
	    	          "url": "//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Spanish.json"
	    	        },
	      		ajax: {
	       	       url: './carsJSON',
	       	       dataSrc: 'cars'
	       	     },
	       	  columnDefs: [ {
                "targets": -1,
                "data": 'pk',
                "render": function (data, type, row, meta) {
                    return '<a role="button" class="btn" id='+data+' href="./?action=detalles&pk=' + data + '&redirect="><span class=\"glyphicon glyphicon-eye-open\"></span></a>'
                }
	          } ],
	          
	       	    "deferRender": true,
	      		"columns": [
	      			{ data: 'pk' },
	       	       { data: 'identification.id' },
	       	       { data: 'identification.make'},
	       	       { data: 'identification.year'},
	       	       { data: 'engineinformation.hybrid'},
	       	       { data: 'identification.classification'},
	       	       { data: 'pk'}
	      		],
	      		 initComplete: function () {
	      			 var makes = json.filters.makes;
	      			 var years = json.filters.years;
	      			 var classifications = json.filters.classifications;
	      			 var fueltypes = json.filters.fueltypes;
	      	            this.api().columns(2).every( function () {
	      	                var column = this;
	      	                var select = $('<select><option value=""></option></select>')
	      	                    .appendTo( $(column.footer()))
	      	                    .on( 'change', function () {
	      	                        var val = $.fn.dataTable.util.escapeRegex(
	      	                            $(this).val()
	      	                        );
	      	 
	      	                        column
	      	                            .search( val ? '^'+val+'$' : '', true, false )
	      	                            .draw();
	      	                    } );
	      	 
	      	              for(i = 0; i < makes.length; i++){
	      	            	  select.append( '<option value="'+makes[i]+'">'+makes[i]+'</option>')
	      	              }
	      	            } );
	      	            this.api().columns(3).every( function() {
	      	            	var column = this;
	      	            	var select = $('<select><option value=""></option></select>')
	      	            		.appendTo( $(column.footer()))
	      	            		.on( 'change', function() {
	      	            			var val = $.fn.dataTable.util.escapeRegex(
		      	                            $(this).val()
	      	            		);
	      	            			 column
	      	                            .search( val ? '^'+val+'$' : '', true, false )
	      	                            .draw();
	      	                    } );
	      	 
	      	              for(i = 0; i < makes.length; i++){
	      	            	  select.append( '<option value="'+makes[i]+'">'+makes[i]+'</option>')
	      	              }
	      	            } );
	      	            }
	      	        }
	         );
	    } );
    </script>
</body>
</html>