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
<title>Admin Panel</title>
</head>
<body>

	<div class="w3-bar w3-black w3-large">
		<a href="adminPanel.jsp" class="w3-bar-item w3-button w3-mobile"><i
			class="w3-xlarge material-icons">home</i></a> <a
			href="showPilotsAdmin.jsp" class="w3-bar-item w3-button w3-mobile">Pilots</a>
		<a href="showAirportsAdmin.jsp" class="w3-bar-item w3-button w3-mobile">Airports</a> <a
			href="showAircraftsAdmin.jsp" class="w3-bar-item w3-button w3-mobile">Aircrafts</a>
		<a href="index.jsp" class="w3-bar-item w3-button w3-right w3-mobile"><i
			class="w3-xlarge material-icons">exit_to_app</i></a>
	</div>

	<div class="w3-container w3-section">

		<div class="w3-row-padding">
			<div class="w3-third">
				<div class="w3-card-4 w3-round-large w3-row-padding">
					<div class="w3-col l9 m9 s9">
						<h4>Pilot</h4>
					</div>
					<div class="w3-col l3 m3 s3" style="margin-top: 4px;">
						<a href="showPilotsAdmin.jsp"> <i
							class="w3-btn w3-hover-black w3-hover-text-white w3-round-large material-icons">edit</i></a>
					</div>
				</div>
			</div>

			<div class="w3-third">
				<div class="w3-card-4 w3-round-large w3-row-padding">
					<div class="w3-col l9 m9 s9">
						<h4>Airport</h4>
					</div>
					<div class="w3-col l3 m3 s3" style="margin-top: 4px;">
						<a href="showAirportsAdmin.jsp"> <i
							class="w3-btn w3-hover-black w3-hover-text-white w3-round-large material-icons">edit</i></a>
					</div>
				</div>
			</div>

			<div class="w3-third">
				<div class="w3-card-4 w3-round-large w3-row-padding">
					<div class="w3-col l9 m9 s9">
						<h4>Aircraft</h4>
					</div>
					<div class="w3-col l3 m3 s3" style="margin-top: 4px;">
						<a href="showAircraftsAdmin.jsp"> <i
							class="w3-btn w3-hover-black w3-hover-text-white w3-round-large material-icons">edit</i></a>
					</div>
				</div>
			</div>

		</div>

	</div>

</body>
</html>