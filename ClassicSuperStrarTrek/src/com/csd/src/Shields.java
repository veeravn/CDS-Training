package com.csd.src;

public class Shields {
	
	private boolean raised = false;
	public boolean isRaised() {
		return raised;
	}
	public boolean getRaised() {
		return raised;
	}
	public void setRaised(boolean raised) {
		this.raised = raised;
	}
	public void toggleShields() {
		raised = !raised;
	}
}
