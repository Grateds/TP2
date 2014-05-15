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
}