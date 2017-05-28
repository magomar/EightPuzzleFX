package eightpuzzle.solver.search.algorithms;


import eightpuzzle.solver.search.data.State;

/**
 * Created by mario on 31/01/14.
 */
public interface HeuristicSearchAlgorithm<T extends State> extends SearchAlgorithm<T> {
    Heuristic<T> getHeuristic();

    void setHeuristic(Heuristic<T> heuristic);
}
