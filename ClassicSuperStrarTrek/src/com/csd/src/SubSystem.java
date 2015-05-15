import java.util.HashMap;

public class SubSystem {

    private double star_dates_to_repair = 0;
    public static HashMap<subsystem_type, Integer> stardateDamage = new HashMap<subsystem_type, Integer>();

    private subsystem_type type;

    public enum subsystem_type {
        SHIELDS, PHASERS, WARP_ENGINES, PHOTON_TORPEDOES
    }

    subsystem_type st;

    public SubSystem(subsystem_type subsystem_type) {
        type = subsystem_type;
        stardateDamage.put(st.SHIELDS, 500);
        stardateDamage.put(st.PHASERS, 300);
        stardateDamage.put(st.WARP_ENGINES, 200);
        stardateDamage.put(st.PHOTON_TORPEDOES, 500);
    }

    public boolean isDamaged() {
        if (star_dates_to_repair > 0)
            return true;
        else
            return false;
    }

    public void applyDamage(int energyDamage) {
        star_dates_to_repair = star_dates_to_repair + damageCalculation(energyDamage);
    }

    public subsystem_type getType() {
        return type;
    }

    public int damageCalculation(int damage) {
        return Math.round(damage / stardateDamage.get(type));

    }
}
