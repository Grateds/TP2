package com.Grateds.game.MODEL;

import java.util.LinkedList;
import java.util.List;

import com.Grateds.game.AI.AbstractSearchProblem;

/**
 * Title:        GameProblem<p>
 * Description:  class describing the basic for the two 2048 game as a search problem.
 * It extends the abstract class AbstractSearchProblem. <p>
 * Copyright:    Copyright (c) Grateds 2014<p>
 * Company:      Grateds<p>
 * @author Grateds
 * @version 0.1
 */

public class GameProblem implements AbstractSearchProblem<GameState>  {
	
	private GameState initial;  // stores the initial state for the problem
								 // which can be set when via a constructor.	
	/**
	 * TODO Complete this do
	 * @param b
	 */
	public GameProblem(Board b) {
		this.initial = new GameState(b);
	}
	
	/**
	 * TODO Complete this do
	 */
	@Override
	public GameState initialState() {
		return this.initial;
	}
    
	/**
	 * TODO Complete this do
	 */
	@Override
	public List<GameState> getSuccessors(GameState s) {
		List<GameState> successors = new LinkedList<GameState>(); // list for storing the successors of s
		GameState gUp = (GameState) s; 
		GameState gBelow = (GameState) s;
		GameState gLeft = (GameState) s;
		GameState gRight = (GameState) s;
		
		if (gUp.sucessMoveUp()) successors.add(gUp); 
		if (gBelow.sucessMoveBellow()) successors.add(gBelow);
		if (gLeft.sucessMoveLeft()) successors.add(gLeft);
		if (gRight.sucessMoveRight()) successors.add(gRight);
		
		return successors;
	}
    
	/**
	 * TODO Complete this doc
	 */
	@Override
	public boolean success(GameState s) {
		return s.isSucess();
	}
	
	/**
	 * TODO Complete this doc
	 */
	@SuppressWarnings("unused") // Suppress this warning once implemented 
	private int val(GameState s) {
		// TODO Implement this method
		return 0;
	}
}
