package test.com.dualcore.boundary;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.DualCore.Entity.Aircraft;

class AircraftTest {

	Aircraft aircraftToTest;

	@BeforeEach
	void setUp() throws Exception {
		//instantiate a new aircraft
		aircraftToTest = new Aircraft();
		//set values to attributes
		aircraftToTest.setId(1);
		aircraftToTest.setIs_autoPilot("Yes");
		aircraftToTest.setManufacturer("Boeing");
		aircraftToTest.setMax_speed("45,963");
		aircraftToTest.setTotal_seats("350");
		aircraftToTest.setWeight_capacity("80000");
	}

	@Test
	void testAllGetters() {
		aircraftToTest.getId();
		aircraftToTest.getIs_autoPilot();
		aircraftToTest.getManufacturer();
		aircraftToTest.getMax_speed();
		aircraftToTest.getTotal_seats();
		aircraftToTest.getWeight_capacity();
	}
	
}
