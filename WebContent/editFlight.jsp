<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%--This is the jsp page if the admin wants to edit any current Flight --%>	
<%@ page import="java.util.*"%>
<%@ page import="com.DualCore.Entity.*"%>
<%@ page import="com.DualCore.Boundary.*"%>
<%@ page import="com.DualCore.Controller.*"%>

<%
	String error = "";
	Flight editA = new Flight();

	FlightImpl flighttDAO = new FlightImpl();
	editA = flighttDAO.getFlight(Integer.parseInt(request.getParameter("id")));
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<title>Edit Flight</title>
</head>
<body>

	<h1>Edit Flight</h1>

	<form method="POST" action="FlightService">

		<table class="w3-table">

			<tr>
			<td>Pilot Name</td>
			<td><select id="pilot_name" name="pilot_name" value="<%out.print(editA.getPilot_name());%>">
			
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
				<td><select id="dep_airport" name="dep_airport" value="<%out.print(editA.getDep_airport());%>">
			
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
				<td><select id="arr_airport" name="arr_airport" value="<%out.print(editA.getArr_airport());%>">
			
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
			<td><select id="manufacturer" name="manufacturer" value="<%out.print(editA.getManufacturer());%>">
			
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
				<td><input type="text" name="flight_name" value="<%out.print(editA.getFlight_name());%>" /></td>
			</tr>
			<tr>
				<td>Date</td>
				<td><input type="text" name="date" value="<%out.print(editA.getDate());%>" /></td>
			</tr>
			<tr>
				<td>Scheduled Time</td>
				<td><input type="text" name="scheduled_time" value="<%out.print(editA.getScheduled_time());%>" /></td>
			</tr>
			<tr>
				<td>Delayed By</td>
				<td><input type="number" name="delayed_by" value="<%out.print(editA.getDelayed_by());%>" /></td>
			</tr>
			<tr>
				<td>Priority</td>
				<td><input type="number" name="priority" value="<%out.print(editA.getPriority());%>" /></td>
			</tr>

		</table>

		<input type="hidden" name="id"
			value="<%out.print(editA.getId());%>" /> <input type="hidden"
			name="action" value="edit" /> <input type="submit" method="post"
			action="FlightService" />

	</form>

</body>
</html>