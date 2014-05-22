package com.Grateds.game.AI;

import java.util.LinkedList;
import java.util.List;

import com.Grateds.game.MODEL.Board;

public class AdversaryProblem implements AdversarySearchProblem<AdversaryState> {

    private AdversaryState initial;  // stores the initial state for the problem
			    					 // which can be set when via a constructor.	
    private Board board;
	
    public AdversaryProblem(Board b) {
        this.initial = new AdversaryState(b);
        this.board = b;
    }

    @Override
	public AdversaryState initialState() {
        return this.initial;		
	}

	@Override
	public List<AdversaryState> getSuccessors(AdversaryState state) {
        List<AdversaryState> successors = new LinkedList<AdversaryState>(); // list for storing the successors of s		
        if (state.isMax()) {
            AdversaryState gUp = (AdversaryState) state; 
		    AdversaryState gBelow = (AdversaryState) state;
		    AdversaryState gLeft = (AdversaryState) state;
		    AdversaryState gRight = (AdversaryState) state;
		
		    if (gUp.sucessMoveUp()) successors.add(gUp); 
		    if (gBelow.sucessMoveBellow()) successors.add(gBelow);
		    if (gLeft.sucessMoveLeft()) successors.add(gLeft);
		    if (gRight.sucessMoveRight()) successors.add(gRight);      
        }else{
            // TODO Generate min successors
        }
        return successors;
	}

	@Override
	public boolean end(AdversaryState state) {
		return state.isSucess();
	}

	@Override
	public int value(AdversaryState state) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int minValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int maxValue() {
		// TODO Auto-generated method stub
		return 0;
	}
	
    private int val(Board b) {
		int[] pos = this.posGreater(b);
		int i = pos[0];
		int j =	pos[1];
		int count = 0;
		for (int n = 1; n <= 3; n++) {
			count = n;
			if (isZero(i-n,j-1) || isZero(i,j-1) || isZero(i+n,j-1) || isZero(i+n,j) || isZero(i+n,j+1) || isZero(i,j+1) || isZero(i-n,j+1) || isZero(i-n,j)) 
				break;
		}
		return count + countSub(this.board.get(i, j)/2);
	}
	
	private int countSub(int n) {
		int count = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (this.board.get(i, j) == n) count++;
			}
		}
		return count;
	}
	
	private boolean isZero(int x, int y) {
		if (x > -1  && x < 4 && y > 0 && y < 4) return this.board.get(x, y) == 0;
		else return false;
	}
	
	private int[] posGreater(Board b) {
		int aux = 0;
		int[] temp = { 0, 0 };
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (b.get(i, j) >= aux) {
					aux = b.get(i, j);
					temp[0] = i;
					temp[1] = j;
				}
			}
		}
		return temp;
	}
}