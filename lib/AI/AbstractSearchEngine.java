package AI;

/**
 * Title:        AbstractSearchEngine
 * Description:  class AbstractSearchEngine: abstract class which defines the basic 
 * elements that are required for a search engine. Different search strategies 
 * should extend this class.  
 * Copyright:    Copyright (c) Grateds 2014
 * Company:      Grateds
 * @author Grateds
 * @version 0.1
 */

import java.util.*; // necessary for the use of lists

abstract public class AbstractSearchEngine<S extends State, Problem extends AbstractSearchProblem<S>> {
	
    // a reference to the problem to apply search to
    protected Problem problem;
    
	/** 
	 * Constructor for abstract class AbstractSearchEngine 
	 * @pre. true.
	 * @post. This constructor does nothing (skip).
	 */
	public AbstractSearchEngine() {};
    
	/** 
	 * Constructor for abstract class AbstractSearchEngine.
	 * @param p is the abstract search problem associated with the engine
	 * being created.
	 * @pre. p!=null.
	 * @post. A reference to p is stored in field problem.
	 */	
    public AbstractSearchEngine(Problem p) {
        problem = p;
    }
    
	/** 
	 * Returns the path to a previously calculated successful state for problem. 
	 * Extensions of this abstract class should implement this routine.
	 * @return the list of nodes corresponding to the path from the root to
	 * the current node.
	 * @pre. performSearch() has been executed and finished successfully.
	 * @post. the path to the found success node is returned.  
	 */
    abstract public List<S> getPath();
    
	/** 
	 * Starts the search for successful states for problem.
	 * @return true iff a successful state is found.
	 * @pre. problem!=null.
	 * @post. Search is started
	 * inicializa numItems en 0.  
	 */
    abstract public boolean performSearch();
    
	/** 
	 * Reports information regarding a previously executed search.   
	 * @pre. performSearch() has been executed and finished.
	 * @post. A report regarding the search is printed to standard output.
	 */
    abstract public void report();
    
	/** 
	 * Sets the problem associated with the search engine.
	 * @param p is the search problem to be used for search (to set 'problem' to).
	 * @pre. p!=null.
	 * @post. 'problem' is set to p.
	 */	
    public void setProblem(Problem p) {
        problem = p;
    }
	
} 