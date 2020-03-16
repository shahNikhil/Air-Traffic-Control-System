package com.DualCore.Entity;

/**
 * The is an Entity class for every single login instance as a token
 */

public class LoginToken {
	//attributes to check whether the login token is correct or not
	private String _username;
	private String _password;
	
	//default constructor
	public LoginToken() {
		
	}
	
	//Override the constructor to specify the username and password
	public LoginToken(String username, String password) {
		_username = username;
		_password = password;
	}

	//generating getters and setters to fetch values and verify from the database
	public String get_username() {
		return _username;
	}
	public void set_username(String _username) {
		this._username = _username;
	}
	public String get_password() {
		return _password;
	}
	public void set_password(String _password) {
		this._password = _password;
	}
}