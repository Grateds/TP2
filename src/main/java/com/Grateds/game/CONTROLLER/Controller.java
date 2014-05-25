package com.Grateds.game.CONTROLLER;

import java.util.Scanner;
import com.Grateds.game.AI.AdversaryProblem;
import com.Grateds.game.AI.AdversaryState;
import com.Grateds.game.AI.MinMaxAlphaBetaPruningEngine;
import com.Grateds.game.MODEL.Board;

public class Controller {
	
	private Board board;
	
	/**
	 * Default constructor. Creates a new board to play.
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
		this.board.initialization();
		AdversaryState s = new AdversaryState(this.board);
		AdversaryProblem p = new AdversaryProblem(s);
		MinMaxAlphaBetaPruningEngine<AdversaryProblem, AdversaryState> engine = new MinMaxAlphaBetaPruningEngine<AdversaryProblem, AdversaryState>(p,4);
	
		System.out.println("Game began..\n\n"+s.toString());
		while ( !p.end(s)) {
			s = engine.computeSuccessor(s);
			pause();
			System.out.println(s.toString());
			this.setRandomValue();
		}
	}
	
	/**
	 * Set a random value (2 or 4) in the board in a random unoccupied position.
	 */
	private void setRandomValue() {
		this.board.randomBoard();
	}
	
	@SuppressWarnings("resource")
	private void pause(){
		System.out.println("Press enter to continue...");
		Scanner keyboard = new Scanner(System.in);
		keyboard.nextLine();
	}
}