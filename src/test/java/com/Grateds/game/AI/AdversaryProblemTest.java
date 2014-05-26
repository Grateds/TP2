package com.Grateds.game.AI;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import com.Grateds.game.MODEL.Board;

public class AdversaryProblemTest {
	
	private static final int[][] table1 = {
		{0, 4, 2, 0},
		{0, 4, 0, 0},
		{8, 8, 4, 4},
		{0, 8, 0, 0}};
	
	private static final int[][] table2 = {
		{0, 0, 0, 0},
		{0, 0, 0, 0},
		{4, 0, 0, 0},
		{2, 0, 0, 0}};
	
	private static final int[][] tableMovedUp = {
		{8, 8, 2, 4},
		{0, 16, 4, 0},
		{0, 0, 0, 0},
		{0, 0, 0, 0}};
	
	private static final int[][] tableMovedDown = {
		{0, 0, 0, 0},
		{0, 0, 0, 0},
		{0, 8, 2, 0},
		{8, 16, 4, 4}};

	private static final int[][] tableMovedLeft = {
		{4, 2, 0, 0},
		{4, 0, 0, 0},
		{16, 8, 0, 0},
		{8, 0, 0, 0}};
	
	private static final int[][] tableMovedRight = {
		{0, 0, 4, 2},
		{0, 0, 0, 4},
		{0, 0, 16, 8},
		{0, 0, 0, 8}};
	
	private static final int[][] endedTable = {
		{4, 2, 4, 2},
		{2, 4, 2, 4},
		{4, 8, 16, 8},
		{2, 4, 2, 4}};
	
	@Test
	public void testGetSuccessorsSize() {
		Board b1 = new Board();
		b1.set(table1);
		Board b2 = new Board();
		b2.set(table2);
		AdversaryState s1 = new AdversaryState(b1);
		AdversaryState s2 = new AdversaryState(b2);
		AdversaryProblem p = new AdversaryProblem();
		List<AdversaryState> suc = p.getSuccessors(s1);
		
		assertEquals(4,suc.size());
		
		suc = p.getSuccessors(s2);
		
		assertEquals(2,suc.size());
	}
	
	@Test
	public void testGetSuccessors() {
		Board b = new Board();
		b.set(table1);
		AdversaryState s = new AdversaryState(b);
		AdversaryProblem p = new AdversaryProblem();
		List<AdversaryState> suc = p.getSuccessors(s);
		
		Board b1 = new Board();
		b1.set(tableMovedUp);
		Board b2 = new Board();
		b2.set(tableMovedDown);
		Board b3 = new Board();
		b3.set(tableMovedLeft);
		Board b4 = new Board();
		b4.set(tableMovedRight);
		AdversaryState s1 = new AdversaryState(b1);
		AdversaryState s2 = new AdversaryState(b2);
		AdversaryState s3 = new AdversaryState(b3);
		AdversaryState s4 = new AdversaryState(b4);

		assertTrue(s1.equals(suc.get(0)));
		assertTrue(s2.equals(suc.get(1)));
		assertTrue(s3.equals(suc.get(2)));
		assertTrue(s4.equals(suc.get(3)));
	}
	
	@Test
	public void testEnd() {
		Board b = new Board();
		b.set(endedTable);
		AdversaryState s = new AdversaryState(b);
		AdversaryProblem p = new AdversaryProblem();
		
		assertTrue(p.end(s));
	}

	@Test
	public void testMinStates() {
		Board b = new Board();
		b.set(table1);
		AdversaryState s = new AdversaryState(b);
		s.setMin();
		AdversaryProblem p = new AdversaryProblem();
		List<AdversaryState> suc = p.getSuccessors(s);
		
		assertTrue(suc.get(0).isMax());
		assertTrue(suc.get(0).isMax());
		assertTrue(suc.get(0).isMax());
		assertTrue(suc.get(0).isMax());
	}

	@Test
	public void testMaxStates() {
		Board b = new Board();
		b.set(table1);
		AdversaryState s = new AdversaryState(b);
		s.setMax();
		AdversaryProblem p = new AdversaryProblem();
		List<AdversaryState> suc = p.getSuccessors(s);
		
		assertFalse(suc.get(0).isMax());
		assertFalse(suc.get(0).isMax());
		assertFalse(suc.get(0).isMax());
		assertFalse(suc.get(0).isMax());
	}

}
