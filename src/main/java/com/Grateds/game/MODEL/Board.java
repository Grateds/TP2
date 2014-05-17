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
	
	/**
	 * TODO Complete this doc
	 */
	public Board (){
		this.board = new int[N][N];
	}
	
	/**
	 * TODO Complete this doc
	 * @param x
	 * @param y
	 * @return
	 */
	public int get(int x, int y) {
		if (x < 0 || y < 0) throw new IllegalArgumentException("The position must be positive");
		return this.board[x][y];
	}
	
	/**
	 * TODO Complete this doc
	 * @param x
	 * @param y
	 * @param value
	 */
	public void set(int x, int y, int value) {
		if (x < 0 || y < 0) throw new IllegalArgumentException("The position must be positive");
		if (value < 0) throw new IllegalArgumentException("The value must be positive");
		this.board[x][y] = value;
	}
	
	/**
	 * TODO Complete this doc
	 * @param t
	 */
	public void set(int[][] t) {
		this.board = t.clone();
	}
	
	/**
	 * TODO Complete this doc
	 * @param b
	 * @return
	 */
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
	
	/**
	 * TODO Complete this doc
	 */
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
	
	/**
	 * TODO Complete this doc
	 */
	public void reset() {
		this.board = new int[4][4];
	}
	
	/**
	 * TODO Complete this doc
	 * @param x
	 * @return
	 */
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
	 * TODO Complete this doc
	 */
	public Board movingUp(){ 
		int [] c0 = {this.board[0][0], this.board[1][0], this.board[2][0], this.board[3][0]}; 	
		int [] c1 = {this.board[0][1], this.board[1][1], this.board[2][1], this.board[3][1]}; 	
		int [] c2 = {this.board[0][2], this.board[1][2], this.board[2][2], this.board[3][2]};		
		int [] c3 = {this.board[0][3], this.board[1][3], this.board[2][3], this.board[3][3]};	   
	    subValidMotion(c0);
	    subValidMotion(c1);
	    subValidMotion(c2);
	    subValidMotion(c3);  

	    Board sucBoard = new Board();
	    sucBoard.board = this.board.clone();
	    sucBoard.set(pasaArregloAMatrizUp(c0,c1,c2,c3));;
	    return sucBoard;
	}
	
	/**
	 * TODO Complete this doc
	 */
	public Board movingBelow(){ 
		int [] c0 = {this.board[3][0], this.board[2][0], this.board[1][0], this.board[0][0]}; 	
		int [] c1 = {this.board[3][1], this.board[2][1], this.board[1][1], this.board[0][1]}; 	
		int [] c2 = {this.board[3][2], this.board[2][2], this.board[1][2], this.board[0][2]};		
		int [] c3 = {this.board[3][3], this.board[2][3], this.board[1][3], this.board[0][3]};	 
		subValidMotion(c0);
		subValidMotion(c1);
		subValidMotion(c2);
		subValidMotion(c3);  

		Board sucBoard = new Board();
		sucBoard.board = this.board.clone();
		sucBoard.set(pasaArregloAMatrizBelow(c0,c1,c2,c3));;
		return sucBoard;
	}
	
	/**
	 * TODO Complete this doc
	 */
	public Board movingRight(){ 
		int [] c0 = {this.board[0][3], this.board[0][2], this.board[0][1], this.board[0][0]}; 	
		int [] c1 = {this.board[1][3], this.board[1][2], this.board[1][1], this.board[1][0]}; 	
		int [] c2 = {this.board[2][3], this.board[2][2], this.board[2][1], this.board[2][0]};		
		int [] c3 = {this.board[3][3], this.board[3][2], this.board[3][1], this.board[3][0]};	 
		subValidMotion(c0);
		subValidMotion(c1);
		subValidMotion(c2);
		subValidMotion(c3);

		Board sucBoard = new Board();
		sucBoard.board = this.board.clone();
		sucBoard.set(pasaArregloAMatrizRight(c0,c1,c2,c3));;
		return sucBoard;

	}

	/**
	 * TODO Complete this doc
	 */
	public Board movingLeft(){
		int [] c0 = {this.board[0][0], this.board[0][1], this.board[0][2], this.board[0][3]}; 	
		int [] c1 = {this.board[1][0], this.board[1][1], this.board[1][2], this.board[1][3]}; 	
		int [] c2 = {this.board[2][0], this.board[2][1], this.board[2][2], this.board[2][3]};		
		int [] c3 = {this.board[3][0], this.board[3][1], this.board[3][2], this.board[3][3]};	 
		subValidMotion(c0);
		subValidMotion(c1);
		subValidMotion(c2);
		subValidMotion(c3);
		
		Board sucBoard = new Board();
		sucBoard.board = this.board.clone();
		sucBoard.set(pasaArregloAMatrizLeft(c0,c1,c2,c3));;
		return sucBoard;
	}
	
	/**
	 * TODO Complete this doc
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
	 * TODO Complete this doc
	 * @param c0
	 * @param c1
	 * @param c2
	 * @param c3
	 */
	public int[][] pasaArregloAMatrizUp(int [] c0, int [] c1, int [] c2, int [] c3){
		int[][] res = new int[4][4];
		for (int k = 0; k < 4; k++) {
			res[k][0] = c0[k];
		}
		for (int k = 0; k < 4; k++) {
			res[k][1] = c1[k];
		}
		for (int k = 0; k < 4; k++) {
			res[k][2] = c2[k];
		}
		for (int k = 0; k < 4; k++) {
			res[k][3] = c3[k];
		}
		return res;
	}
	
	/**
	 * TODO Complete this doc
	 * @param c0
	 * @param c1
	 * @param c2
	 * @param c3
	 */
	public int[][] pasaArregloAMatrizBelow(int [] c0, int [] c1, int [] c2, int [] c3){
		int[][] res = new int[4][4];
		int m = 0;
		int k1 = 3;
		while (m < 4) {
			res[k1][0] = c0[m];
			k1--;
			m++;
		}
		int n = 0;
		int k2 = 3;
		while (n < 4) {
			res[k2][1] = c1[n];
			k2--;
			n++;
		}
		int o = 0;
		int k3 = 3;
		while (o < 4) {

			res[k3][2] = c2[o];

			k3--;
			o++;
		}
		int p = 0;
		int k4 = 3;
		while ( p < 4) {

			res[k4][3] = c3[p];
			k4--;
			p++;
		}
		return res;
	}
	
	/**
	 * TODO Complete this doc
	 * @param c0
	 * @param c1
	 * @param c2
	 * @param c3
	 */
	public int[][] pasaArregloAMatrizRight(int [] c0, int [] c1, int [] c2, int [] c3) {
		int[][] res = new int[4][4];
		int m = 0;
		int k1 = 3;
		while (m < 4) {
			res[0][k1] = c0[m];

			k1--;
			m++;
		}
		int n = 0;
		int k2 = 3;
		while (n < 4) {

			res[1][k2] = c1[n];

			k2--;
			n++;
		}
		int o = 0;
		int k3 = 3;
		while (o < 4) {

			res[2][k3] = c2[o];

			k3--;
			o++;
		}
		int p = 0;
		int k4 = 3;
		while ( p < 4) {

			res[3][k4] = c3[p];
			k4--;
			p++;
		}
		return res;

	}
	
	/**
	 * TODO Complete this doc
	 * @param c0
	 * @param c1
	 * @param c2
	 * @param c3
	 */
	public int[][] pasaArregloAMatrizLeft(int [] c0, int [] c1, int [] c2, int [] c3) {
		int[][] res = new int[4][4];
		for (int i = 0; i < 4; i++) {
			res[0][i] = c0[i];
		}
		for (int j = 0; j < 4; j++) {
			res[1][j] = c1[j];
		}
		for (int k = 0; k < 4; k++) {
			res[2][k] = c2[k];
		}
		for (int m = 0; m < 4; m++) {
			res[3][m] = c3[m];
		}
		return res;
	}
}
