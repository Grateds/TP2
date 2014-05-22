package com.Grateds.game.AI;

import AI.AdversarySearchEngine;
import AI.AdversarySearchProblem;
import AI.AdversarySearchState;

/**
 * Title:        MinMaxAlfaBetaEngine<p>
 * Description:  Class MinMaxAlfaBetaEngine implements a Alfa Beta search 
                 strategy which can be used with any instance of 
		         AbstractSearchProblem.<p>
 * Copyright:    Copyright (c) Grateds 2014<p>
 * Company:      Grateds <p>
 * @author Grateds
 * @version 0.1
 */

public class MinMaxAlfaBetaEngine<P extends AdversarySearchProblem<State>, State extends AdversarySearchState>  extends AdversarySearchEngine<P, State> {

	/** 
	 * Constructor for abstract class AdversarySearchEngine 
	 * @pre. true.
	 * @post. This constructor sets maxDepth to 1.
	 */
	public MinMaxAlfaBetaEngine() {
		maxDepth = 1;
	};
    
	/** 
	 * Constructor for abstract class AbstractSearchEngine.
	 * @param p is the abstract search problem associated with the engine
	 * being created.
	 * @pre. p!=null.
	 * @post. A reference to p is stored in field problem and maxDepth
	 * is set to 1.
	 */	
    public MinMaxAlfaBetaEngine(P p) {
        problem = p;
        maxDepth = 1;
    }
    
	/** 
	 * Constructor for abstract class AbstractSearchEngine.
	 * @param p is the abstract search problem associated with the engine
	 * being created.
	 * @param maxDepth is a value to set this.maxDepth to.
	 * @pre. p!=null and maxDepth>=1.
	 * @post. A reference to p is stored in field problem and 
	 * this.maxDepth is set to maxDepth.
	 */	
    public MinMaxAlfaBetaEngine(P p, int maxDepth) {
        problem = p;
        this.maxDepth = maxDepth;
    }
    
	/** 
	 * Returns the maximum depth to be used for search. This value
	 * indicates how many game moves in the future are going to be
	 * explored in order to compute the value for a state.
	 * @return the maximum depth to be used for search.
	 * @pre. true.
	 * @post. the value of maxDepth is returned.
	 */	   
	public int getMaxDepth() {
		return maxDepth;
	}

	/** 
	 * Sets the maximum depth to be used for search. This value
	 * indicates how many game moves in the future are going to be
	 * explored in order to compute the value for a state.
	 * @param maxDepth is the value used to set this.maxDepth. 
	 * @pre. maxDepth >= 1.
	 * @post. this.maxDepth is set to maxDepth.
	 */	 
	public void setMaxDepth(int maxDepth) {
		this.maxDepth = maxDepth;
	}

	/** 
	 * Returns the problem associated with this search engine.
	 * @return a reference to the problem associated with this
	 * search engine. 
	 * @pre. true.
	 * @post. this.problem is returned.
	 */	 
	public P getProblem() {
		return problem;
	}

	/** 
	 * Sets the problem associated with the search engine.
	 * @param p is the search problem to be used for search (to set 'problem' to).
	 * @pre. p!=null.
	 * @post. 'problem' is set to p.
	 */	
    public void setProblem(P p) {
        problem = p;
    }

	@Override
	public int computeValue(State state) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public State computeSuccessor(State state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void report() {
		// TODO Auto-generated method stub
		
	}
} // end of class DepthFirst
