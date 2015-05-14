

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestShields {
	Shields shields;
	
	@Before
	public void init(){
		shields = new Shields();
	}
	
	@Test
	public void shieldsAreNotRaisedByDefault() {
		Shields s = new Shields();
		assertFalse(s.isRaised());
	}
	
	@Test
	public void shieldDefaultLevelTest() {
		Shields s = new Shields();
		assertEquals(s.getShieldEnergyLevel(), Shields.DEFAULT_SHIELD_LEVEL);
	}
	
	@Test
	public void testDropShields() {
		Shields shields = new Shields();
		shields.dropShields();
		assertFalse(shields.isRaised());
	}
	
	@Test
	public void testRaiseShields() {
		Shields shields = new Shields();
		shields.raiseShields();
		assertTrue(shields.isRaised());
	}
	
	@Test 
	public void testIncreaseShieldEnergyLevel() {
		Shields s = new Shields();
		final int energyLevelDelta = 2000;
		int currentShieldLevel = s.getShieldEnergyLevel();
		s.changeShieldEnergyLevelBy(energyLevelDelta);
		assertEquals(s.getShieldEnergyLevel(), currentShieldLevel + energyLevelDelta);
	}
	
	@Test 
	public void testDecreaseShieldEnergyLevel() {
		Shields s = new Shields();
		final int energyLevelDelta = -2000;
		int currentShieldLevel = s.getShieldEnergyLevel();
		s.changeShieldEnergyLevelBy(energyLevelDelta);
		assertEquals(s.getShieldEnergyLevel(), currentShieldLevel + energyLevelDelta);
	}
	
	@Test 
	public void testIncreaseShieldEnergyLevelBeyondMax() {
		Shields s = new Shields();
		final int energyLevelDelta = 5001;
		s.changeShieldEnergyLevelBy(energyLevelDelta);
		assertEquals(s.getShieldEnergyLevel(), Shields.MAX_SHIELD_LEVEL);
	}
	
	@Test 
	public void testDecreaseShieldEnergyLevelBeyondMin() {
		Shields s = new Shields();
		assertEquals(s.getShieldEnergyLevel(), Shields.DEFAULT_SHIELD_LEVEL);
		final int energyLevelDelta = -5002;
		s.changeShieldEnergyLevelBy(energyLevelDelta);
		assertEquals(s.getShieldEnergyLevel(), Shields.MIN_SHIELD_LEVEL);
	}
	
	@Test
	public void shieldBuckleWhenEnergyAtZero() {
		int curEnergy = shields.getShieldEnergyLevel();
		shields.hit(curEnergy);	
		assertFalse(shields.isRaised());
	}
}
