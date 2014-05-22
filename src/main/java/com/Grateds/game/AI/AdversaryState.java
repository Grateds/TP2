package com.Grateds.game.AI;

import com.Grateds.game.MODEL.Board;

public class AdversaryState implements AdversarySearchState {
	
	private Board board; // game board 
	private boolean isMax;

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

	@Override
	public Object ruleApplied() {
		// TODO Auto-generated method stub
		return null;
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
}