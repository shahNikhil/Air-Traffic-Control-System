<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<title>W3.CSS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<body>

<style>
.loginLinks :hover {
	background-color: gainsboro;
}
</style>

<div class="w3-bar w3-black w3-large">
  <a href="#" class="w3-bar-item w3-button w3-mobile"><i class="w3-xlarge material-icons">home</i></a>
  <a href="#" class="w3-bar-item w3-button w3-mobile">Pilots</a>
  <a href="#" class="w3-bar-item w3-button w3-mobile">Airports</a>
  <a href="#" class="w3-bar-item w3-button w3-right w3-mobile"><i class="w3-xlarge material-icons">person</i></a>
</div>

<div class="w3-section w3-container">
	<h2 class="w3-center">Please Sign In First!</h2>
	<div class="w3-row w3-row-padding">
    	<a href="#">
    	<div class="loginLinks w3-col l6 m6 s6 w3-center">
        	<div class="w3-card-2 w3-round-large w3-margin">
            	<div class="w3-margin">
            		<i class="w3-jumbo w3-text-grey w3-margin material-icons">person</i>
                    <h3 class="w3-text-grey">Guest</h3>
            	</div>
            </div>
        </div>
        </a>
        <a href="#">
        <div class="loginLinks w3-col l6 m6 s6 w3-center">
        	<div class=" w3-card-2 w3-round-large w3-margin">
            	<div class="w3-margin">
            		<i class="w3-jumbo w3-text-green w3-margin material-icons">build</i>
                    <h3 class="w3-text-green">Admin</h3>
            	</div>
            </div>
        </div> 
        </a>
    </div>
</div>

</body>
</html>