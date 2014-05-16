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
	public void testMovingUp() {
		Board b = new Board();
		Board res = new Board();
	    b.set(0, 2, 4);
	    b.set(0, 3, 8);
	    b.set(1, 3, 16);
	    b.set(2, 2, 4);
	    b.set(2, 3, 32);
	    b.set(3, 2, 4);
	    b.set(3, 3, 0);
	    b.set(3, 0, 2);
	    b.movingUp();
	    res.set(0, 0, 2);
	    res.set(0, 2, 8);
	    res.set(0, 3, 8);
	    res.set(1, 2, 4);
	    res.set(1, 3, 16);
	    res.set(2, 3, 32);
	    assertEquals(res.toString(),b.toString());  
	}
	//TODO test for equals
	//TODO test for contains
}
