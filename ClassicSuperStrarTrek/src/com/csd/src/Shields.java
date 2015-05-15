
public class Shields {
	
	private boolean raised = false;
	
	
	public static final int DEFAULT_SHIELD_LEVEL = 5000;
	public static final int MAX_SHIELD_LEVEL = 10000;
	public static final int MIN_SHIELD_LEVEL = 0;
	
	private int shieldEnergyLevel = DEFAULT_SHIELD_LEVEL;
	
	public boolean isRaised() {
		return raised;
	}
	
	public void raiseShields(SubSystem shieldSubSystem) {
        if (shieldSubSystem.isDamaged()) {
            raised = false;
        } else {
            raised = true;
        }
	}
	
	public void dropShields() {
		raised = false;
	}
	
	
	public int getShieldEnergyLevel() {
		return shieldEnergyLevel;
	}
	
	// positive values increase shield levels, negative values reduce them
	public void changeShieldEnergyLevelBy(int energyUnitDelta) {
		
		shieldEnergyLevel = shieldEnergyLevel + energyUnitDelta;
		
		if (shieldEnergyLevel < MIN_SHIELD_LEVEL) {
			shieldEnergyLevel = MIN_SHIELD_LEVEL;
			return;
		}
		
		if (shieldEnergyLevel > MAX_SHIELD_LEVEL) {
			shieldEnergyLevel = MAX_SHIELD_LEVEL;
			return;
		}
	}
	/**
	 * Calculate the amount of energy that is absorbed and the amount left over.
	 * @param hitEnergy the amount of energy hit
	 * @return the amount of energy not absorbed.
	 */
	public int hit(int hitEnergy) {
		int energyNotAbsorbed = 0;
		if(isRaised() == false) {
			energyNotAbsorbed = hitEnergy;
		} else {
			if(shieldEnergyLevel < hitEnergy) {
				energyNotAbsorbed = hitEnergy - shieldEnergyLevel;
			}
			changeShieldEnergyLevelBy(-hitEnergy);
		}
		return energyNotAbsorbed;
	}
	/**
	 * Transfer energy to and from the shields
	 * @param transEnergy the amount of energy to transfer
	 */
	public int transferEnergy(int transEnergy) {
		int allowedEnergy = MAX_SHIELD_LEVEL - shieldEnergyLevel;
		int extraEnergy = 0;
		if(allowedEnergy < transEnergy) {
			shieldEnergyLevel += allowedEnergy;
			extraEnergy = transEnergy - allowedEnergy;
		} else {
			shieldEnergyLevel += transEnergy;
		}
		
		if(extraEnergy > 0) {
			
			System.out.println("You are transfering " + transEnergy + " units of energy, the shields only need " + allowedEnergy + 
					" units of energy.");
			System.out.println(extraEnergy + " units of energy is being returned to the ship.");
		}
		return extraEnergy;
	}
	
}
