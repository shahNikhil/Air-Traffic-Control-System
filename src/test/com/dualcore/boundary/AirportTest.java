package test.com.dualcore.boundary;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.DualCore.Entity.Airport;

class AirportTest {

	Airport airportToTest;

	@BeforeEach
	void setUp() throws Exception {
		//instantiate a new Airport
		airportToTest = new Airport();
		//set values to attributes
		airportToTest.setAirport_name("YVR");
		airportToTest.setAirport_type("International");
		airportToTest.setCity("Vancouver");
		airportToTest.setCountry("Canada");
		airportToTest.setId(1);
		airportToTest.setTotal_runways(250);
		airportToTest.setTotal_terminals(15);
	}
	
	@Test
	void testAllGetters() {
		airportToTest.getAirport_name();
		airportToTest.getAirport_type();
		airportToTest.getCity();
		airportToTest.getCountry();
		airportToTest.getId();
		airportToTest.getTotal_runways();
		airportToTest.getTotal_terminals();
	}
	
}
