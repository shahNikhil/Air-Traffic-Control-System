<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<title>Insert title here</title>
</head>
<body>

	<h1>Create Airport</h1>

	<form method="POST" action="AirportService">
		<table class="table">

			<tr>
				<td>Country</td>
				<td><input type="text" name="country" value="" /></td>
			</tr>

			<tr>
				<td>City</td>
				<td><input type="text" name="city" value="" /></td>
			</tr>
			
			<tr>
				<td>Airport Name</td>
				<td><input type="text" name="airport_name" value="" /></td>
			</tr>

			<tr>
				<td>Airport Type</td>
				<td><input type="text" name="airport_type" value="" /></td>
			</tr>

			<tr>
				<td>Total Runways</td>
				<td><input type="number" name="total_runways" value="" /></td>
			</tr>
			
			<tr>
				<td>Total Terminals</td>
				<td><input type="number" name="total_terminals" value="" /></td>
			</tr>

		</table>

		<input type="hidden" name="action" value="create" /> <input
			type="submit" method="post" action="/AirportService" />

	</form>

</body>
</html>