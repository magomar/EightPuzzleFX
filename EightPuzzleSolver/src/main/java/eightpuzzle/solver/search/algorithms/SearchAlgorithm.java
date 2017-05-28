package eightpuzzle.solver.search.algorithms;

import eightpuzzle.solver.search.data.Node;
import eightpuzzle.solver.search.data.State;

/**
 * Created by mario on 30/01/14.
 */
public interface SearchAlgorithm<T extends State> {
    Node<T> searchForSolution(T initialState, T goalState);

    int getNodesGenerated();
}
