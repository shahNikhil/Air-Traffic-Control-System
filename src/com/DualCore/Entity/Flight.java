package com.DualCore.Entity;
/**
 * The is an Entity class for Flight Model
 */
public class Flight {
	private int id = 0;
	private String pilot_name = "";
	private String dep_airport = "";
	private String arr_airport = "";
	private String manufacturer = "";
	private String flight_name= "";
	private String date = "";
	private String scheduled_time = "";
	private int delayed_by = 0;
	private int priority = 0;
	
	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPilot_name() {
		return pilot_name;
	}
	public void setPilot_name(String pilot_name) {
		this.pilot_name = pilot_name;
	}
	public String getDep_airport() {
		return dep_airport;
	}
	public void setDep_airport(String dep_airport) {
		this.dep_airport = dep_airport;
	}
	public String getArr_airport() {
		return arr_airport;
	}
	public void setArr_airport(String arr_airport) {
		this.arr_airport = arr_airport;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getFlight_name() {
		return flight_name;
	}
	public void setFlight_name(String flight_name) {
		this.flight_name = flight_name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getScheduled_time() {
		return scheduled_time;
	}
	public void setScheduled_time(String scheduled_time) {
		this.scheduled_time = scheduled_time;
	}
	public int getDelayed_by() {
		return delayed_by;
	}
	public void setDelayed_by(int delayed_by) {
		this.delayed_by = delayed_by;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Flight ID: " + this.getId() + "\n");
		sb.append("Pilot  Name: " + this.getPilot_name() + "\n");
		sb.append("Departure Airport: " + this.getDep_airport() + "\n");
		sb.append("Arrival Airport: " + this.getArr_airport() + "\n");
		sb.append("Manufacturer: " + this.getManufacturer() + "\n");
		sb.append("Flight Name: " + this.getFlight_name() + "\n");
		sb.append("Date: " + this.getDate() + "\n");
		sb.append("Scheduled Time: " + this.getScheduled_time() + "\n");
		sb.append("Delayed By(in hours): " + this.getDelayed_by() + "\n");
		sb.append("Priority: " + this.getPriority() + "\n");
		return sb.toString();
	}

	
}
