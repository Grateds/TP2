package com.Grateds.game.AI;

import java.util.LinkedList;
import java.util.List;

import AI.AdversarySearchEngine;
import AI.AdversarySearchProblem;
import AI.AdversarySearchState;

/**
 * Title:        MinMaxAlfaBetaEngine<p>
 * Description:  Class MinMaxAlfaBetaEngine implements a Alfa Beta search 
                 strategy which can be used with any instance of 
		         AbstractSearchProblem.<p>
 * Copyright:    Copyright (c) Grateds 2014<p>
 * Company:      Grateds <p	
    private List<S> visited; // used to store the visited states
    private List<S> path; // used to store the path to the success.>
 * @author Grateds
 * @version 0.1
 */
public class MinMaxAlfaBetaEngine<P extends AdversarySearchProblem<S>, S extends AdversarySearchState> extends AdversarySearchEngine<P,S>{

    private List<S> visited; // used to store the visited states
    private List<S> path; // used to store the path to the success.
    private int alpha;
    private int beta;
    
	/** 
	 * Constructor for abstract class AdversarySearchEngine 
	 * @pre. true.
	 * @post. This constructor sets maxDepth to 1.
	 */
	public MinMaxAlfaBetaEngine() {
		this.maxDepth = 1;
		this.visited = new LinkedList<S>();
		this.path = new LinkedList<S>();
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
    public MinMaxAlfaBetaEngine(P p) {
    	this.problem = p;
    	this.maxDepth = 1;
    	this.alpha = p.minValue();
    	this.beta = p.maxValue();
    	this.visited = new LinkedList<S>();
    	this.path = new LinkedList<S>();
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public S computeSuccessor(S state) {
	      
		// first, we initialise the data structures for the search
		this.visited = new LinkedList<S>();
		// we get the initial state
		S initialState = this.problem.initialState();

		S resultSearch = minMaxAB(initialState,this.alpha,this.beta,this.maxDepth);
		return resultSearch;
	}

	private S minMaxAB(S s, int a, int b, int d) {
		if (!this.visited.contains(s)) {
			this.visited.add(0, s); // we add s to the list of visited   
            if (this.problem.end(s)) {
				
            	this.path.add(0,s); // we add the success state to the path
				return s;
			
			} // end then branch
			else {
				
				List<S> succ_s = this.problem.getSuccessors(s);
				S found = null;
				while ( (!succ_s.isEmpty()) && (found == null) )  {
					
					S child = succ_s.get(0);
					succ_s.remove(0);
					found = minMaxAB(child, a, b, d-1);
					
				} // end while
				if (found != null) {
					// s leads to a success, so we add it to the path
					this.path.add(0, s);
				}
				return found;
				
			} // end else branch
        }
		else {
			return null;
		}
    } // end of recursiveDepthFirst
	
	@Override
	public void report() {
        System.out.println("Length of path to state when search finished: "+this.path.size());
		System.out.println("Number of visited when search finished: "+this.visited.size());
    } // end of report()
	
} // end of class DepthFirst
