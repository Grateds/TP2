package com.Grateds.game.MODEL;

import com.Grateds.game.AI.State;

/**
 * Title:        GameState<p>
 * Description:  class describing the states for the 2048 game Problem.
 * It implements interface State. <p>
 * Copyright:    Copyright (c) Grateds 2014<p>
 * Company:      Grateds<p>
 * @author Grateds
 * @version 0.1
 */

public class GameState implements State {
	
	private Board board; // game board
	
	/**
	 * Default constructor for GameState class.
	 */
	public GameState() {
		this.board = new Board();
	}
	
	/**
	 * Constructor for GameState class. It initialises the content of 
	 * 		the board with the provided parameters.
	 * @param b is the board used to set the initial contents of the
	 * 		actual board;
	 * @throws IllegalArgumentException
	 */
	public GameState(Board b) {
		if (b == null) throw new IllegalArgumentException("The board must not be null");
		this.board = b;
	}
	
	/**
	 * Checks whether a provided GameState is equivalent to the current state.
	 * @param other is the state to be compared with 'this'.
	 * @return true iff 'other' is equivalent to 'this'.
	 * @throws IllegalArgumentException
	 */
	@Override
	public boolean equals(State other) {
		if (other == null)  throw new IllegalArgumentException("The state must not be null"); 
		GameState g = (GameState) other;
		return this.board.equals(g.board);
	}
	
	/**
	 * 
	 */
	 @Override
	 public String toString() {
		 return this.board.toString();
	 }
	 
	 /**
	  * 
	  * @return
	  */
	 public boolean isSucess() {
		 return this.board.contains(2048);
	 }
	 
	 /**
	  * 
	  */
	 public boolean vMU(){
		boolean valid = false;
		Board aux = this.board.movingUp();
		if(!this.board.equals(aux)) {
			this.board = aux;
			valid = true;
		}
		return valid;	 
	 }
	 
	 /**
	  * 
	  */
	 public boolean vMB(){
		 boolean valid = false;
		 Board aux = this.board.movingBelow();
		 if(!this.board.equals(aux)) {
			this.board = aux;
			valid = true;
		 }
		 return valid;	  
	 }

	 /**
	  * 
	  */
	 public boolean vMR(){
		 boolean valid = false;
		 Board aux = this.board.movingRight();
		 if(!this.board.equals(aux)) {
			 this.board = aux;
			 valid = true;
		 }
		 return valid;	 	 
	 }
	 
	 /**
	  * 
	  */
	 public boolean vML(){
		 boolean valid = false;
		 Board aux = this.board.movingLeft();
		 if(!this.board.equals(aux)) {
			 this.board = aux;
			 valid = true;
		 }
		 return valid;	 	 
	 }
}
