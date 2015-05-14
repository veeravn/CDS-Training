package com.csd.src;

public class Shields {
	
	private boolean raised = true;
	public boolean isRaised() {
		return raised;
	}

	public void toggleShields() {
		raised = !raised;
	}
}
