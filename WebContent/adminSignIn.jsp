<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%--The login page for admin --%>	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<title>Sign In as an Admin</title>
</head>
<body>

	<div class="w3-container w3-section">
		<div class="w3-card-4 w3-round-large"
			style="max-width: 500px; margin: auto;">
			<h2 class="w3-round-large w3-black w3-center">Sign in as an
				Admin</h2>
			<form class="w3-container" method="post" action="AdminService">
				<p>
					<input placeholder="Username" name="username" class="w3-input" type="text">
				</p>
				<p>
					<input placeholder="Password" name="password" class="w3-input" type="password">
				</p>
				<p class="w3-center">
					<input type="submit" value="Sign In"
						class="w3-btn w3-round-large w3-green">
				</p>
			</form>
		</div>
	</div>

</body>
</html>