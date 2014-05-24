package com.Grateds.game.MODEL;

import java.util.Observable;

/**
 * Title: Board
 * Description: class describing the sboard for the 2048 game Problem.
 * Copyright: Copyright (c) Grateds 2014
 * Company: Grateds
 * 
 * @author Grateds
 * @version 0.1
 */

public class Board {

	private final int N = 4;
	private int[][] board;

	/**
	 * Default constructor.
	 */
	public Board() {
		this.board = new int[N][N];
	}
	
	/**
	 * 
	 */
	public void initialization() {
		int x = (int) (Math.random() * (3  + 1));
		int y = (int) (Math.random() * (3  + 1));
		int r = (int) (Math.random() * 2);
		this.set(x, y, r==0 ? 2 : 4);
		
		r = (int) (Math.random() * 2);
		while (this.get(x, y) != 0) {
			x = (int) (Math.random() * (3  + 1));
			y = (int) (Math.random() * (3  + 1));
		}
		this.set(x, y, r==0 ? 2 : 4);
	}

	/**
	 * Returns the value at the specified position.
	 * @param x
	 * 		is the number of row
	 * @param y
	 * 		is the number of column
	 * @return the value at row 'x' and column 'y'.
	 * @throws IndexOutOfBoundsException
	 */
	public int get(int x, int y) {
		if (x < 0 || y < 0 || x > 3 || y > 3)	throw new IllegalArgumentException("The position must be on range");
		return this.board[x][y];
	}
	
	/**
	 * Replace the element at the specified position with the specified element
	 * @param x
	 * 		is the number of row
	 * @param y
	 * 		is the number of column
	 * @param value
	 * 		is the element to be stored at the specified position
	 * @throws IndexOutOfBoundsException
	 */
	public void set(int x, int y, int value) {
		if (x < 0 || y < 0 || x > 3 || y > 3)	throw new IllegalArgumentException("The position must be on range");
		if (value < 0) throw new IllegalArgumentException("The value must be positive");
		this.board[x][y] = value;
	}

	/**
	 * Replace all elements in the matrix with the specified matrix.
	 * @param t
	 * 		is the matrix to clone.
	 */
	public void set(int[][] t) {
		this.board = t.clone();
	}

	/**
	 * Checks whether 'this' is equal to another board.
	 * @param b
	 * 		is the board to compare.
	 * @return true iff 'this' is equal to 'other'.
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
	 * Returns a representation as a string of the current board.
	 * @return a string representing the current board.
	 */
	public String toString() {
		String s = "";
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) 
				s = s + this.board[i][j] + " ";
			s = s + "\n";
		}
		return s;
	}

	/**
	 * Turns the current board to the initial state.
	 */
	public void reset() {
		this.board = new int[4][4];
	}

	/**
	 * Checks whether 'this' contains the 'x' element.
	 * @param x
	 * 		is a type of board element.
	 * @return true iff 'x' belongs to 'this'.
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
	 * Moves the data from down to up by combining consecutive equal elements.
	 * @return a resulting board after an "Up move".
	 */
	public Board movingUp() {
		int[] col0 = { this.board[0][0], this.board[1][0], this.board[2][0], this.board[3][0] };
		int[] col1 = { this.board[0][1], this.board[1][1], this.board[2][1], this.board[3][1] };
		int[] col2 = { this.board[0][2], this.board[1][2], this.board[2][2], this.board[3][2] };
		int[] col3 = { this.board[0][3], this.board[1][3], this.board[2][3], this.board[3][3] };

		motion(col0, col1, col2, col3);
		Board sucBoard = new Board();
		sucBoard.board = this.board.clone();
		sucBoard.set(pasaArregloAMatrizUp(col0, col1, col2, col3));
		
		return sucBoard;
	}

	/**
	 * Moves the data from up to down by combining consecutive equal elements.
	 * @return a resulting board after a "Down move".
	 */
	public Board movingBelow() {
		int[] col0 = { this.board[3][0], this.board[2][0], this.board[1][0], this.board[0][0] };
		int[] col1 = { this.board[3][1], this.board[2][1], this.board[1][1], this.board[0][1] };
		int[] col2 = { this.board[3][2], this.board[2][2], this.board[1][2], this.board[0][2] };
		int[] col3 = { this.board[3][3], this.board[2][3], this.board[1][3], this.board[0][3] };

		motion(col0, col1, col2, col3);
		Board sucBoard = new Board();
		sucBoard.board = this.board.clone();
		sucBoard.set(pasaArregloAMatrizBelow(col0, col1, col2, col3));
		
		return sucBoard;
	}

	/**
	 * Moves the data from left to right by combining consecutive equal elements.
	 * @return a resulting board after a "Right move".
	 */
	public Board movingRight() {
		int[] row0 = { this.board[0][3], this.board[0][2], this.board[0][1], this.board[0][0] };
		int[] row1 = { this.board[1][3], this.board[1][2], this.board[1][1], this.board[1][0] };
		int[] row2 = { this.board[2][3], this.board[2][2], this.board[2][1], this.board[2][0] };
		int[] row3 = { this.board[3][3], this.board[3][2], this.board[3][1], this.board[3][0] };

		motion(row0, row1, row2, row3);
		Board sucBoard = new Board();
		sucBoard.board = this.board.clone();
		sucBoard.set(pasaArregloAMatrizRight(row0, row1, row2, row3));
		
		return sucBoard;
	}

	/**
	 * Moves the data from right to left by combining consecutive equal elements.
	 * @return a resulting board after a "Left move".
	 */
	public Board movingLeft() {
		int[] row0 = { this.board[0][0], this.board[0][1], this.board[0][2], this.board[0][3] };
		int[] row1 = { this.board[1][0], this.board[1][1], this.board[1][2], this.board[1][3] };
		int[] row2 = { this.board[2][0], this.board[2][1], this.board[2][2], this.board[2][3] };
		int[] row3 = { this.board[3][0], this.board[3][1], this.board[3][2], this.board[3][3] };

		motion(row0, row1, row2, row3);
		Board sucBoard = new Board();
		sucBoard.board = this.board.clone();
		sucBoard.set(pasaArregloAMatrizLeft(row0, row1, row2, row3));
		return sucBoard;
	}

	/**
	 * TODO Complete this doc
	 * @param c
	 */
	private void subValidMotion(int[] c) {
		int i = 0;
		int j = 1;
		while (j < 4) {
			if (c[i] == 0 && c[j] == 0) {
				j++;
			}else
			if (c[i] != 0 && c[j] == 0) {
				j++;
			}else		
			if (c[i] == 0 && c[j] != 0) {
				c[i] = c[j];
				c[j] = 0;
				j++;
			}else
			if (c[i] != 0 && c[j] != 0 && c[i] == c[j]) {
				c[i] += c[j];
				c[j] = 0;
				i++; j++;
			}else
			if (c[i] != 0 && c[j] != 0 && c[i] != c[j]) {
				if (c[i+1] == 0) {
					c[i+1] = c[j];
					c[j] = 0;
				}
				i++;
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
	 * @return
	 */
	private int[][] pasaArregloAMatrizUp(int[] c0, int[] c1, int[] c2, int[] c3) {
		int[][] res = new int[4][4];
		for (int k = 0; k < 4; k++) 
			res[k][0] = c0[k];
		for (int k = 0; k < 4; k++) 
			res[k][1] = c1[k];
		for (int k = 0; k < 4; k++) 
			res[k][2] = c2[k];
		for (int k = 0; k < 4; k++) 
			res[k][3] = c3[k];
		return res;
	}

	/**
	 * TODO Complete this doc
	 * @param c0
	 * @param c1
	 * @param c2
	 * @param c3
	 * @return
	 */
	private int[][] pasaArregloAMatrizBelow(int[] c0, int[] c1, int[] c2, int[] c3) {
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
		while (p < 4) {
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
	 * @return
	 */
	private int[][] pasaArregloAMatrizRight(int[] c0, int[] c1, int[] c2, int[] c3) {
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
		while (p < 4) {
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
	 * @return
	 */
	private int[][] pasaArregloAMatrizLeft(int[] c0, int[] c1, int[] c2,	int[] c3) {
		int[][] res = new int[4][4];
		for (int i = 0; i < 4; i++) 
			res[0][i] = c0[i];
		for (int j = 0; j < 4; j++) 
			res[1][j] = c1[j];
		for (int k = 0; k < 4; k++) 
			res[2][k] = c2[k];
		for (int m = 0; m < 4; m++) 
			res[3][m] = c3[m];
		return res;
	}

	/**
	 * TODO Complete this doc
	 * @param c0
	 * @param c1
	 * @param c2
	 * @param c3
	 */
	private void motion(int[] c0, int[] c1, int[] c2, int[] c3) {
		subValidMotion(c0);
		subValidMotion(c1);
		subValidMotion(c2);
		subValidMotion(c3);
	}

	/**
	 * Puts a random number(2 o 4) in an empty space on the board
	 */
	public void randomBoard(){
		int x = (int) (Math.random() * (3  + 1));
		int y = (int) (Math.random() * (3  + 1));
		
	}
}
