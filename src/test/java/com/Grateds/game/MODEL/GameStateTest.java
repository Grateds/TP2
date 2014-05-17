package com.Grateds.game.MODEL;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameStateTest {

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorWithNullArgs() {
		GameState g = new GameState(null);
		g.isSucess();
	}
	//TODO implement this class
	//@Test
	public void testSucessEqualsState() {
		fail("Not yet implemented");
	}
	
	//@Test
	public void testFailEqualsState() {
		fail("Not yet implemented");
	}
	
	//@Test
	public void testIsSucess() {
		fail("Not yet implemented");
	}

//	@Test
	public void testVMU() {
		fail("Not yet implemented");
	}

//	@Test
	public void testVMB() {
		fail("Not yet implemented");
	}

	//@Test
	public void testVMR() {
		fail("Not yet implemented");
	}

	//@Test
	public void testVML() {
		fail("Not yet implemented");
	}

}
