package com.DualCore.Boundary;

import java.util.ArrayList;
/**
 * Makes sure that all methods are implemented for the Airport model
 */
import com.DualCore.Entity.Airport;

public interface IAirport {
	
	public int newAirport(Airport a);
	
	public void deleteAirport(int id);
	
	public ArrayList<Airport> showAirports();
	 
	public Airport getAirport(int id);
	
	public void updateAirport(Airport ua);

}