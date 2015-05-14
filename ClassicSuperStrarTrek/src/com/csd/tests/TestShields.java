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
	public void shieldsAreNotRaisedOutset() {
		assertFalse(shields.isRaised());
	}
	
	@Test
	public void toggleLoweredShieldsRaisesShields() {
		shields.toggleShields();
		assertTrue(shields.isRaised());
	}
	
	@Test
	public void toggleRaisedShieldsLowersShields() {
		shields.toggleShields();
		shields.toggleShields();
		assertFalse(shields.isRaised());
	}
}
