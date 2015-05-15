import java.util.ArrayList;
import java.util.HashMap;


public class Ship {

	public static final int DEFAULT_SHIP_LEVEL = 40000;

	private ArrayList<SubSystem> shipsSubsytems = new ArrayList<SubSystem>();
	private int shipEnergyLevel = DEFAULT_SHIP_LEVEL;
	private Shields shields = new Shields();

    public static HashMap<SubSystemType, Integer> stardateDamage = new HashMap<SubSystemType, Integer>();
    static  {
        stardateDamage.put(SubSystemType.SHIELDS, 500);
        stardateDamage.put(SubSystemType.PHASERS, 300);
        stardateDamage.put(SubSystemType.WARP_ENGINES, 200);
        stardateDamage.put(SubSystemType.PHOTON_TORPEDOES, 500);
    }

	public Ship() {
		SubSystem ss = new SubSystem(SubSystemType.WARP_ENGINES);
		shipsSubsytems.add(ss);
	}

	public void transferEnergy(int energyLevel) {
		getShields().changeShieldEnergyLevelBy(energyLevel);
		shipEnergyLevel = shipEnergyLevel - energyLevel;
	}

	public ArrayList<SubSystem> getShipsSubsytems() {
		return shipsSubsytems;
	}


	public void setShipsSubsytems(ArrayList<SubSystem> shipsSubsytems) {
		this.shipsSubsytems = shipsSubsytems;
	}

	public int getEnergy() {
		return shipEnergyLevel;
	}

	public Shields getShields() {
		return shields;
	}

	public void setShields(Shields shields) {
		this.shields = shields;
	}

}
