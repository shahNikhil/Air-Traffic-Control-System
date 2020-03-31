package com.DualCore.Boundary;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.DualCore.Entity.Flight;

/**
 * 	The DAO for Flight Model which talks to the SQL
 */
public class FlightImpl implements IFlight {

	public String dsn = "jdbc:mysql://localhost:3306/dualcore";
	public String username = "root";
	public String password = "";

	private Connection conn = null;
	private ResultSet rs = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;

	//Database connection method
	public void connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			this.conn = DriverManager.getConnection(this.dsn, this.username, this.password);

			if(this.conn.isClosed()) {
				System.out.println("Database connection was not established.");
			}
			else {
				System.out.println("Database connection established.");
			}
		}
		catch(SQLException sx) {
			System.out.println(sx.getMessage());
		}
	}

	//Database disconnection method
	public void disconnectDB() {
		try {
			if(!(conn == null)) {

				this.conn.close();

				if(this.conn.isClosed()) {
					System.out.println("Database connection is closed.");
				}
				else {
					System.out.println("Database connection is still open!.");
				}
			}

		}
		catch(SQLException sx) {
			System.out.println(sx.getMessage());
		}
	}

	//CRUD Operations

	//create a new Flight
	@Override
	public int newFlight(Flight f) {

		int newFlightId = 0;

		try {

			//Connect to the Database
			connectDB();

			//prepare a string query to fire it over the database
			String sql = "INSERT INTO flight (pilot_name, dep_airport, arr_airport, manufacturer,flight_name,date,scheduled_time,delayed_by,priority)"
					+ " values ('" + f.getPilot_name() + "','" + f.getDep_airport() + "','" + f.getArr_airport() + "','" + f.getManufacturer() + "','" + f.getFlight_name() + "','" + f.getDate() + "','" + f.getScheduled_time() + "','" + f.getDelayed_by() + "','" + f.getPriority()
					+ "');";

			//Create the statement
			this.stmt = this.conn.createStatement();

			//Execute the statement
			newFlightId = stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

			//Disconnect from the Database
			disconnectDB();

		}

		catch(SQLException sx) {
			System.out.println(sx.getMessage());
		}

		System.out.println("Inserted a new Flight with ID: " + newFlightId);

		return newFlightId;
	}

	//delete an flight
	@Override
	public void deleteFlight(int id) {
		try {

			connectDB();

			//Query
			String sql = "DELETE FROM flight WHERE id=?";

			this.pstmt = this.conn.prepareStatement(sql);

			//set the parameters for query
			this.pstmt.setInt(1, id);

			//execute the query
			this.pstmt.executeUpdate();

			System.out.println("Deleted Flight with id: " + id);

			disconnectDB();

		}
		catch(SQLException sx) {
			System.out.println(sx.getMessage());
		}

	}

	//something like select * from
	@Override
	public ArrayList<Flight> showFlights() {
		ArrayList<Flight> allFlights = new ArrayList<Flight>();

		//Query
		String sql = "SELECT * FROM flight";

		try {

			connectDB();

			//create the statement
			this.stmt = this.conn.createStatement();

			//execute the statement
			this.rs = this.stmt.executeQuery(sql);

			//walk through the ResultSet and append all the flights to the ArrayList

			while(this.rs.next()) {

				//create a new Flight object
				Flight a = new Flight();

				a.setId(rs.getInt("id"));
				a.setPilot_name(rs.getString("pilot_name"));
				a.setDep_airport(rs.getString("dep_airport"));
				a.setArr_airport(rs.getString("arr_airport"));
				a.setManufacturer(rs.getString("manufacturer"));
				a.setFlight_name(rs.getString("flight_name"));
				a.setDate(rs.getString("date"));
				a.setScheduled_time(rs.getString("scheduled_time"));
				a.setDelayed_by(rs.getInt("delayed_by"));
				a.setPriority(rs.getInt("priority"));
				//add the Flights to the ArrayList
				allFlights.add(a);

			}

			disconnectDB();

		}
		catch(SQLException sx) {
			System.out.println(sx.getMessage());
		}

		System.out.println("Listed " + allFlights.size() + " Flights.");

		//return the ArrayList
		return allFlights;
	}

	//retrieve a single object
	@Override
	public Flight getFlight(int id) {
		//create a new empty Flight object
		Flight getA = new Flight();

		//Query
		String sql = "SELECT * FROM flight WHERE id=?";

		try {

			connectDB();

			//create the statement
			this.pstmt = this.conn.prepareStatement(sql);

			//set the parameters for the statement
			this.pstmt.setInt(1, id);

			//execute the statement
			this.rs = this.pstmt.executeQuery();

			while(this.rs.next()) {

				getA.setId(rs.getInt("id"));
				getA.setPilot_name(rs.getString("pilot_name"));
				getA.setDep_airport(rs.getString("dep_airport"));
				getA.setArr_airport(rs.getString("arr_airport"));
				getA.setManufacturer(rs.getString("manufacturer"));
				getA.setFlight_name(rs.getString("flight_name"));
				getA.setDate(rs.getString("date"));
				getA.setScheduled_time(rs.getString("scheduled_time"));
				getA.setDelayed_by(rs.getInt("delayed_by"));
				getA.setPriority(rs.getInt("priority"));
			}

		}

		catch(SQLException sx) {
			System.out.println(sx.getMessage());
		}

		finally {
			disconnectDB();
		}

		//return the single flight data
		return getA;
	}

	//update any flight in the database
	@Override
	public void updateFlight(Flight ua) {
		//Query
		String sql = "UPDATE flight SET " + 
				"pilot_name = ?, " +
				"dep_airport = ?, " +
				"arr_airport = ?, " + 
				"manufacturer = ?, " +
				"flight_name = ?, " +
				"date = ?, " +
				"scheduled_time = ?, " +
				"delayed_by = ?, " +
				"priority = ? " + 
				"WHERE id = ?";

		try {

			connectDB();

			//create the statement
			this.pstmt = this.conn.prepareStatement(sql);

			//set the parameters for the statement
			this.pstmt.setString(1, ua.getPilot_name());
			this.pstmt.setString(2, ua.getDep_airport());
			this.pstmt.setString(3, ua.getArr_airport());
			this.pstmt.setString(4, ua.getManufacturer());
			this.pstmt.setString(5, ua.getFlight_name());
			this.pstmt.setString(6, ua.getDate());
			this.pstmt.setString(7, ua.getScheduled_time());
			this.pstmt.setInt(8, ua.getDelayed_by());
			this.pstmt.setInt(9, ua.getPriority());
			this.pstmt.setInt(10, ua.getId());

			//execute the statement
			this.pstmt.executeUpdate();

			System.out.println("Updated Flight with an ID: " + ua.getId());

			disconnectDB();

		}

		catch(SQLException sx) {
			System.out.println(sx.getMessage());
		}

	}

	//Filter flights by
	public ArrayList<Flight> showFlightsFilter(String f) {


		ArrayList<Flight> allFlights = new ArrayList<Flight>();

		//Query
		String sql = "SELECT * FROM flight where flight_name = ?";

		try {

			connectDB();

			//create the statement
			this.pstmt = this.conn.prepareStatement(sql);

			//set the parameters for the statement
			this.pstmt.setString(1, f);

			//walk through the ResultSet and append all the flights to the ArrayList

			while(this.rs.next()) {

				//create a new Flight object
				Flight a = new Flight();

				a.setId(this.rs.getInt("id"));
				a.setPilot_name(this.rs.getString("pilot_name"));
				a.setDep_airport(this.rs.getString("dep_airport"));
				a.setArr_airport(this.rs.getString("arr_airport"));
				a.setManufacturer(this.rs.getString("manufacturer"));
				a.setFlight_name(this.rs.getString("flight_name"));
				a.setDate(this.rs.getString("date"));
				a.setScheduled_time(this.rs.getString("scheduled_time"));
				a.setDelayed_by(this.rs.getInt("delayed_by"));
				a.setPriority(this.rs.getInt("priority"));
				//add the Flights to the ArrayList
				allFlights.add(a);

			}

			disconnectDB();

		}
		catch(SQLException sx) {
			System.out.println(sx.getMessage());
		}

		
		
		//return the ArrayList
		return allFlights;
		
	}
	

	//setters for Database connection's attributes
	public void setDsn(String dsn) {
		this.dsn = dsn;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}