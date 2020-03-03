package com.DualCore.Boundary;
import java.util.ArrayList;

import com.DualCore.Entity.Aircraft;
/**
 * Makes sure that all methods are implemented for the Aircraft model
 */
public interface IAircraft {
	
	public int newAircraft(Aircraft p);
	
	public void deleteAircraft(int id);
	
	public ArrayList<Aircraft> showAircrafts();
	 
	public Aircraft getAircraft(int id);
	
	public void updateAircraft(Aircraft up);

}