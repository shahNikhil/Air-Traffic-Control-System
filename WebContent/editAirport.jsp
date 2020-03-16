<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%--This is the jsp page if the admin wants to edit any current Airport --%>	

<%@ page import="com.DualCore.Entity.*"%>
<%@ page import="com.DualCore.Boundary.*"%>

<%
	String error = "";
	Airport editA = new Airport();

	AirportImpl airportDAO = new AirportImpl();
	editA = airportDAO.getAirport(Integer.parseInt(request.getParameter("id")));
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<title>Edit Airport</title>
</head>
<body>

	<h1>Edit Airport</h1>

	<form method="POST" action="AirportService">

		<table class="w3-table">

			<tr>
				<td>Country</td>
				<td><input type="text" name="country"
					value="<%out.print(editA.getCountry());%>" /></td>
			</tr>

			<tr>
				<td>City</td>
				<td><input type="text" name="city"
					value="<%out.print(editA.getCity());%>" /></td>
			</tr>
			
			<tr>
				<td>Airport Name</td>
				<td><input type="text" name="airport_name"
					value="<%out.print(editA.getAirport_name());%>" /></td>
			</tr>

			<tr>
				<td>Airport Type</td>
				<td><input type="text" name="airport_type"
					value="<%out.print(editA.getAirport_type());%>" /></td>
			</tr>

			<tr>
				<td>Total Runways</td>
				<td><input type="number" name="total_runways"
					value="<%out.print(editA.getTotal_runways());%>" /></td>
			</tr>
			
			<tr>
				<td>Total Terminals</td>
				<td><input type="number" name="total_terminals"
					value="<%out.print(editA.getTotal_terminals());%>" /></td>
			</tr>

		</table>

		<input type="hidden" name="id"
			value="<%out.print(editA.getId());%>" /> <input type="hidden"
			name="action" value="edit" /> <input type="submit" method="post"
			action="AirportService" />

	</form>

</body>
</html>