<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>

<%
String id=request.getParameter("id");
String mail=request.getParameter("mail");
String first_name=request.getParameter("fname");
String last_name=request.getParameter("lname");
String password=request.getParameter("password");
try
{

Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/car_management", "root", "manolo");
Statement st=conn.createStatement();
int i=st.executeUpdate("insert into user(id,email,first_name,last_name,password)values('"+id+"','"+mail+"','"+first_name+"','"+last_name+"','"+password+"')");
out.println("Data is successfully inserted!");
}
catch(Exception e)
{
System.out.print(e);
e.printStackTrace();
}
%>