package com.Grateds.game.AI;

import static org.junit.Assert.*;

import org.junit.Test;

import com.Grateds.game.MODEL.Board;


public class AdversaryStateTest {
	
	private static final int[][] table1 = {
		{128, 0, 8, 0},
		{0, 4, 16, 16},
		{32, 0, 1024, 16},
		{0, 64, 0, 32}};

	private static final int[][] table2 = {
		{128, 0, 8, 0},
		{0, 4, 16, 16},
		{32, 2048, 1024, 16},
		{0, 64, 0, 32}};
	
	private static final int[][] table3 = {
		{0, 0, 0, 0},
		{0, 0, 0, 0},
		{4, 0, 0, 0},
		{8, 2, 0, 0}};
	
	private static final int[][] table4 = {
		{0, 0, 2, 8},
		{0, 0, 0, 4},
		{0, 0, 0, 0},
		{0, 0, 0, 0}};

	@Test
	public void testIsMax() {
		fail("Not yet implemented");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorWithNullArgs() {
		AdversaryState g = new AdversaryState(null);
		g.isSucess();
	}
	
	@Test
	public void testSucessEqualsState() {
		Board b = new Board();
		b.set(table1);
		AdversaryState g = new AdversaryState(b);
		AdversaryState h = new AdversaryState(b);
		
		assertTrue(g.equals(h));
	}
	
	@Test
	public void testIsSucess() {
		Board b = new Board();
		b.set(table1);
		AdversaryState g = new AdversaryState(b);
		
		assertFalse(g.isSucess());

		b.set(table2);
		
		assertTrue(g.isSucess());
	}

	@Test
	public void testFailMoveUp() {
		Board b = new Board();
		b.set(table4);
		AdversaryState g = new AdversaryState(b);
		
		assertFalse(g.sucessMoveUp());
	}
	
	@Test
	public void testSucessMoveUp() {
		Board b = new Board();
		b.set(table3);
		AdversaryState g = new AdversaryState(b);
		
		assertTrue(g.sucessMoveUp());
	}

	@Test
	public void testFailMoveBellow() {
		Board b = new Board();
		b.set(table3);
		AdversaryState g = new AdversaryState(b);
		
		assertFalse(g.sucessMoveBellow());
	}
	
	@Test
	public void testSucessMoveBellow() {
		Board b = new Board();
		b.set(table4);
		AdversaryState g = new AdversaryState(b);
		
		assertTrue(g.sucessMoveBellow());
	}

	@Test
	public void testFailMoveRight() {
		Board b = new Board();
		b.set(table4);
		AdversaryState g = new AdversaryState(b);
		
		assertFalse(g.sucessMoveRight());
	}
	
	@Test
	public void testSucessMoveRight() {
		Board b = new Board();
		b.set(table3);
		AdversaryState g = new AdversaryState(b);
		
		assertTrue(g.sucessMoveRight());
	}
	
	@Test
	public void testFailMoveLeft() {
		Board b = new Board();
		b.set(table3);
		AdversaryState g = new AdversaryState(b);
		
		assertFalse(g.sucessMoveLeft());
	}
	
	@Test
	public void testSucessMoveLeft() {
		Board b = new Board();
		b.set(table4);
		AdversaryState g = new AdversaryState(b);
		
		assertTrue(g.sucessMoveLeft());
	}
	
	// For run this tests, remove comments and change the access
	// modifiers on methods (val(Board b) and posGreater(Board b)) to "public"
//	@Test
//	public void testValuation() {
//		int[][] t = {
//				{128, 0, 8, 0},
//				{2, 4, 16, 16},
//				{32, 8, 1024, 16},
//				{2048, 64, 3, 32}};
//		
//		Board b = new Board();
//		b.set(t);
//		AdversaryState g = new AdversaryState(b);
//		int result = g.val(b);
//		assertEquals(4, result);
//	}
//	
//	@Test
//	public void testPositionGreater() {		
//		Board b = new Board();
//		b.set(table2);
//		AdversaryState g = new AdversaryState(b);
//		int[] result = g.posGreater(b);
//		assertEquals(2, result[0]);
//		assertEquals(1, result[1]);
//	}
	
}
