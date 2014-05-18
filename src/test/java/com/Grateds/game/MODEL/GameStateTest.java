package com.Grateds.game.MODEL;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameStateTest {
	
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
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorWithNullArgs() {
		GameState g = new GameState(null);
		g.isSucess();
	}
	
	@Test
	public void testSucessEqualsState() {
		Board b = new Board();
		b.set(table1);
		GameState g = new GameState(b);
		GameState h = new GameState(b);
		
		assertTrue(g.equals(h));
	}
	
	@Test
	public void testIsSucess() {
		Board b = new Board();
		b.set(table1);
		GameState g = new GameState(b);
		
		assertFalse(g.isSucess());

		b.set(table2);
		
		assertTrue(g.isSucess());
	}

	@Test
	public void testSucessMoveUp() {
		Board b = new Board();
		b.set(table4);
		GameState g = new GameState(b);
		
		assertFalse(g.sucessMoveUp());
	}

	@Test
	public void testSucessMoveBellow() {
		Board b = new Board();
		b.set(table3);
		GameState g = new GameState(b);
		
		assertFalse(g.sucessMoveBellow());
	}

	@Test
	public void testSucessMoveRight() {
		Board b = new Board();
		b.set(table4);
		GameState g = new GameState(b);
		
		assertFalse(g.sucessMoveRight());
	}

	@Test
	public void testSucessMoveLeft() {
		Board b = new Board();
		b.set(table3);
		GameState g = new GameState(b);
		
		assertFalse(g.sucessMoveLeft());
	}

}
