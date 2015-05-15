

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestShields {
	Shields shields;
    private SubSystem shieldSubSystem;

	@Before
	public void init(){
		shields = new Shields();
        shieldSubSystem = new SubSystem(SubSystemType.SHIELDS);
	}
	
	@Test
	public void shieldsAreNotRaisedByDefault() {
		assertFalse(shields.isRaised());
	}
	
	@Test
	public void shieldDefaultLevelTest() {
		assertEquals(shields.getShieldEnergyLevel(), Shields.DEFAULT_SHIELD_LEVEL);
	}
	
	@Test
	public void testDropShields() {
		shields.dropShields();
		assertFalse(shields.isRaised());
	}
	
	@Test
	public void testRaiseShields() {
		shields.raiseShields(shieldSubSystem);
		assertTrue(shields.isRaised());
	}
	
	@Test 
	public void testIncreaseShieldEnergyLevel() {
		final int energyLevelDelta = 2000;
		int currentShieldLevel = shields.getShieldEnergyLevel();
		shields.changeShieldEnergyLevelBy(energyLevelDelta);
		assertEquals(shields.getShieldEnergyLevel(), currentShieldLevel + energyLevelDelta);
	}
	
	@Test 
	public void testDecreaseShieldEnergyLevel() {
		final int energyLevelDelta = -2000;
		int currentShieldLevel = shields.getShieldEnergyLevel();
		shields.changeShieldEnergyLevelBy(energyLevelDelta);
		assertEquals(shields.getShieldEnergyLevel(), currentShieldLevel + energyLevelDelta);
	}
	
	@Test 
	public void testIncreaseShieldEnergyLevelBeyondMax() {
		final int energyLevelDelta = Shields.MAX_SHIELD_LEVEL - Shields.DEFAULT_SHIELD_LEVEL + 1;
		shields.changeShieldEnergyLevelBy(energyLevelDelta);
		assertEquals(Shields.MAX_SHIELD_LEVEL, shields.getShieldEnergyLevel());
	}
	
	@Test 
	public void verifyEnergyReturnedWhenIncreaseShieldEnergyLevelBeyondMax() {
		final int energyLevelDelta = Shields.MAX_SHIELD_LEVEL - Shields.DEFAULT_SHIELD_LEVEL + 1;
		int energyReturned = shields.changeShieldEnergyLevelBy(energyLevelDelta);
		assertEquals(1, energyReturned);
	}
	
	@Test 
	public void testDecreaseShieldEnergyLevelBeyondMin() {
		final int energyLevelDelta = - (Shields.DEFAULT_SHIELD_LEVEL + 1);
		shields.changeShieldEnergyLevelBy(energyLevelDelta);
		assertEquals(Shields.MIN_SHIELD_LEVEL, shields.getShieldEnergyLevel());
	}

	@Test 
	public void verifyEnergyReturnedWhenDecreaseShieldEnergyLevelBeyondMin() {
		final int energyLevelDelta = - (Shields.DEFAULT_SHIELD_LEVEL + 1);
		int energyReturned = shields.changeShieldEnergyLevelBy(energyLevelDelta);
		assertEquals(-1, energyReturned);
	}

	@Test
	public void shieldBuckleWhenEnergyAtZero() {
		int curEnergy = shields.getShieldEnergyLevel();
		shields.raiseShields();
		shields.hit(curEnergy);	
		assertFalse(shields.isRaised());
	}
	
	@Test
	public void shieldHitWithMoreEnergyThenItCanHandle() {
		final int damageBeyondShieldEnergy = 100;
		int curEnergy = shields.getShieldEnergyLevel();
		shields.raiseShields(shieldSubSystem);
		int energyNotAbsorbed = shields.hit(curEnergy + damageBeyondShieldEnergy); 
		assertEquals(damageBeyondShieldEnergy, energyNotAbsorbed);
	}
	
	@Test
	public void shieldsHitWhenNotRaised() {
		final int hitEnergy = 500;
		shields.dropShields();
		int returnedEnergy = shields.hit(hitEnergy);
		assertEquals(hitEnergy, returnedEnergy);
	}
	@Test
	public void testTransferEnergyIncrease() {
		int curEnergy = shields.getShieldEnergyLevel();
		shields.transferEnergy(2500);
		assertEquals(curEnergy+2500, shields.getShieldEnergyLevel());
	}
	
	@Test
	public void transferEnergyIncreaseTooMuch() {
		int curEnergy = shields.getShieldEnergyLevel();
		int transEnergy = Shields.MAX_SHIELD_LEVEL - curEnergy;
		int extra = shields.transferEnergy(transEnergy + 1);
		assertEquals(1, extra);
	}
	@Test
	public void transferEnergyIncreaseToMaxAllowed() {
		int curEnergy = shields.getShieldEnergyLevel();
		int transEnergy = Shields.MAX_SHIELD_LEVEL - curEnergy;
		int extra = shields.transferEnergy(transEnergy);
		assertEquals(0, extra);
	}
	@Test
	public void testTransferEnergyDecrease() {
		int curEnergy = shields.getShieldEnergyLevel();
		shields.transferEnergy(-2500);
		assertEquals(curEnergy-2500, shields.getShieldEnergyLevel());
	}
	@Test
	public void transferEnergyDecreaseTooMuch() {
		int curEnergy = shields.getShieldEnergyLevel();
		int transEnergy = curEnergy + 1;
		int extra = shields.transferEnergy(-transEnergy);
		assertEquals(-1, extra);
	}
	@Test
	public void transferEnergyDecreaseToMinAllowed() {
		int curEnergy = shields.getShieldEnergyLevel();
		int transEnergy = curEnergy;
		int extra = shields.transferEnergy(-transEnergy);
		assertEquals(0, extra);
	}
	@Test
	public void shieldsDroppedWhenEnergyReducedToMin() {
		shields.raiseShields();
		int curEnergy = shields.getShieldEnergyLevel();
		int transEnergy = curEnergy;
		shields.transferEnergy(-transEnergy);
		assertFalse(shields.isRaised());
	}
}
