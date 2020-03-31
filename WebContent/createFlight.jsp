<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>

<%@ page import="com.DualCore.Entity.*"%>
<%@ page import="com.DualCore.Boundary.*"%>	
<%--This is the jsp page if the admin wants to create a new Flight --%>		
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<title>Create Flight</title>
</head>
<body>

	<h1>Create Flight</h1>

	<form method="POST" action="FlightService">
		<table class="table">

			<tr>
			<td>Pilot Name</td>
			<td><select id="pilot_name" name="pilot_name">
			
				<%
				PilotImpl pilotDAO = new PilotImpl();
				ArrayList<Pilot> pilotList = new ArrayList<Pilot>();
		
				pilotList = pilotDAO.showPilots();
				for(Pilot p : pilotList) {
				out.print("<option>" + p.getFirst_name() + "</option>");
				}
				%>
				
			</select>
			</td>
			</tr>

			<tr>
				<td>Departure Airport</td>
				<td><select id="dep_airport" name="dep_airport">
			
				<%
				AirportImpl airportDAO = new AirportImpl();
				ArrayList<Airport> airportList = new ArrayList<Airport>();
		
				airportList = airportDAO.showAirports();
				for(Airport p : airportList) {
				out.print("<option>" + p.getAirport_name() + "</option>");
				}
				%>
				
			</select>
			</td>

			</tr>

			<tr>
				<td>Arrival Airport</td>
				<td><select id="arr_airport" name="arr_airport">
			
				<%

				for(Airport p : airportList) {
				out.print("<option>" + p.getAirport_name() + "</option>");
				}
				%>
				
			</select>
			</td>
			</tr>

			<tr>
			<td>Manufacturer</td>
			<td><select id="manufacturer" name="manufacturer">
			
				<%
				AircraftImpl aircraftDAO = new AircraftImpl();
				ArrayList<Aircraft> aircraftList = new ArrayList<Aircraft>();
		
				aircraftList = aircraftDAO.showAircrafts();
				for(Aircraft p : aircraftList) {
				out.print("<option>" + p.getManufacturer() + "</option>");
				}
				%>
				
			</select>
			</td>
			</tr>
			<tr>
				<td>Flight Name</td>
				<td><input type="text" name="flight_name" value="" /></td>
			</tr>
			<tr>
				<td>Date</td>
				<td><input type="text" name="date" value="" /></td>
			</tr>
			<tr>
				<td>Scheduled Time</td>
				<td><input type="text" name="scheduled_time" value="" /></td>
			</tr>
			<tr>
				<td>Delayed By</td>
				<td><input type="number" name="delayed_by" value="" /></td>
			</tr>
			<tr>
				<td>Priority</td>
				<td><input type="number" name="priority" value="" /></td>
			</tr>

		</table>

		<input type="hidden" name="action" value="create" /> <input
			type="submit" method="post" action="/FlightService" />

	</form>

</body>
</html>