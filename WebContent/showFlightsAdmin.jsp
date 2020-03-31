<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%--This is the jsp page to show all the Flights to admin along with CRUD functionality --%>		

<%@ page import="java.util.*"%>

<%@ page import="com.DualCore.Entity.*"%>
<%@ page import="com.DualCore.Boundary.*"%>

<%

	FlightImpl flightDAO = new FlightImpl();
	ArrayList<Flight> flightList = new ArrayList<Flight>();
	
	flightList = flightDAO.showFlights();

%>

<!DOCTYPE html>
<html>
<title>Show Flights</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<body>

	<div class="w3-bar w3-black w3-large">
		<a href="adminPanel.jsp" class="w3-bar-item w3-button w3-mobile"><i
			class="w3-xlarge material-icons">home</i></a> <a
			href="showFlightsAdmin.jsp" class="w3-bar-item w3-button w3-mobile">Flights</a>
		<a href="showAirportsAdmin.jsp" class="w3-bar-item w3-button w3-mobile">Airports</a> <a
			href="showAircraftsAdmin.jsp" class="w3-bar-item w3-button w3-mobile">Aircrafts</a>
		<a href="index.jsp" class="w3-bar-item w3-button w3-right w3-mobile"><i
			class="w3-xlarge material-icons">exit_to_app</i></a>
	</div>

	<div class="w3-margin w3-container">
		<h2 class="w3-center">Flight Data</h2>
		<table class="w3-table-all w3-hoverable w3-centered">
		
			<tr>
				<th>Flight ID</th>
				<th>Pilot Name</th>
				<th>Departure Airport</th>
				<th>Arrival Airport</th>
				<th>Manufacturer</th>
				<th>Flight Name</th>
				<th>date </th>
				<th>Scheduled Time</th>
				<th>Delayed By</th>
				<th>Priority</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			
			<%
				
				//Iterate through the flights from the ArrayList and print out in the table
				
				for(Flight p : flightList) {
					
					out.print("<tr>");
				
					out.print("<td>" + p.getId() + "</td>");
					out.print("<td>" + p.getPilot_name() + "</td>");
					out.print("<td>" + p.getDep_airport() + "</td>");
					out.print("<td>" + p.getArr_airport() + "</td>");
					out.print("<td>" + p.getManufacturer() + "</td>");
					out.print("<td>" + p.getFlight_name() + "</td>");
					out.print("<td>" + p.getDate() + "</td>");
					out.print("<td>" + p.getScheduled_time() + "</td>");
					out.print("<td>" + String.valueOf(p.getDelayed_by()) + "</td>");
					out.print("<td>" + String.valueOf(p.getPriority()) + "</td>");
					
					out.print("<td><a href=\"editFlight.jsp?id=" + p.getId() + "\" TARGET=\new\">Edit</a></td>");
					out.print("<td><a href=\"FlightService?action=delete&id=" + p.getId() + "\" TARGET=\"new\">Delete</a></td>");
					
					out.print("</tr>");
					
				}
			
			%>
			
		</table>
		
		<hr>
		
		<p>Create a <a href="createFlight.jsp" TARGET="_new"> new Flight.</a></p>
		
	</div>

</body>
</html>
