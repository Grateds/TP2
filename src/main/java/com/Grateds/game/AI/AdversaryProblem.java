package com.Grateds.game.AI;

import java.util.LinkedList;
import java.util.List;
import com.Grateds.game.AI.lib.AdversarySearchProblem;
import com.Grateds.game.MODEL.Board;


public class AdversaryProblem implements AdversarySearchProblem<AdversaryState> {

    private AdversaryState initial;  // stores the initial state for the problem
			    					  // which can be set when via a constructor.	
    private final int MIN_VALUE = -15;
    private final int MAX_VALUE = 15;

    public AdversaryProblem() {
        this.initial = new AdversaryState();
    }
    
    public AdversaryProblem(AdversaryState initial) {
        this.initial = initial;
    }

    @Override
	public AdversaryState initialState() {
        return this.initial;		
	}

	@Override
	public List<AdversaryState> getSuccessors(AdversaryState state) {
        List<AdversaryState> successors = new LinkedList<AdversaryState>(); // list for storing the successors of s		
        if (state.isMax()) {
            AdversaryState gUp = state.clone(); 
		    AdversaryState gBelow = state.clone(); 
		    AdversaryState gLeft = state.clone(); 
		    AdversaryState gRight = state.clone(); 
		
		    if (gUp.sucessMoveUp()) {
		    	gUp.setMin();
		    	gUp.setDirection(0);
		    	successors.add((AdversaryState) gUp.ruleApplied()); 
		    }
		    if (gBelow.sucessMoveBellow()) {
		    	gBelow.setMin();
		    	gBelow.setDirection(1);
		    	successors.add((AdversaryState) gBelow.ruleApplied());
		    }
		    if (gLeft.sucessMoveLeft()) {
		    	gLeft.setMin();
		    	gLeft.setDirection(2);
		    	successors.add((AdversaryState) gLeft.ruleApplied());
		    }
		    if (gRight.sucessMoveRight()) {
		    	gRight.setMin();
		    	gRight.setDirection(3);
		    	successors.add((AdversaryState) gRight.ruleApplied());      
		    }
        }else{
        	int n = 2;
        	while (n < 5) {
        		for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 4; j++) {
						Board temp = state.getBoard();
						if (temp.get(i, j) == 0) {
							temp.set(i, j, n);
							AdversaryState stateAux = new AdversaryState(temp);
							stateAux.setMax();
							successors.add(stateAux);
						}
					}
				}
				n +=2;
			}
		}
        return successors;
	}

	@Override
	public boolean end(AdversaryState state) {
		return this.getSuccessors(state).size() == 0 || state.isSucess();
	}

	@Override
	public int value(AdversaryState state) {
		return state.getValoration();
	}

	@Override
	public int minValue() {
		return MIN_VALUE;
	}

	@Override
	public int maxValue() {
		return MAX_VALUE;
	}    
}