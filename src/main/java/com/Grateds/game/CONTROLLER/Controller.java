package com.Grateds.game.CONTROLLER;

import com.Grateds.game.MODEL.Board;

public class Controller {
	
	private Board board;
	
	public Controller() {
		this.board = new Board();
	}
	
	public Board getBoard() {
		return this.board;
	}
	
	public void initialization() {
		this.board.reset();
	}
	
	public void startGame() {
		// TODO Complete this method with adversary
		// Test example
		int[][] t = {
				{128, 0, 8, 0},
				{0, 4, 16, 16},
				{32, 2048, 1024, 16},
				{0, 64, 0, 32}};
		this.board.set(t);
	}
}