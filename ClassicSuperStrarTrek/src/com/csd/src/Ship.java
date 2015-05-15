import java.util.ArrayList;


public class Ship {

	public static final int DEFAULT_SHIP_LEVEL = 40000;

	private int shipEnergyLevel = DEFAULT_SHIP_LEVEL;
	

	public void transferEnergy(int i) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<SubSystem> getSubsystems() {
		ArrayList<SubSystem> subsystems = new ArrayList<SubSystem>();
		SubSystem ss = new SubSystem();
		subsystems.add(ss);
		return subsystems;
	}

	public Object getEnergy() {
		return shipEnergyLevel;
	}

}
