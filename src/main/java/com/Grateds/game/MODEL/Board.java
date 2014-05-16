package com.Grateds.game.MODEL;

/**
 * Title:        Board<p>
 * Description:  class describing the sboard for the 2048 game Problem.
 * Copyright:    Copyright (c) Grateds 2014<p>
 * Company:      Grateds<p>
 * @author Grateds
 * @version 0.1
 */

public class Board {
	
	private final int N = 4;
	private int[][] board;
	
	public Board (){
		this.board = new int[N][N];
	}
	
	public int get(int x, int y) {
		if (x < 0 || y < 0) throw new IllegalArgumentException("The position must be positive");
		return this.board[x][y];
	}
	
	public void set(int x, int y, int value) {
		if (x < 0 || y < 0) throw new IllegalArgumentException("The position must be positive");
		if (value < 0) throw new IllegalArgumentException("The value must be positive");
		this.board[x][y] = value;
	}
	
	public boolean equals(Board b) {
		boolean val = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (this.board[i][j] != b.get(i, j))
					return false;
			}
		}
		return val;
	}
	
	public String toString() {
		String s = "";
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				s = s+  this.board[i][j] +" ";
			}
			s = s + "\n";
		}
		return s;
	}
	
	public void reset() {
		this.board = new int[4][4];
	}
	
	public boolean contains(int x) {
		boolean val = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (this.board[i][j] == x)
					return true;
			}
		}
		return val;
	}
	
	/**
	 * 
	 */
	public void movingUp(){ 
		int [] c0 = {this.board[0][0], this.board[1][0], this.board[2][0], this.board[3][0]}; //Columna cero		
		int [] c1 = {this.board[0][1], this.board[1][1], this.board[2][1], this.board[3][1]}; 	
		int [] c2 = {this.board[0][2], this.board[1][2], this.board[2][2], this.board[3][2]};		
		int [] c3 = {this.board[0][3], this.board[1][3], this.board[2][3], this.board[3][3]};	   
	    subValidMotion(c0);
	    subValidMotion(c1);
	    subValidMotion(c2);
	    subValidMotion(c3);  
	    pasaArregloAMatriz(c0,c1,c2,c3);
	}
	
	/**
	 * 
	 */
	public void movingBelow(){ 
		//TODO Implement this method
	}
	
	/**
	 * 
	 */
	public void movingRight(){ 
		//TODO Implement this method
	}
	
	/**
	 * 
	 */
	public void movingLeft(){
		//TODO Implement this method
	}
	
	/**
	 * 
	 * @param c
	 */
	public void subValidMotion(int [] c){
		for (int m = 0; m < 4; m++) {
			int i = 0;
			int j = 1;
			while (i < j && j < 4) {
				if (c[i] == 0){
					c[i] = c[j];
			    	c[j] = 0;
			    }
			    if (c[i] == c[j]){
			    	c[i] += c[j];
			    	c[j] = 0;
			    }
			    i = j;
			    j++;
			}	
		}
	}
	
	/**
	 * 
	 * @param c0
	 * @param c1
	 * @param c2
	 * @param c3
	 */
	public void pasaArregloAMatriz(int [] c0, int [] c1, int [] c2, int [] c3){
		for (int k = 0; k < 4; k++) {
			this.board[k][0] = c0[k];
		}
		for (int k = 0; k < 4; k++) {
			this.board[k][1] = c1[k];
		}
		for (int k = 0; k < 4; k++) {
			this.board[k][2] = c2[k];
		}
		for (int k = 0; k < 4; k++) {
			this.board[k][3] = c3[k];
		}
	}
}
