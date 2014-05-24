package com.Grateds.game.AI;

import java.util.List;
import AI.AdversarySearchEngine;
import AI.AdversarySearchProblem;
import AI.AdversarySearchState;

/**
 * Title:        MinMaxAlfaBetaEngine<p>
 * Description:  Class MinMaxAlfaBetaEngine implements a Alpha Beta search 
                 strategy which can be used with any instance of 
		         AbstractSearchProblem.<p>
 * Copyright:    Copyright (c) Grateds 2014<p>
 * Company:      Grateds <p	
    private List<S> visited; // used to store the visited states
    private List<S> path; // used to store the path to the success.>
 * @author Grateds
 * @version 0.1
 */
public class MinMaxAlphaBetaPruningEngine<P extends AdversarySearchProblem<S>, S extends AdversarySearchState> extends AdversarySearchEngine<P,S>{

	private int visited;
    private int alpha;
    private int beta;
    
	/** 
	 * Constructor for abstract class AdversarySearchEngine 
	 * @pre. true.
	 * @post. This constructor sets maxDepth to 1.
	 */
	public MinMaxAlphaBetaPruningEngine() {
		this.maxDepth = 1;
		this.visited = -1;
		this.alpha = 1;
		this.beta = -1;
	};
    
	/** 
	 * Constructor for abstract class AbstractSearchEngine.
	 * @param p is the abstract search problem associated with the engine
	 * being created.
	 * @pre. p!=null.
	 * @post. A reference to p is stored in field problem and maxDepth
	 * is set to 1.
	 */	
    public MinMaxAlphaBetaPruningEngine(P p) {
    	this.problem = p;
    	this.maxDepth = 1;
    	this.alpha = p.minValue();
    	this.beta = p.maxValue();
    	this.visited = 0;
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
    public MinMaxAlphaBetaPruningEngine(P p, int maxDepth) {
    	this.problem = p;
        this.maxDepth = maxDepth;
        this.alpha = p.minValue();
        this.beta = p.maxValue();
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
		return this.problem;
	}

	/** 
	 * Sets the problem associated with the search engine.
	 * @param p is the search problem to be used for search (to set 'problem' to).
	 * @pre. p!=null.
	 * @post. 'problem' is set to p.
	 */	
    public void setProblem(P p) {
    	this.problem = p;
    }

	@Override
	public int computeValue(S state) {
		return this.aphaBetaPruning(state, alpha, beta, maxDepth);
	}

	@Override
	public S computeSuccessor(S state) {
		List<S> succ = problem.getSuccessors(state);
		S res = null;
		int helper = Integer.MIN_VALUE;
		for(S leaf : succ){
			int value = computeValue(leaf);
			if ( value > helper){
				helper = value;
				res = leaf;
			}
		}
		return res;
	}

	private int aphaBetaPruning(S s, int a, int b, int d) {
		visited++;
        if (d==0 || this.problem.end(s)) {
			return this.problem.value(s);
		} else {
			List<S> succ = problem.getSuccessors(s);
			for (S leaf : succ) {
				if (alpha > beta) break;
				if (s.isMax()) alpha = Math.max(alpha, aphaBetaPruning(leaf, a, b, d-1));
				else beta = Math.min(beta, aphaBetaPruning(leaf, a, b, d-1));
			}
			if (s.isMax()) return alpha;
			else return beta;
		} 					
    } 
	
	@Override
	public void report() {
		System.out.println("Number of visited when search finished: "+visited);
	}
} 
