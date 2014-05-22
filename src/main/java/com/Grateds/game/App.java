package com.Grateds.game;

import com.Grateds.game.CONTROLLER.Controller;
import com.Grateds.game.GUI.Puzzle;

/**
 * Hello world!
 *
 */
public class App {
	
    public static void main( String[] args ) {
    	System.out.println( "Hello World!" );
    	Controller controller = new Controller();
    	Puzzle puzzle = new Puzzle(controller);
        puzzle.setVisible(true);
        controller.startGame();
    }
}
