package test.com.dualcore.boundary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.DualCore.Entity.Pilot;

class PilotTest {

	Pilot pilotToTest;

	@BeforeEach
	void setUp() throws Exception {
		//instantiate a new Pilot
		pilotToTest = new Pilot();
		//set values to attributes
		pilotToTest.setFirst_name("Sam");
		pilotToTest.setAge(15);
		pilotToTest.setGender("M");
		pilotToTest.setLast_name("Hill");
		pilotToTest.setNationality("German");
		pilotToTest.setTraining_level(4);
		pilotToTest.setId(1);
	}

	@Test
	void testAllGetters() {
		pilotToTest.getFirst_name();
		pilotToTest.getAge();
		pilotToTest.getGender();
		pilotToTest.getLast_name();
		pilotToTest.getNationality();
		pilotToTest.getId();
	}

}


















