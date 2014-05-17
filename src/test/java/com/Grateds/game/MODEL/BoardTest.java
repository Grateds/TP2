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
		Board expected = new Board();	
		int[][] table1 = {
				{0, 0, 4, 8},
				{0, 0, 0, 16},
				{0, 0, 4, 32},
				{2, 0, 4, 0}}; 
	    int[][] table2 = {
				{2, 0, 8, 8},
				{0, 0, 4, 16},
				{0, 0, 0, 32},
				{0, 0, 0, 0}};
	    b.set(table1);
	    expected.set(table2);
	    Board res = b.movingUp();
	    assertEquals(expected.toString(),res.toString());  
	}

	@Test
	public void testMovingBelow() {
		Board b = new Board();
		Board expected = new Board();	
		int[][] table1 = {
				{2, 0, 4, 8},
				{0, 0, 0, 16},
				{0, 0, 4, 32},
				{0, 0, 4, 0}}; 
	    int[][] table2 = {
				{0, 0, 0, 0},
				{0, 0, 0, 8},
				{0, 0, 4, 16},
				{2, 0, 8, 32}};
	    b.set(table1);
	    expected.set(table2);
	    Board res = b.movingBelow();
	    assertEquals(expected.toString(),res.toString()); 
	}
	
	@Test
	public void testMovingRight(){
		Board b = new Board();
		Board expected = new Board();	
		int[][] table1 = {
				{0, 8, 8, 0},
				{0, 0, 0, 0},
				{2, 0, 2, 2},
				{0, 4, 0, 0}}; 
	    int[][] table2 = {
				{0, 0, 0, 16},
				{0, 0, 0, 0},
				{0, 0, 2, 4},
				{0, 0, 0, 4}};
	    b.set(table1);
	    expected.set(table2);
	    Board res = b.movingRight();
	    assertEquals(expected.toString(),res.toString()); 
	}

	@Test
	public void testMovingLeft(){
		Board b = new Board();
		Board expected = new Board();
		int[][] table1 = {
				{0, 0, 0, 0},
				{0, 4, 4, 0},
				{0, 0, 0, 16},
				{0, 0, 0, 32}}; 
		int[][] table2 = {
				{0, 0, 0, 0},
				{8, 0, 0, 0},
				{16, 0, 0, 0},
				{32, 0, 0, 0}};
        b.set(table1);
        expected.set(table2);
        Board res = b.movingLeft();
        assertEquals(expected.toString(),res.toString());
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
