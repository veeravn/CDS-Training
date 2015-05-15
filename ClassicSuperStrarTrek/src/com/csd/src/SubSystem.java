import java.util.HashMap;

public class SubSystem {

    private double star_dates_to_repair = 0;
    public static HashMap<subsystem_type, Integer> one_tenth_stardateDamage = new HashMap<subsystem_type, Integer>();

    private subsystem_type type;

    public enum subsystem_type {
        SHIELDS, PHASERS, WARP_ENGINES, PHOTON_TORPEDOES
    }

    subsystem_type st;

    public SubSystem(subsystem_type subsystem_type) {
        type = subsystem_type;
        one_tenth_stardateDamage.put(st.SHIELDS, 50);
        one_tenth_stardateDamage.put(st.PHASERS, 30);
        one_tenth_stardateDamage.put(st.WARP_ENGINES, 20);
        one_tenth_stardateDamage.put(st.PHOTON_TORPEDOES, 50);
    }

    public boolean isDamaged() {
        if (star_dates_to_repair > 0)
            return true;
        else
            return false;
    }

    public void applyDamage(int damage) {
        star_dates_to_repair = star_dates_to_repair + damageCalculation(damage);
    }

    public subsystem_type getType() {
        return type;
    }

    public double damageCalculation(int damage) {
        return (int) Math.round(damage / one_tenth_stardateDamage.get(type)) * .1;

    }
}
