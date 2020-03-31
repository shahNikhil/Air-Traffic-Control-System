<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
	String driver = "com.mysql.jdbc.Driver";
	String connectionUrl = "jdbc:mysql://localhost:3306/";
	String database = "dualcore";
	String userid = "root";
	String password = "";
	String flight_Name = request.getParameter("flight_name");
	try {
		Class.forName(driver);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>

	<div class="w3-container">

		<h2 class="w3-center">Flight Data</h2>

		<table class="w3-table-all">
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
				try {
					connection = DriverManager.getConnection(connectionUrl + database, userid, password);
					statement = connection.createStatement();
					String sql = "select * from flight where flight_name like '%" + flight_Name + "%' ";

					resultSet = statement.executeQuery(sql);
					while (resultSet.next()) {
			%>
			<tr>
				<td><%=resultSet.getString("id")%></td>
				<td><%=resultSet.getString("pilot_name")%></td>
				<td><%=resultSet.getString("dep_airport")%></td>
				<td><%=resultSet.getString("arr_airport")%></td>
				<td><%=resultSet.getString("manufacturer")%></td>
				<td><%=resultSet.getString("flight_name")%></td>
				<td><%=resultSet.getString("date")%></td>
				<td><%=resultSet.getString("scheduled_time")%></td>
				<td><%=resultSet.getString("delayed_by")%></td>
				<td><%=resultSet.getString("priority")%></td>
			</tr>
			<%
				}
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			%>
		</table>

	</div>
</body>
</html>