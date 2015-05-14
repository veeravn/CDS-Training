package com.csd.tests;

import static org.junit.Assert.*;

import com.csd.src.Shields;

import org.junit.Before;
import org.junit.Test;

public class TestShields {
	
	Shields shields;
	@Before
	public void init() {
		shields = new Shields();
	}
	
	@Test
	public void toggleChangedShields() {
		boolean currentShields = shields.isRaised();
		shields.toggleShields();
		assertNotEquals(currentShields, shields.isRaised());
	}
	
}
