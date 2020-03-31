package test.com.dualcore.boundary;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.DualCore.Entity.Flight;
import com.DualCore.Entity.Pilot;

class FlightTest {

	Flight flightToTest;
	
	@BeforeEach
	void setUp() throws Exception {
		//instantiate a new Flight
		flightToTest = new Flight();
		//set values to attributes
		flightToTest.setArr_airport("YVR");
		flightToTest.setDate("01/01/2001");
		flightToTest.setDelayed_by(2);
		flightToTest.setDep_airport("BOM");
		flightToTest.setFlight_name("Air Canada");
		flightToTest.setId(1);
		flightToTest.setManufacturer("Boeing");
		flightToTest.setPilot_name("Sam");
		flightToTest.setPriority(5);
		flightToTest.setScheduled_time("12:35");
	}
	
	@Test
	void testAllGetters() {
		flightToTest.getArr_airport();
		flightToTest.getDate();
		flightToTest.getDelayed_by();
		flightToTest.getDep_airport();
		flightToTest.getFlight_name();
		flightToTest.getId();
		flightToTest.getManufacturer();
		flightToTest.getPilot_name();
		flightToTest.getPriority();
		flightToTest.getScheduled_time();
	}

}
