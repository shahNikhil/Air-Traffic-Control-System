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

	<h1>Create Pilot</h1>

	<form method="POST" action="PilotService">
		<table class="table">

			<tr>
				<td>First Name</td>
				<td><input type="text" name="first_name" value="" /></td>
			</tr>

			<tr>
				<td>Last Name</td>
				<td><input type="text" name="last_name" value="" /></td>
			</tr>
			
			<tr>
				<td>Age</td>
				<td><input type="number" name="age" value="" /></td>
			</tr>

			<tr>
				<td>Gender</td>
				<td><input type="text" name="gender" value="" /></td>
			</tr>

			<tr>
				<td>Nationality</td>
				<td><input type="text" name="nationality" value="" /></td>
			</tr>
			
			<tr>
				<td>Training Level</td>
				<td><input type="number" name="training_level" value="" /></td>
			</tr>

		</table>

		<input type="hidden" name="action" value="create" /> <input
			type="submit" method="post" action="/PilotService" />

	</form>

</body>
</html>