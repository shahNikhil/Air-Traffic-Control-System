package com.DualCore.Boundary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.DualCore.Entity.Admin;
import com.DualCore.Entity.LoginToken;

public class AuthImpl {

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

	//retrieve a single password
	public LoginToken getAdmin(int id) {

		//create a new empty Admin object
		LoginToken getA = new LoginToken();
		
		//Query
		String sql = "SELECT * FROM admin WHERE id=?";

		try {

			connectDB();

			//create the statement
			this.pstmt = this.conn.prepareStatement(sql);

			//set the parameters for the statement
			this.pstmt.setInt(1, 1);

			//execute the statement
			this.rs = this.pstmt.executeQuery();

			while(this.rs.next()) {
				getA.set_username(rs.getString("username"));
				getA.set_password(rs.getString("password"));
			}

		}

		catch(SQLException sx) {
			System.out.println(sx.getMessage());
		}

		finally {
			disconnectDB();
		}

		//return the password from the database
		return getA;
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