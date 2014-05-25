package com.Grateds.game;

import com.Grateds.game.CONTROLLER.Controller;

/**
 * Main class for 2048 game.
 */
public class App {
	
    public static void main( String[] args ) {
    	Controller controller = new Controller();
        controller.startGame();
    }
}
