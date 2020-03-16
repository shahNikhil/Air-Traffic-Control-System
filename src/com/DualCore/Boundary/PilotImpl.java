package com.DualCore.Boundary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.DualCore.Entity.Pilot;
/**
 * 	The DAO for Pilot Model which talks to the SQL
 */
public class PilotImpl implements IPilot{

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

	//create a new Pilot
	@Override
	public int newPilot(Pilot p) {
		int newPilotId = 0;

		try {

			//Connect to the Database
			connectDB();

			//prepare a string query to fire it over the database
			String sql = "INSERT INTO pilot (first_name, last_name, age, gender, nationality, training_level)"
					+ " Values ('" + p.getFirst_name() + "','" + p.getLast_name() + "','" + p.getAge() + "','" + p.getGender() + "','" + p.getNationality() +
					"','" + p.getTraining_level() + "');";

			//Create the statement
			this.stmt = this.conn.createStatement();

			//Execute the statement
			newPilotId = stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

			//Disconnect from the Database
			disconnectDB();

		}

		catch(SQLException sx) {
			System.out.println(sx.getMessage());
		}

		System.out.println("Inserted a new Pilot with ID: " + newPilotId);

		return newPilotId;
	}

	//delete a Pilot
	@Override
	public void deletePilot(int id) {
		try {

			connectDB();

			//Query
			String sql = "DELETE FROM pilot WHERE id=?";

			this.pstmt = this.conn.prepareStatement(sql);

			//set the parameters for query
			this.pstmt.setInt(1, id);

			//execute the query
			this.pstmt.executeUpdate();

			System.out.println("Deleted Pilot with id: " + id);

			disconnectDB();

		}
		catch(SQLException sx) {
			System.out.println(sx.getMessage());
		}

	}

	//something like select * from pilot
	@Override
	public ArrayList<Pilot> showPilots() {
		ArrayList<Pilot> allPilots = new ArrayList<Pilot>();

		//Query
		String sql = "SELECT * FROM pilot";

		try {

			connectDB();

			//create the statement
			this.stmt = this.conn.createStatement();

			//execute the statement
			this.rs = this.stmt.executeQuery(sql);

			//walk through the ResultSet and append all the pilots to the ArrayList

			while(this.rs.next()) {

				//create a new student object
				Pilot p = new Pilot();
				p.setId(rs.getInt("id"));
				p.setFirst_name(rs.getString("first_name"));
				p.setLast_name(rs.getString("last_name"));
				p.setAge(rs.getInt("age"));
				p.setGender(rs.getString("gender"));
				p.setNationality(rs.getString("nationality"));
				p.setTraining_level(rs.getInt("training_level"));

				//add the students to the ArrayList
				allPilots.add(p);

			}

			disconnectDB();

		}
		catch(SQLException sx) {
			System.out.println(sx.getMessage());
		}

		System.out.println("Listed " + allPilots.size() + " Pilots.");

		//return the ArrayList
		return allPilots;
	}

	//retrieve a single Pilot
	@Override
	public Pilot getPilot(int id) {
		//create a new empty Pilot object
		Pilot getP = new Pilot();

		//Query
		String sql = "SELECT * FROM pilot WHERE id=?";

		try {

			connectDB();

			//create the statement
			this.pstmt = this.conn.prepareStatement(sql);

			//set the parameters for the statement
			this.pstmt.setInt(1, id);

			//execute the statement
			this.rs = this.pstmt.executeQuery();

			while(this.rs.next()) {
				getP.setId(rs.getInt("id"));
				getP.setFirst_name(rs.getString("first_name"));
				getP.setLast_name(rs.getString("last_name"));
				getP.setAge(rs.getInt("age"));
				getP.setGender(rs.getString("gender"));
				getP.setNationality(rs.getString("nationality"));
				getP.setTraining_level(rs.getInt("training_level"));
			}

		}

		catch(SQLException sx) {
			System.out.println(sx.getMessage());
		}

		finally {
			disconnectDB();
		}

		//return the single pilot data
		return getP;
	}

	//update any pilot in the database
	@Override
	public void updatePilot(Pilot up) {
		//Query
		String sql = "UPDATE pilot SET " + 
				"first_name = ?, " + 
				"last_name = ?, " +
				"age = ?," +
				"gender = ?, " + 
				"nationality = ?," +
				"training_level = ? " + 
				"WHERE id = ?";

		try {

			connectDB();

			//create the statement
			this.pstmt = this.conn.prepareStatement(sql);

			//set the parameters for the statement
			this.pstmt.setString(1, up.getFirst_name());
			this.pstmt.setString(2, up.getLast_name());
			this.pstmt.setInt(3, up.getAge());
			this.pstmt.setString(4, up.getGender());
			this.pstmt.setString(5, up.getNationality());
			this.pstmt.setInt(6, up.getTraining_level());
			this.pstmt.setInt(7, up.getId());

			//execute the statement
			this.pstmt.executeUpdate();

			System.out.println("Updated Pilot with an ID: " + up.getId());

			disconnectDB();

		}

		catch(SQLException sx) {
			System.out.println(sx.getMessage());
		}


	}

}