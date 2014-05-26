package com.Grateds.game.AI;

import com.Grateds.game.AI.lib.AdversarySearchState;
import com.Grateds.game.MODEL.Board;

/**
 * Title: AdversaryState
 * Description: class describing the states for the 2048 game.
 * Copyright: Copyright (c) Grateds 2014
 * Company: Grateds
 * 
 * @author Grateds
 * @version 0.1
 */
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
	
	/**
	 * Constructor for AdversaryState class.
	 * @param b
	 * 		is the board to clone on this.
	 */
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
		switch (this.directionToMove) {
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
	 * Return a string representing the direction which the board was moved.
	 */
    public String getMove() {
		switch (this.directionToMove) {
		case 0:
			return " it was moved Up";
	    case 1:
	    	return " it was moved Down";
	    case 2:
	    	return " it was moved Left";
	    default:
	    	return " it was moved Right";
		}
	}
    
    /**
	 * Return true iff a move UP is possible.
	 * @return true iff a move UP is possible.
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
	 * Return true iff a move BELLOW is possible.
	 * @return true iff a move BELLOW is possible.
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
	 * Return true iff a move RIGHT is possible.
	 * @return true iff a move RIGHT is possible.
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
	 * Return true iff a move LEFT is possible.
	 * @return true iff a move LEFT is possible.
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
	 * * Return true iff a move UP is possible.
	 * @return true iff a move UP is possible.
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
	 * Basically, add the amount of free cells plus increases, whichever is more valid than doubled movements
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
		if (this.board.get(0, 0) == val || this.board.get(3, 0) == val ||this.board.get(0, 3) == val ||this.board.get(3, 3) == val) val += val; 
		if (counter(codI,codJ)!=0){val += val;} 
		return val + contZero + this.countNumberOfMerges(2) + this.countNumberOfMerges(4);
	}
	
	/**
	 * Given a position, count the number of valid moves that replicate
	 * @param i
	 * 		is the number of row
	 * @param j
	 * 		is the number of column
	 * @return cont
	 */
	public int counter(int i, int j){
		int cont = 0; int p = i; int q = j;
		if ((0 <= p+1) && (p+1 < 4)){
			if (this.board.get(i, j) == this.board.get(p+1, q)) {cont++;}
		}
		if ((0 <= q+1) && (q+1 < 4)){
			if (this.board.get(i, j) == this.board.get(p, q+1)) {cont++;}
		}
		if ((0 <= p-1) && (p-1 < 4)){
			if (this.board.get(i, j) == this.board.get(p-1, q)) {cont++;}
		}
		if ((0 <= q-1) && (q-1 < 4)){
			if (this.board.get(i, j) == this.board.get(p, q-1)) {cont++;}
		}
		return cont;
	}
	
	/**
	 * Counts the number of merges for n-tiles.
	 * @return number of merges.
	 */
	public int countNumberOfMerges(int n){
		int count = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < 3; j++) {
				if (this.board.get(i, j) == n) {
					if (this.board.get(i, j) == this.board.get(i, j + 1)) {
						count++;
						j++;
					}
				}
			}
		}
	
		for (int j = 0; j < 4; j++) {
			for (int i = 1; i < 3; i++) {
				if (this.board.get(i, j) == n) {
					if (this.board.get(i, j) == this.board.get(i + 1, j)) {
						count++;
						i++;
					}
				}
			}
		}
		return count;
	}
}