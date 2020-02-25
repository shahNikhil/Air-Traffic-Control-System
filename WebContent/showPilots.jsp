<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.*"%>

<%@ page import="com.DualCore.Entity.*"%>
<%@ page import="com.DualCore.Boundary.*"%>

<%

	PilotImpl pilotDAO = new PilotImpl();
	ArrayList<Pilot> pilotList = new ArrayList<Pilot>();
	
	pilotList = pilotDAO.showPilots();

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
			class="w3-bar-item w3-button w3-mobile">Airports</a> <a href="#"
			class="w3-bar-item w3-button w3-right w3-mobile"><i
			class="w3-xlarge material-icons">person</i></a>
	</div>

	<div class="w3-margin w3-container">
		<h2 class="w3-center">Pilot Data</h2>
		<table class="w3-table-all w3-hoverable w3-centered">
			
			<tr>
				<th>Pilot ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
				<th>Gender</th>
				<th>Nationality</th>
				<th>Training Level</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			
			<%
				
				//Iterate through the pilots from the ArrayList and print out in the table
				
				for(Pilot p : pilotList) {
					
					out.print("<tr>");
					
					out.print("<td>" + p.getId() + "</td>");
					out.print("<td>" + p.getFirst_name() + "</td>");
					out.print("<td>" + p.getLast_name() + "</td>");
					out.print("<td>" + String.valueOf(p.getAge()) + "</td>");
					out.print("<td>" + p.getGender() + "</td>");
					out.print("<td>" + p.getNationality() + "</td>");
					out.print("<td>" + String.valueOf(p.getTraining_level()) + "</td>");
					
					out.print("<td><a href=\"editPilot.jsp?id=" + p.getId() + "\" TARGET=\new\">Edit</a></td>");
					out.print("<td><a href=\"PilotService?action=delete&id=" + p.getId() + "\" TARGET=\"new\">Delete</a></td>");
					
					out.print("</tr>");
					
				}
			
			%>
			
		</table>
		
		<hr>
		
		<p>Create a <a href="createPilot.jsp" TARGET="_new"> new Pilot.</a></p>
		
	</div>

</body>
</html>
