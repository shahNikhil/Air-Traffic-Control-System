<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="com.DualCore.Entity.*"%>
<%@ page import="com.DualCore.Boundary.*"%>

<%
	String error = "";
	Aircraft editA = new Aircraft();

	AircraftImpl aircraftDAO = new AircraftImpl();
	editA = aircraftDAO.getAircraft(Integer.parseInt(request.getParameter("id")));
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<title>Edit Aircraft</title>
</head>
<body>

	<h1>Edit Aircraft</h1>
(manufacturer, total_seats, weight_capacity, is_autoPilot, max_speed
	<form method="POST" action="AircraftService">

		<table class="w3-table">

			<tr>
				<td>Manufacturer</td>
				<td><input type="text" name="manufacturer"
					value="<%out.print(editA.getManufacturer());%>" /></td>
			</tr>

			<tr>
				<td>Total seats</td>
				<td><input type="text" name="total_seats"
					value="<%out.print(editA.getTotal_seats());%>" /></td>
			</tr>
			
			<tr>
				<td>Weight capacity (in KGs)</td>
				<td><input type="number" name="weight_capacity"
					value="<%out.print(editA.getWeight_capacity());%>" /></td>
			</tr>

			<tr>
				<td>Is AutoPilot?</td>
				<td><p><input class="w3-radio" type="radio" name="is_autoPilot" value="Yes" >
  					<label>Yes</label></p>
  					<p><input class="w3-radio" type="radio" name="is_autoPilot" value="No">
  					<label>No</label></p></td>
			</tr>

			<tr>
				<td>Max Speed (in knots)</td>
				<td><input type="number" name="max_speed"
					value="<%out.print(editA.getMax_speed());%>" /></td>
			</tr>
			
		</table>

		<input type="hidden" name="id"
			value="<%out.print(editA.getId());%>" /> <input type="hidden"
			name="action" value="edit" /> <input type="submit" method="post"
			action="AircraftService" />

	</form>

</body>
</html>