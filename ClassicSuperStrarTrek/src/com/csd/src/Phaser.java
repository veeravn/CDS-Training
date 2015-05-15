
public class Phaser {

	private int phaserEnergy = 0;
	public static int MAXIUM_PHASER_ENERGY = 1500;
	
	public int getPhaserEnergy() {
		return phaserEnergy;
	}

	public int charge(int energy) {
		int initialEnergy = phaserEnergy;
		if(initialEnergy + energy > MAXIUM_PHASER_ENERGY) {
			phaserEnergy = MAXIUM_PHASER_ENERGY;
			return (initialEnergy + energy) - MAXIUM_PHASER_ENERGY; 
		}
		else {
			phaserEnergy = phaserEnergy + energy;
			return 0;
		}
	}

	public int fire(int numberTargets) {
		return phaserEnergy / numberTargets;
	}

}
