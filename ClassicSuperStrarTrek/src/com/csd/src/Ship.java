import java.util.ArrayList;


public class Ship {

	public static final int DEFAULT_SHIP_LEVEL = 40000;

	private ArrayList<SubSystem> shipsSubsytems = new ArrayList<SubSystem>();
	private int shipEnergyLevel = DEFAULT_SHIP_LEVEL;
	private Shields shields = new Shields();

	
	public Ship() {
		SubSystem ss = new SubSystem();
		shipsSubsytems.add(ss);
	}

	public void transferEnergy(int energyLevel) {
		getShields().changeShieldEnergyLevelBy(energyLevel);		
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
