<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%--This is the jsp page to show all the Airports to admin along with CRUD functionality --%>		

<%@ page import="java.util.*"%>

<%@ page import="com.DualCore.Entity.*"%>
<%@ page import="com.DualCore.Boundary.*"%>

<%

	AirportImpl airportDAO = new AirportImpl();
	ArrayList<Airport> airportList = new ArrayList<Airport>();
	
	airportList = airportDAO.showAirports();

%>

<!DOCTYPE html>
<html>
<title>Show Airports</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<body>

	<div class="w3-bar w3-black w3-large">
		<a href="adminPanel.jsp" class="w3-bar-item w3-button w3-mobile"><i
			class="w3-xlarge material-icons">home</i></a> <a
			href="showPilotsAdmin.jsp" class="w3-bar-item w3-button w3-mobile">Pilots</a>
		<a href="showAirportsAdmin.jsp" class="w3-bar-item w3-button w3-mobile">Airports</a> <a
			href="showAircraftsAdmin.jsp" class="w3-bar-item w3-button w3-mobile">Aircrafts</a> <a
			href="showFlightsAdmin.jsp" class="w3-bar-item w3-button w3-mobile">Flights</a>
		<a href="index.jsp" class="w3-bar-item w3-button w3-right w3-mobile"><i
			class="w3-xlarge material-icons">exit_to_app</i></a>
	</div>

	<div class="w3-margin w3-container">
		<h2 class="w3-center">Airport Data</h2>
		<table class="w3-table-all w3-hoverable w3-centered">
			
			<tr>
				<th>Airport ID</th>
				<th>Country</th>
				<th>City</th>
				<th>Airport Name</th>
				<th>Airport Type</th>
				<th>Total Runways</th>
				<th>Total Terminals</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			
			<%
				
				//Iterate through the airports from the ArrayList and print out in the table
				
				for(Airport a : airportList) {
					
					out.print("<tr>");
					
					out.print("<td>" + a.getId() + "</td>");
					out.print("<td>" + a.getCountry() + "</td>");
					out.print("<td>" + a.getCity() + "</td>");
					out.print("<td>" + a.getAirport_name() + "</td>");
					out.print("<td>" + a.getAirport_type() + "</td>");
					out.print("<td>" + String.valueOf(a.getTotal_runways()) + "</td>");
					out.print("<td>" + String.valueOf(a.getTotal_terminals()) + "</td>");
					
					out.print("<td><a href=\"editAirport.jsp?id=" + a.getId() + "\" TARGET=\new\">Edit</a></td>");
					out.print("<td><a href=\"AirportService?action=delete&id=" + a.getId() + "\" TARGET=\"new\">Delete</a></td>");
					
					out.print("</tr>");
					
				}
			
			%>
			
		</table>
		
		<hr>
		
		<p>Create a <a href="createAirport.jsp" TARGET="_new"> new Airport.</a></p>
		
	</div>

</body>
</html>