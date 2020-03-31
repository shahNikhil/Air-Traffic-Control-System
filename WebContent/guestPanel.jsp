<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%--This is the jsp page just for the guest to read various data about flights --%>
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
		<a href="adminSignIn.jsp" class="w3-bar-item w3-button w3-mobile"><i
			class="w3-xlarge material-icons">home</i></a> <a href="index.jsp"
			class="w3-bar-item w3-button w3-right w3-mobile"><i
			class="w3-xlarge material-icons">exit_to_app</i></a>
	</div>

	<div class="w3-margin w3-container">
	
	<div class="w3-row-padding">
		<div class="w3-half w3-left-align">
			<h2>Flight Data</h2>
		</div>
		<div class="w3-half w3-right-align w3-margin-top">
			<a href="searchFlight.html"><input class="w3-btn w3-green w3-text-white w3-round-large" type="submit" value="Search Your Flight"></a>
		</div>
	</div>
	
		<table class="w3-table-all w3-hoverable w3-centered">

			<tr>
				<th>Flight ID</th>
				<th>Pilot Name</th>
				<th>Departure Airport</th>
				<th>Arrival Airport</th>
				<th>Manufacturer</th>
				<th>Flight Name</th>
				<th>Date</th>
				<th>Scheduled Time</th>
				<th>Delayed By</th>
				<th>Priority</th>
			</tr>

			<%
				//Iterate through the flights from the ArrayList and print out in the table

				for (Flight p : flightList) {

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

					out.print("</tr>");

				}
			%>

		</table>



	</div>

</body>
</html>