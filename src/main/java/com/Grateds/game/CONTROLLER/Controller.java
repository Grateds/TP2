package com.Grateds.game.CONTROLLER;

import com.Grateds.game.AI.AdversaryProblem;
import com.Grateds.game.AI.AdversaryState;
import com.Grateds.game.MODEL.Board;

public class Controller {
	
	private Board board;
	
	/**
	 * TODO Complete this doc
	 */
	public Controller() {
		this.board = new Board();
	}
	
	/**
	 * TODO Complete this doc
	 * @return
	 */
	public Board getBoard() {
		return this.board;
	}
	
	/**
	 * TODO Complete this doc
	 */
	public void initialization() {
		this.board.reset();
	}
	
	/**
	 * TODO Complete this doc
	 */
	public void startGame() {
		// TODO Complete this method with adversary
		this.board.initialization();
		AdversaryState initial = new AdversaryState(this.board);
		AdversaryProblem p = new AdversaryProblem(initial);
		
		System.out.println(this.board.toString());
	}
}