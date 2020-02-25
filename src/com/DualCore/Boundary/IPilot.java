package com.DualCore.Boundary;

import java.util.ArrayList;

import com.DualCore.Entity.Pilot;

public interface IPilot {
	
	public int newPilot(Pilot p);
	
	public void deletePilot(int id);
	
	public ArrayList<Pilot> showPilots();
	 
	public Pilot getPilot(int id);
	
	public void updatePilot(Pilot up);

}
