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
<title>Create Aircraft</title>
</head>
<body>

	<h1>Create Aircraft</h1>

	<form method="POST" action="AircraftService">
		<table class="table">

			<tr>
				<td>Manufacturer</td>
				<td><input type="text" name="manufacturer" value="" /></td>
			</tr>

			<tr>
				<td>Total Seats</td>
				<td><input type="text" name="total_seats" value="" /></td>
			</tr>
			
			<tr>
				<td>Weight Capacity (in KGs)</td>
				<td><input type="number" name="weight_capacity" value="" /></td>
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
				<td><input type="number" name="max_speed" value="" /></td>
			</tr>

		</table>

		<input type="hidden" name="action" value="create" /> <input
			type="submit" method="post" action="/AircraftService" />

	</form>

</body>
</html>