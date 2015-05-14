

import org.junit.Test;

import static junit.framework.Assert.assertFalse;


public class TestSubsystemStatus {

    @Test
    public void checkSubsystemStatus() {
        SubSystem subsystem = new SubSystem();
        assertFalse(subsystem.isDamaged());

    }

}