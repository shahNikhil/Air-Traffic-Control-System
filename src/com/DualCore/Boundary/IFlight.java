package com.DualCore.Boundary;

import java.util.ArrayList;

import com.DualCore.Entity.Flight;

/**
 * Makes sure that all methods are implemented for the Flight model
 */
public interface IFlight {
	public int newFlight(Flight f);
	
	public void deleteFlight(int id);
	
	public ArrayList<Flight> showFlights();
	 
	public Flight getFlight(int id);
	
	public void updateFlight(Flight ua);
}
