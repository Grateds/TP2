package com.Grateds.game;

import com.Grateds.game.MODEL.Board;

/**
 * Hello world!
 *
 */
public class App {
	
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        
        // PRUEBA A LO CHASTRIN
        Board b = new Board();
        b.set(0, 0, 0);
        b.set(0, 2, 4);
        b.set(0, 3, 8);
        b.set(1, 3, 16);
        b.set(2, 2, 4);
        b.set(2, 3, 32);
        b.set(3, 2, 4);
        b.set(3, 3, 0);
        b.set(3, 0, 2);
        // Matriz antes
        for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(b.get(i,j)+ " ");
			}
			System.out.println(" ");
		}
        System.out.println(" ");
        
        b.movingUp();
        
        //Matriz despues
        for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(b.get(i,j)+ " ");
			}
			System.out.println(" ");
		}
    }
}
