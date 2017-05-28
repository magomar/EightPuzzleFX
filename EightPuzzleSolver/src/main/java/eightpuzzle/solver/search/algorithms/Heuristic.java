package eightpuzzle.solver.search.algorithms;

import eightpuzzle.solver.search.data.State;

/**
 * Created by mario on 30/01/14.
 */
public interface Heuristic<T extends State> {
    double getHeuristicValue(T currentState, T goalState);
}
