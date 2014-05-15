package com.Grateds.game.AI;
import java.util.*;

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


public class MinMaxAlfaBetaEngine<S extends State, Problem extends AbstractSearchProblem<S>> extends AbstractSearchEngine<S,Problem> {

	public MinMaxAlfaBetaEngine() {
		super();
	}
	
	public MinMaxAlfaBetaEngine(Problem p) {
		super(p);
	}
	
	public boolean performSearch() {
		//TODO Implement this method
		return false;

	} // end of method performSearch

	public List<S> getPath() {
		//TODO Implement this method
		return null;
	} // end of getPath()

	public void report() {
		//TODO Implement this method
	} // end of report()
} // end of class DepthFirst
