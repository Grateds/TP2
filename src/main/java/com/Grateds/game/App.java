package com.Grateds.game;

import com.Grateds.game.CONTROLLER.Controller;

/**
 * Hello world!
 *
 */
public class App {
	
    public static void main( String[] args ) {
    	System.out.println( "Hello World!" );
    	Controller controller = new Controller();
        controller.startGame();
    }
}
