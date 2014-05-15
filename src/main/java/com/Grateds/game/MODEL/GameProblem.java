package com.Grateds.game.MODEL;

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
	 * 
	 * @param b
	 */
	public GameProblem(Board b) {
		this.initial = new GameState(b);
	}
	
	@Override
	public GameState initialState() {
		return this.initial;
	}

	@Override
	public List<GameState> getSuccessors(GameState s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean success(GameState s) {
		return s.isSucess();
	}
}
