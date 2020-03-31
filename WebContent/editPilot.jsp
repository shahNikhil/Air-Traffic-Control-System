<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%--This is the jsp page if the admin wants to edit any current Pilot --%>	

<%@ page import="com.DualCore.Entity.*"%>
<%@ page import="com.DualCore.Boundary.*"%>
<%@ page import="com.DualCore.Controller.*"%>
<%
	String error = "";
	Pilot editP = new Pilot();

	PilotImpl pilotDAO = new PilotImpl();
	editP = pilotDAO.getPilot(Integer.parseInt(request.getParameter("id")));
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<title>Edit Pilot</title>
</head>
<body>

	<h1>Edit Pilot</h1>

	<form method="POST" action="PilotService">

		<table class="w3-table">

			<tr>
				<td>First Name</td>
				<td><input type="text" name="first_name"
					value="<%out.print(editP.getFirst_name());%>" /></td>
			</tr>

			<tr>
				<td>Last Name</td>
				<td><input type="text" name="last_name"
					value="<%out.print(editP.getLast_name());%>" /></td>
			</tr>
			
			<tr>
				<td>Age</td>
				<td><input type="number" name="age"
					value="<%out.print(editP.getAge());%>" /></td>
			</tr>

			<tr>
				<td>Gender</td>
				<td><input type="text" name="gender"
					value="<%out.print(editP.getGender());%>" /></td>
			</tr>

			<tr>
				<td>Nationality</td>
				<td><input type="text" name="nationality"
					value="<%out.print(editP.getNationality());%>" /></td>
			</tr>
			
			<tr>
				<td>Training Level</td>
				<td><input type="number" name="training_level"
					value="<%out.print(editP.getTraining_level());%>" /></td>
			</tr>

		</table>

		<input type="hidden" name="id"
			value="<%out.print(editP.getId());%>" /> <input type="hidden"
			name="action" value="edit" /> <input type="submit" method="post"
			action="/PilotService" />

	</form>

</body>
</html>