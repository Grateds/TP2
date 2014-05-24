package com.Grateds.game.AI;

import AI.AdversarySearchState;
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

	public void setMax() {
		this.isMax = true;
	}
	
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
		return this.board;
	}

	/**
	 * Basically the higher value the high amount of free rooms
	 * @param b
	 * @return val + contZero
	 */
	public int assessment(Board b) {
		int contZero = 0;
		int val = Integer.MIN_VALUE;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if(this.board.get(i, j)==0){contZero++;}
				if(val < this.board.get(i, j)){
					val = this.board.get(i, j);
				}
			}	
		}
		return val + contZero;
	}
	
	/**
	 * 
	 * @param b
	 * @return
	 */
	private int val(Board b) {
		int[] pos = this.posGreater(b);
		int i = pos[0];
		int j =	pos[1];
		int count = 0;
		for (int n = 1; n <= 3; n++) {
			count = n;
			if (isZero(i-n,j-1) || isZero(i,j-1) || isZero(i+n,j-1) || isZero(i+n,j) || isZero(i+n,j+1) || isZero(i,j+1) || isZero(i-n,j+1) || isZero(i-n,j)) 
				break;
		}
		return count + countSub(this.board.get(i, j)/2);
	}

	/**
	 * 
	 * @param n
	 * @return
	 */
	private int countSub(int n) {
		int count = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (this.board.get(i, j) == n) count++;
			}
		}
		return count;
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean isZero(int x, int y) {
		if (x > -1  && x < 4 && y > 0 && y < 4) return this.board.get(x, y) == 0;
		else return false;
	}
	
	/**
	 * 
	 * @param b
	 * @return
	 */
	private int[] posGreater(Board b) {
		int aux = 0;
		int[] temp = { 0, 0 };
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (b.get(i, j) >= aux) {
					aux = b.get(i, j);
					temp[0] = i;
					temp[1] = j;
				}
			}
		}
		return temp;
	}
	
}