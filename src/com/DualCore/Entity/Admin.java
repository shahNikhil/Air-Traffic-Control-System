package com.DualCore.Entity;

public class Admin {

	//Attributes required for authenticating the Admin.
	private String _username;
	private String _password;
	
	//parameterized constructor
	public Admin(String username,String password) {
		_username = username;
		_password = password;
	}
	
	//generating the required getters
	public String get_username() {
		return _username;
	}

	public String get_password() {
		return _password;
	}
	
}