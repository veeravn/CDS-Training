
public class Shields {
	
	private boolean raised = false;
	
	
	public static final int DEFAULT_SHIELD_LEVEL = 5000;
	public static final int MAX_SHIELD_LEVEL = 10000;
	public static final int MIN_SHIELD_LEVEL = 0;
	
	private int shieldEnergyLevel = DEFAULT_SHIELD_LEVEL;
	
	public boolean isRaised() {
		return raised;
	}
	
	public void raiseShields() {
		raised = true;
	}
	
	public void dropShields() {
		raised = false;
	}
	
	
	public int getShieldEnergyLevel() {
		return shieldEnergyLevel;
	}
	
	/**  positive values increase shield levels, negative values reduce them
	 *  Returns any excess energy that could not be applied to the shields
	 * @param energyUnitDelta
	 * @return
	 */
	public int changeShieldEnergyLevelBy(int energyUnitDelta) {
		shieldEnergyLevel = shieldEnergyLevel + energyUnitDelta;
		int excessEnergy = 0;
		
		if (shieldEnergyLevel <= MIN_SHIELD_LEVEL) {
			excessEnergy = shieldEnergyLevel + MIN_SHIELD_LEVEL;
			shieldEnergyLevel = MIN_SHIELD_LEVEL;
			dropShields();
		} else if (shieldEnergyLevel > MAX_SHIELD_LEVEL) {
			excessEnergy = shieldEnergyLevel - MAX_SHIELD_LEVEL;
			shieldEnergyLevel = MAX_SHIELD_LEVEL;
		}
		return excessEnergy;

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
			energyNotAbsorbed = changeShieldEnergyLevelBy(-hitEnergy);
			// Since callers only deal in positive energy amounts, this needs to be negated prior to returning
			energyNotAbsorbed = -energyNotAbsorbed;
		}
		return energyNotAbsorbed;
	}
	/**
	 * Transfer energy to and from the shields
	 * @param transEnergy the amount of energy to transfer
	 */
	public int transferEnergy(int transEnergy) {

		int energyNotUsed = 0;
		energyNotUsed = changeShieldEnergyLevelBy(transEnergy);
		if(energyNotUsed > 0) {
			System.out.println("Shields at full, " + energyNotUsed + " not used, and being returned to the ship.");
		}

		return energyNotUsed;
	}
	
}
