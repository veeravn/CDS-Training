import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertTrue;


public class TestShip {

	Ship ship;
	
	@Before
	public void init(){
		ship = new Ship();
	}

	@Test
	public void testTranserEnergyFromShip() {
		ship.transferEnergy(1000);
		assertTrue(ship.getEnergy() == Ship.DEFAULT_SHIP_LEVEL - 1000);
	}
	
	
	@Test
	public void testTranserEnergyToShields() {
		ship.transferEnergy(1000);
		assertTrue(ship.getShields().getShieldEnergyLevel() == Shields.DEFAULT_SHIELD_LEVEL + 1000);
	}

	@Test
	public void testShipsShieldsGoodAtOutset() {
		Shields shields = ship.getShields();
		assertTrue(shields.getShieldEnergyLevel() == Shields.DEFAULT_SHIELD_LEVEL);
	}
	
	@Test
	public void testShipsEnergyIsDefaultAtOutset() {
		assertTrue(ship.getEnergy() == (Ship.DEFAULT_SHIP_LEVEL));
	}
	
	@Test
	public void testGetSubsystemsReturnsSubsystemsNotZero() {
		ArrayList<SubSystem> ss = ship.getShipsSubsytems();
		assertTrue(ss.size() > 0);
	}

    @Test
    public void checkTypeList() {
        assertTrue(Ship.stardateDamage.size() > 0);
    }

}
