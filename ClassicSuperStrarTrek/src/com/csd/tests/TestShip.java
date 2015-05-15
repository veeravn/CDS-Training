import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class TestShip {

	Ship ship;
	
	@Before
	public void init(){
		ship = new Ship();
	}

	@Test
	public void testShipsEnergyIsDefaultAtOutset() {
		assertTrue(ship.getEnergy().equals(40000));
	}
	
	@Test
	public void testGetSubsystemsReturnsSubsystemsNotZero() {
		Ship ship = new Ship();
		ArrayList<SubSystem> ss = ship.getSubsystems();
		assertTrue(ss.size() > 0);
	}

}
