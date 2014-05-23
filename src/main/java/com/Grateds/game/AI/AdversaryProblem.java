package com.Grateds.game.AI;

import java.util.LinkedList;
import java.util.List;

import com.Grateds.game.MODEL.Board;

import AI.AdversarySearchProblem;

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
            AdversaryState gUp = (AdversaryState) state; gUp.setMin();
		    AdversaryState gBelow = (AdversaryState) state; gBelow.setMin();
		    AdversaryState gLeft = (AdversaryState) state; gLeft.setMin();
		    AdversaryState gRight = (AdversaryState) state; gRight.setMin();
		
		    if (gUp.sucessMoveUp()) successors.add(gUp); 
		    if (gBelow.sucessMoveBellow()) successors.add(gBelow);
		    if (gLeft.sucessMoveLeft()) successors.add(gLeft);
		    if (gRight.sucessMoveRight()) successors.add(gRight);      
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
		int cont = 0;
		boolean zero = false;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (state.isZero(i, j)){
					cont++;
				}
					
			}
		}
		if (cont > 0){zero = true;}
		return !zero && !state.sucessMoveBellow() && !state.sucessMoveLeft() && !state.sucessMoveRight() && !state.sucessMoveUp();
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