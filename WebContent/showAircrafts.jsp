<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.*"%>

<%@ page import="com.DualCore.Entity.*"%>
<%@ page import="com.DualCore.Boundary.*"%>

<%

	AircraftImpl aircraftDAO = new AircraftImpl();
	ArrayList<Aircraft> aircraftList = new ArrayList<Aircraft>();
	
	aircraftList = aircraftDAO.showAircrafts();

%>

<!DOCTYPE html>
<html>
<title>W3.CSS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<body>

	<div class="w3-bar w3-black w3-large">
		<a href="#" class="w3-bar-item w3-button w3-mobile"><i
			class="w3-xlarge material-icons">home</i></a> <a href="#"
			class="w3-bar-item w3-button w3-mobile">Pilots</a> <a href="#"
			class="w3-bar-item w3-button w3-mobile">Aircrafts</a> <a href="#"
			class="w3-bar-item w3-button w3-right w3-mobile"><i
			class="w3-xlarge material-icons">person</i></a>
	</div>

	<div class="w3-margin w3-container">
		<h2 class="w3-center">Aircraft Data</h2>
		<table class="w3-table-all w3-hoverable w3-centered">
			
			<tr>
				<th>Aircraft ID</th>
				<th>Manufacturer</th>
				<th>Total Seats</th>
				<th>Weight_capacity</th>
				<th>Is AutoPilot</th>
				<th>Max Speed</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			
			<%
				
				//Iterate through the aircrafts from the ArrayList and print out in the table
				
				for(Aircraft a : aircraftList) {
					
					out.print("<tr>");
					
					out.print("<td>" + a.getId() + "</td>");
					out.print("<td>" + a.getManufacturer() + "</td>");
					out.print("<td>" + a.getTotal_seats() + "</td>");
					out.print("<td>" + String.valueOf(a.getWeight_capacity()) + "</td>");
					out.print("<td>" + a.getIs_autoPilot() + "</td>");
					out.print("<td>" + String.valueOf(a.getMax_speed()) + "</td>");
					
					out.print("<td><a href=\"editAircraft.jsp?id=" + a.getId() + "\" TARGET=\new\">Edit</a></td>");
					out.print("<td><a href=\"AircraftService?action=delete&id=" + a.getId() + "\" TARGET=\"new\">Delete</a></td>");
					
					out.print("</tr>");
					
				}
			
			%>
			
		</table>
		
		<hr>
		
		<p>Create a <a href="createAircraft.jsp" TARGET="_new"> new Aircraft.</a></p>
		
	</div>

</body>
</html>