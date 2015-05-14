

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class TestShields {
	
	Shields shields;
	@Before
	public void init() {
		shields = new Shields();
	}
	
	@Test
	public void toggleChangedShields() {
		boolean currentShields = shields.isRaised();
		shields.toggleShields();
		assertNotEquals(currentShields, shields.isRaised());
	}
	
}
