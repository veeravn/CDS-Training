

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
		final int energyLevelDelta = 5001;
		shields.changeShieldEnergyLevelBy(energyLevelDelta);
		assertEquals(shields.getShieldEnergyLevel(), Shields.MAX_SHIELD_LEVEL);
	}
	
	@Test 
	public void testDecreaseShieldEnergyLevelBeyondMin() {
		assertEquals(shields.getShieldEnergyLevel(), Shields.DEFAULT_SHIELD_LEVEL);
		final int energyLevelDelta = -5002;
		shields.changeShieldEnergyLevelBy(energyLevelDelta);
		assertEquals(shields.getShieldEnergyLevel(), Shields.MIN_SHIELD_LEVEL);
	}
	
	@Test
	public void shieldBuckleWhenEnergyAtZero() {
		int curEnergy = shields.getShieldEnergyLevel();
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
	public void transferTooMuchEnergy() {
		int curEnergy = shields.getShieldEnergyLevel();
		int transEnergy = Shields.MAX_SHIELD_LEVEL - curEnergy;
		int extra = shields.transferEnergy(transEnergy + 1);
		assertEquals(1, extra);
	}
	@Test
	public void transferJustEnoughEnergy() {
		int curEnergy = shields.getShieldEnergyLevel();
		int transEnergy = Shields.MAX_SHIELD_LEVEL - curEnergy;
		int extra = shields.transferEnergy(transEnergy);
		assertEquals(0, extra);
	}
}
