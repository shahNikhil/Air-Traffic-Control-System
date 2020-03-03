package com.DualCore.Entity;
/**
 * Stores all the attributes for the Aircraft model
 */
public class Aircraft {
	private int id = 0;
	private String manufacturer = "";
	private String total_seats = "";
	private String weight_capacity = "";
	private String is_autoPilot= "";
	private String max_speed = "";
	
	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getTotal_seats() {
		return total_seats;
	}
	public void setTotal_seats(String total_seats) {
		this.total_seats = total_seats;
	}
	public String getWeight_capacity() {
		return weight_capacity;
	}
	public void setWeight_capacity(String weight_capacity) {
		this.weight_capacity = weight_capacity;
	}
	public String getIs_autoPilot() {
		return is_autoPilot;
	}
	public void setIs_autoPilot(String is_autoPilot) {
		this.is_autoPilot = is_autoPilot;
	}
	public String getMax_speed() {
		return max_speed;
	}
	public void setMax_speed(String max_speed) {
		this.max_speed = max_speed;
	}
	

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Aircraft ID: " + this.getId() + "\n");
		sb.append("Aircraft manufacturer: " + this.getManufacturer() + "\n");
		sb.append("Aircraft Total Seats: " + this.getTotal_seats() + "\n");
		sb.append("Aircraft Weight Capacity: " + this.getWeight_capacity() + "\n");
		sb.append("Aircraft Type: " + this.getIs_autoPilot() + "\n");
		sb.append("Aircraft Max Speed: " + this.getMax_speed() + "\n");
		
		return sb.toString();
	}

}
