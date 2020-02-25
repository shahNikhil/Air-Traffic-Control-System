package com.DualCore.Entity;
/**
 * Stores all the attributes for the Airport model
 */
public class Airport {
	
	private int id = 0;
	private String country = "";
	private String city = "";
	private String airport_name = "";
	private String airport_type= "";
	private int total_runways = 0;
	private int total_terminals = 0;
	
	//getters and setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getAirport_name() {
		return airport_name;
	}
	
	public void setAirport_name(String airport_name) {
		this.airport_name = airport_name;
	}
	
	public String getAirport_type() {
		return airport_type;
	}
	
	public void setAirport_type(String airport_type) {
		this.airport_type = airport_type;
	}
	
	public int getTotal_runways() {
		return total_runways;
	}
	
	public void setTotal_runways(int total_runways) {
		this.total_runways = total_runways;
	}
	
	public int getTotal_terminals() {
		return total_terminals;
	}
	
	public void setTotal_terminals(int total_terminals) {
		this.total_terminals = total_terminals;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Airport ID: " + this.getId() + "\n");
		sb.append("Airport Country: " + this.getCountry() + "\n");
		sb.append("Airport City: " + this.getCity() + "\n");
		sb.append("Airport Name: " + this.getAirport_name() + "\n");
		sb.append("Airport Type: " + this.getAirport_type() + "\n");
		sb.append("Airport Total Runways: " + this.getTotal_runways() + "\n");
		sb.append("Airport Total Terminals: " + this.getTotal_terminals() + "\n");
		
		return sb.toString();
	}

}