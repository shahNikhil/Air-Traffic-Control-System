package com.DualCore.Boundary;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.DualCore.Entity.Aircraft;

/**
 * 	The DAO for Aircrfat Model which talks to the SQL
 */
public class AircraftImpl implements IAircraft {

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

	//create a new Aircraft
	@Override
	public int newAircraft(Aircraft a) {

		int newAircraftId = 0;

		try {

			//Connect to the Database
			connectDB();

			//prepare a string query to fire it over the database
			String sql = "INSERT INTO aircraft (manufacturer, total_seats, weight_capacity, is_autoPilot, max_speed)"
					+ " values ('" + a.getManufacturer() + "','" + a.getTotal_seats() + "','" + a.getWeight_capacity() + "','" + a.getIs_autoPilot() +
					"','" + a.getMax_speed() + "');";

			//Create the statement
			this.stmt = this.conn.createStatement();

			//Execute the statement
			newAircraftId = stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

			//Disconnect from the Database
			disconnectDB();

		}

		catch(SQLException sx) {
			System.out.println(sx.getMessage());
		}

		System.out.println("Inserted a new Aircraft with ID: " + newAircraftId);

		return newAircraftId;
	}

	//delete an aircraft
	@Override
	public void deleteAircraft(int id) {
		try {

			connectDB();

			//Query
			String sql = "DELETE FROM aircraft WHERE id=?";

			this.pstmt = this.conn.prepareStatement(sql);

			//set the parameters for query
			this.pstmt.setInt(1, id);

			//execute the query
			this.pstmt.executeUpdate();

			System.out.println("Deleted Aircraft with id: " + id);

			disconnectDB();

		}
		catch(SQLException sx) {
			System.out.println(sx.getMessage());
		}

	}

	//something like select * from
	@Override
	public ArrayList<Aircraft> showAircrafts() {
		ArrayList<Aircraft> allAircrafts = new ArrayList<Aircraft>();

		//Query
		String sql = "SELECT * FROM aircraft";

		try {

			connectDB();

			//create the statement
			this.stmt = this.conn.createStatement();

			//execute the statement
			this.rs = this.stmt.executeQuery(sql);

			//walk through the ResultSet and append all the aircrafts to the ArrayList

			while(this.rs.next()) {

				//create a new Aircraft object
				Aircraft a = new Aircraft();

				a.setId(rs.getInt("id"));
				a.setManufacturer(rs.getString("manufacturer"));
				a.setTotal_seats(rs.getString("total_seats"));
				a.setWeight_capacity(rs.getString("weight_capacity"));
				a.setIs_autoPilot(rs.getString("is_autoPilot"));
				a.setMax_speed(rs.getString("max_speed"));
				//add the Aircrafts to the ArrayList
				allAircrafts.add(a);

			}

			disconnectDB();

		}
		catch(SQLException sx) {
			System.out.println(sx.getMessage());
		}

		System.out.println("Listed " + allAircrafts.size() + " Aircrafts.");

		//return the ArrayList
		return allAircrafts;
	}

	//retrieve a single object
	@Override
	public Aircraft getAircraft(int id) {
		//create a new empty Aircraft object
		Aircraft getA = new Aircraft();

		//Query
		String sql = "SELECT * FROM aircraft WHERE id=?";

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
				getA.setManufacturer(rs.getString("manufacturer"));
				getA.setTotal_seats(rs.getString("total_seats"));
				getA.setWeight_capacity(rs.getString("weight_capacity"));
				getA.setIs_autoPilot(rs.getString("is_autoPilot"));
				getA.setMax_speed(rs.getString("max_speed"));
			}

		}

		catch(SQLException sx) {
			System.out.println(sx.getMessage());
		}

		finally {
			disconnectDB();
		}

		//return the single aircraft data
		return getA;
	}

	//update any aircraft in the database
	@Override
	public void updateAircraft(Aircraft ua) {
		//Query
		String sql = "UPDATE aircraft SET " + 
				"manufacturer = ?, " + 
				"total_seats = ?, " +
				"weight_capacity = ?, " +
				"is_autoPilot = ?, " + 
				"max_speed = ? " +
				"WHERE id = ?";

		try {

			connectDB();

			//create the statement
			this.pstmt = this.conn.prepareStatement(sql);

			//set the parameters for the statement
			this.pstmt.setString(1, ua.getManufacturer());
			this.pstmt.setString(2, ua.getTotal_seats());
			this.pstmt.setString(3, ua.getWeight_capacity());
			this.pstmt.setString(4, ua.getIs_autoPilot());
			this.pstmt.setString(5, ua.getMax_speed());
			this.pstmt.setInt(6, ua.getId());

			//execute the statement
			this.pstmt.executeUpdate();

			System.out.println("Updated Aircraft with an ID: " + ua.getId());

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