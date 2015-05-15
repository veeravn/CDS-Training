

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;


public class TestSubsystemStatus {

    SubSystem subsystem;

    @Before
    public void setup() {
        subsystem = new SubSystem(SubSystemType.SHIELDS);
    }

    @Test
    public void checkSubsystemStatus() {
        assertFalse(subsystem.isDamaged());

    }

    @Test
    public void checkApplyDamage() {
        subsystem.applyDamage(500);
        assertTrue(subsystem.isDamaged());
    }

    @Test
    public void checkSubsystemType() {
        assertEquals(SubSystemType.SHIELDS, subsystem.getType());
    }

    @Test
    public void checkDamageCalculation() {
        assertEquals(0, subsystem.damageCalculation(59));
    }
}