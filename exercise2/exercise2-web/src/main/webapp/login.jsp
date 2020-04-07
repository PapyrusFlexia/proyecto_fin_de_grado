
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
<title>Exercise 2</title>
</head>
<body>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8">
				 
			</div>
			<div class="col-sm-2"></div>
		</div>
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8">
				<h1></h1>
				
				<div class="wrapper fadeInDown">
				  <div id="formContent">
				    <!-- Tabs Titles -->
				
				    <!-- Icon -->
				    <div class="fadeIn first" style="background-color: grey;">
				      <img src="./images/avatar.png" id="icon" alt="User Icon" />
				    </div>
				
				    <!-- Login Form -->
				    <form action="./login" method="post">
				      <input type="text" id="login" class="fadeIn second" name="login" placeholder="login">
				      <input type="password" id="password" class="fadeIn third" name="pass" placeholder="password">
				      <input type="submit" class="fadeIn fourth" value="Log In">
				    </form>
				
				    <!-- Remind Passowrd -->
				    <div id="formFooter">
				      <a class="underlineHover" href="#">Forgot Password?</a>
				    </div>
				
				  </div>
				</div>
			</div>
			<div class="col-sm-2"></div>
		</div>
	</div>
	
	
	<script src="./js/jquery-3.4.1.slim.min.js" ></script>
    <script src="./js/popper.min.js" ></script>
    <script src="./js/bootstrap-select.min.js" ></script>
    <script src="./js/bootstrap.min.js"></script>
    
    <script type="text/javascript">
    
    	$(document).ready(function(){
    		$('.filterYear').change(function (){
    	        var valor = $(this). children("option:selected"). val();
    	        location.href = './?action=pagination&filterYear='+valor+'&filterMake='+$('#makeFilterValue').val()+'&page='+$('#page').val();
    	    });
    	   	$('.filterMake').change(function (){
    	        var valor = $(this). children("option:selected"). val();
    	        location.href = './?action=pagination&filterMake='+valor+'&filterYear='+$('#yearFilterValue').val()+'&page='+$('#page').val();
    	   	});
    	});
	    
    
  
    	
    </script>


</body>
</html>