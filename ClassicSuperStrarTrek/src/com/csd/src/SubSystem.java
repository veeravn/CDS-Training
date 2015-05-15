public class SubSystem {

    private double star_dates_to_repair = 0;

    private SubSystemType type;

    public SubSystem(SubSystemType subsystem_type) {
        type = subsystem_type;
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

    public SubSystemType getType() {
        return type;
    }

    public int damageCalculation(int damage) {
        return Math.round(damage / Ship.stardateDamage.get(type));
    }
}
