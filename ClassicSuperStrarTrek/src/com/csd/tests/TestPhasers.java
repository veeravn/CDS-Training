import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class TestPhasers {

	Phaser phaser;
	
	
	@Before
	public void init() {
		phaser = new Phaser();
	}

	
	@Test
	public void testChargeOverflow() {
		int overflow = phaser.charge(Phaser.MAXIUM_PHASER_ENERGY + 1);
		assertEquals(1, overflow);
	}
	
	@Test
	public void testChargingOfPhaserWithNoOverflow() {
		int initialEnergy = phaser.getPhaserEnergy();
		phaser.charge(100);
		assertEquals(100, phaser.getPhaserEnergy() - initialEnergy);
	}

}
