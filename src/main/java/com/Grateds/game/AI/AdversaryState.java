package com.Grateds.game.AI;

import com.Grateds.game.AI.lib.AdversarySearchState;
import com.Grateds.game.MODEL.Board;

public class AdversaryState implements AdversarySearchState {
	
	private Board board; // game board 
	private boolean isMax;
	private int directionToMove; // represents the different move directions:
								  // Up = 0
	                              // Down = 1
	                              // Left = 2
	                              // Right = 3
	
	/**
	 * Default constructor for AdversaryStates class.
	 */
	public AdversaryState() {
		this.board = new Board();
        this.isMax = true;
	}
	
	public AdversaryState(Board b) {
		if (b == null)	throw new IllegalArgumentException("The board must not be null");
		this.board = b;
        this.isMax = true;
	}
	
	@Override
	public boolean isMax() {
		return this.isMax;
	}
	
	/**
	 * Sets this state as a Max state.
	 */
	public void setMax() {
		this.isMax = true;
	}
	
	/**
	 * Sets this state as a Min state.
	 */
	public void setMin() {
		this.isMax = false;
	}
	
	@Override
	public boolean equals(AdversarySearchState other) {
		if (other == null)	throw new IllegalArgumentException("The state must not be null");
		AdversaryState g = (AdversaryState) other;
		return this.board.equals(g.board);
	}
	
	@Override
	public String toString() {
		return this.board.toString();
	}
	
    /**
	 * Returns true iff the currente state is sucess.
	 * @return true iff there is a 2048 on the board.
	 */
	public boolean isSucess() {
		return this.board.contains(2048);
	}
	
	/**
	 * Change the current board for another.
	 * @param b
	 * 		is the board to clone.
	 */
	public void changeCurrentBoard(Board b) {
		this.board = b.clone();
	}
	
	/**
	 * Returns a clone of this.
	 * @return a clone of this.
	 */
	public AdversaryState clone() {
		AdversaryState temp = new AdversaryState(this.board.clone());
		return temp;
	}
	
	/**
	 * Set a direction to move all elements in the board.
	 * @param dir
	 * 		is only one of the possible directions
	 * 		0 -> Up
	 * 		1 -> Down
	 * 		2 -> Left
	 * 		3 -> Right
	 */
	public void setDirection(int dir) {
		this.directionToMove = dir;
	}
	
	@Override
	public Object ruleApplied() {
		switch (directionToMove) {
		case 0:
			this.changeCurrentBoard(this.board.movingUp());
			return this;
	    case 1:
	    	this.changeCurrentBoard(this.board.movingBelow());
	    	return this;
	    case 2:
	    	this.changeCurrentBoard(this.board.movingLeft());
	    	return this;
	    default:
	    	this.changeCurrentBoard(this.board.movingRight());
	        return this;
		}
	}
    
    /**
	 * TODO Complete this doc
	 * @return
	 */
	public boolean sucessMoveUp() {
		boolean valid = false;
		Board aux = this.board.movingUp();
		if (!this.board.equals(aux)) {
			this.board = aux;
			valid = true;
		}
		return valid;
	}

	/**
	 * TODO Complete this doc
	 * @return
	 */
	public boolean sucessMoveBellow() {
		boolean valid = false;
		Board aux = this.board.movingBelow();
		if (!this.board.equals(aux)) {
			this.board = aux;
			valid = true;
		}
		return valid;
	}

	/**
	 * TODO Complete this doc
	 * @return
	 */
	public boolean sucessMoveRight() {
		boolean valid = false;
		Board aux = this.board.movingRight();
		if (!this.board.equals(aux)) {
			this.board = aux;
			valid = true;
		}
		return valid;
	}
	
	/**
	 * TODO Complete this doc
	 * @return
	 */
	public boolean sucessMoveLeft() {
		boolean valid = false;
		Board aux = this.board.movingLeft();
		if (!this.board.equals(aux)) {
			this.board = aux;
			valid = true;
		}
		return valid;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getValoration(){
		return this.assessment(this.board);
	}
	
	/**
	 * 
	 * @return
	 */
	public Board getBoard(){
		return this.board.clone();
	}
	
	/**
	 * Set a random value (2 or 4) in the board in a random unoccupied position.
	 */
	public void setRandomValue() {
		this.board.randomBoard();
	}
	
	/**
	 * Basically the higher value the high amount of free rooms
	 * @param b
	 * @return val + contZero
	 */
	public int assessment(Board b) {
		int contZero = 0;
		int val = Integer.MIN_VALUE;
		int codI = 0; int codJ = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if(this.board.get(i, j)==0){contZero++;}
				if(val < this.board.get(i, j)){
					val = this.board.get(i, j);
					codI = i; codJ = j; //keep the coordinates of more
				}
			}	
		}
		if (add(codI,codJ)!=0){val += val;} //there is a movement to add
		return val + contZero;
	}
	
	/**
	 * 
	 * @param i
	 * @param j
	 * @return cont
	 */
	public int add(int i, int j){
		int cont = 0; int p = i; int q = j;
		if ((0 <= p+1) && (p+1 < 4)){
			if (this.board.get(i, j) == this.board.get(p + 1, q)) {cont++;}
		}
		if ((0 <= q+1) && (q+1 < 4)){
			if (this.board.get(i, j) == this.board.get(p, q + 1)) {cont++;}
		}
		if ((0 <= p-1) && (p-1 < 4)){
			if (this.board.get(i, j) == this.board.get(p - 1, q)) {cont++;}
		}
		if ((0 <= q-1) && (q-1 < 4)){
			if (this.board.get(i, j) == this.board.get(p, q - 1)) {cont++;}
		}
		return cont;
	}
}