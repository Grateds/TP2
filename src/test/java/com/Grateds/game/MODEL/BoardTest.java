package com.Grateds.game.MODEL;

import static org.junit.Assert.*;
import org.junit.Test;

public class BoardTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidPositionsSet() {
		Board board = new Board();
		board.set(-1, 4, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidValueSet() {
		Board board = new Board();
		board.set(0, 3, -1);
	}
	
	@Test
	public void testSimpleValidGet() {
		Board board = new Board();
		board.set(0, 3, 8);
		int result = board.get(0, 3);
		assertEquals(8,result);
	}
	
	@Test
	public void testEquals() {
		//TODO implement this test
		assertFalse(false);
	}
	
	@Test
	public void testContains() {
		//TODO implement this test
		assertFalse(false);
	}
}
