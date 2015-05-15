

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;


public class TestSubsystemStatus {

    SubSystem subsystem;

    @Before
    public void setup() {
        subsystem = new SubSystem(SubSystem.subsystem_type.SHIELDS);
    }

    @Test
    public void checkSubsystemStatus() {
        assertFalse(subsystem.isDamaged());

    }

    @Test
    public void checkApplyDamage() {
        subsystem.applyDamage(50);
        assertTrue(subsystem.isDamaged());
    }

    @Test
    public void checkSubsystemType() {
        assertEquals(SubSystem.subsystem_type.SHIELDS, subsystem.getType());
    }

    @Test
    public void checkTypeList() {
        assertTrue(subsystem.one_tenth_stardateDamage.size() > 0);
    }

    @Test
    public void checkDamageCalculation() {
        assertEquals(.1, subsystem.damageCalculation(59));
    }
}