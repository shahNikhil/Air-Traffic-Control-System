package com.DualCore.Entity;

/**
 * The is an Entity class for Pilot Model
 */

public class Pilot {

	private int id = 0;
	private String first_name = "";
	private String last_name = "";
	private int age = 0;
	private String gender = "";
	private String nationality = "";
	private int training_level = 0;
	
	//getters and setters
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirst_name() {
		return first_name;
	}
	
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLast_name() {
		return last_name;
	}
	
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getNationality() {
		return nationality;
	}
	
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	public int getTraining_level() {
		return training_level;
	}
	
	public void setTraining_level(int training_level) {
		this.training_level = training_level;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Pilot ID: " + this.getId() + "\n");
		sb.append("Pilot First Name: " + this.getFirst_name() + "\n");
		sb.append("Pilot Last Name: " + this.getLast_name() + "\n");
		sb.append("Pilot Age: " + this.getAge() + "\n");
		sb.append("Pilot Gender: " + this.getGender() + "\n");
		sb.append("Pilot Nationality: " + this.getNationality() + "\n");
		sb.append("Pilot Training Level: " + this.getTraining_level() + "\n");
		
		return sb.toString();
	}
	
	
	
}
