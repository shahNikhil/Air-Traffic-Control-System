package com.DualCore.Boundary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.DualCore.Entity.Airport;
/**
 * 	Back-end for the Airport model
 */
public class AirportImpl implements IAirport {

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

	//create a new Airport
	@Override
	public int newAirport(Airport a) {

		int newAirportId = 0;

		try {

			//Connect to the Database
			connectDB();

			//prepare a string query to fire it over the database
			String sql = "INSERT INTO airport (country, city, airport_name, airport_type, total_runways, total_terminals)"
					+ " Values ('" + a.getCountry() + "','" + a.getCity() + "','" + a.getAirport_name() + "','" + a.getAirport_type() + "','" + a.getTotal_runways() +
					"','" + a.getTotal_terminals() + "');";

			//Create the statement
			this.stmt = this.conn.createStatement();

			//Execute the statement
			newAirportId = stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

			//Disconnect from the Database
			disconnectDB();

		}

		catch(SQLException sx) {
			System.out.println(sx.getMessage());
		}

		System.out.println("Inserted a new Airport with ID: " + newAirportId);

		return newAirportId;
	}

	//delete an airport
	@Override
	public void deleteAirport(int id) {
		try {

			connectDB();

			//Query
			String sql = "DELETE FROM airport WHERE id=?";

			this.pstmt = this.conn.prepareStatement(sql);

			//set the parameters for query
			this.pstmt.setInt(1, id);

			//execute the query
			this.pstmt.executeUpdate();

			System.out.println("Deleted Airport with id: " + id);

			disconnectDB();

		}
		catch(SQLException sx) {
			System.out.println(sx.getMessage());
		}

	}

	//something like select * from
	@Override
	public ArrayList<Airport> showAirports() {
		ArrayList<Airport> allAirports = new ArrayList<Airport>();

		//Query
		String sql = "SELECT * FROM airport";

		try {

			connectDB();

			//create the statement
			this.stmt = this.conn.createStatement();

			//execute the statement
			this.rs = this.stmt.executeQuery(sql);

			//walk through the ResultSet and append all the airports to the ArrayList

			while(this.rs.next()) {

				//create a new airport object
				Airport a = new Airport();

				a.setId(rs.getInt("id"));
				a.setCountry(rs.getString("country"));
				a.setCity(rs.getString("city"));
				a.setAirport_name(rs.getString("airport_name"));
				a.setAirport_type(rs.getString("airport_type"));
				a.setTotal_runways(rs.getInt("total_runways"));
				a.setTotal_terminals(rs.getInt("total_terminals"));

				//add the airports to the ArrayList
				allAirports.add(a);

			}

			disconnectDB();

		}
		catch(SQLException sx) {
			System.out.println(sx.getMessage());
		}

		System.out.println("Listed " + allAirports.size() + " Airports.");

		//return the ArrayList
		return allAirports;
	}

	//retrieve a single object
	@Override
	public Airport getAirport(int id) {
		//create a new empty Airport object
		Airport getA = new Airport();

		//Query
		String sql = "SELECT * FROM airport WHERE id=?";

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
				getA.setCountry(rs.getString("country"));
				getA.setCity(rs.getString("city"));
				getA.setAirport_name(rs.getString("airport_name"));
				getA.setAirport_type(rs.getString("airport_type"));
				getA.setTotal_runways(rs.getInt("total_runways"));
				getA.setTotal_terminals(rs.getInt("total_terminals"));
			}

		}

		catch(SQLException sx) {
			System.out.println(sx.getMessage());
		}

		finally {
			disconnectDB();
		}

		//return the single airport data
		return getA;
	}

	//update any airport in the database
	@Override
	public void updateAirport(Airport ua) {
		//Query
		String sql = "UPDATE airport SET " + 
				"country = ?, " + 
				"city = ?, " +
				"airport_name = ?, " +
				"airport_type = ?, " + 
				"total_runways = ?, " +
				"total_terminals = ? " + 
				"WHERE id = ?";

		try {

			connectDB();

			//create the statement
			this.pstmt = this.conn.prepareStatement(sql);

			//set the parameters for the statement
			this.pstmt.setString(1, ua.getCountry());
			this.pstmt.setString(2, ua.getCity());
			this.pstmt.setString(3, ua.getAirport_name());
			this.pstmt.setString(4, ua.getAirport_type());
			this.pstmt.setInt(5, ua.getTotal_runways());
			this.pstmt.setInt(6, ua.getTotal_terminals());
			this.pstmt.setInt(7, ua.getId());

			//execute the statement
			this.pstmt.executeUpdate();

			System.out.println("Updated Airport with an ID: " + ua.getId());

			disconnectDB();

		}

		catch(SQLException sx) {
			System.out.println(sx.getMessage());
		}

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