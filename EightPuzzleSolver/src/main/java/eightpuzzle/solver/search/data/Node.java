package eightpuzzle.solver.search.data;

import eightpuzzle.solver.search.algorithms.Heuristic;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by mario on 30/01/14.
 */
public class Node<T extends State> implements Comparable<Node<T>> {
    private int depth;
    private double cost;
    private T state;
    private Action<T> action;

    public Node(T state, int depth, double heuristicCost, Action<T> action) {
        this.state = state;
        this.depth = depth;
        this.cost = depth + heuristicCost;
        this.action = action;
    }

    public int getDepth() {
        return depth;
    }

    private double getCost() {
        return cost;
    }

    public T getState() {
        return state;
    }

//    public void setCost(double cost) {
//        this.cost = cost;
//    }

    public Collection<Node<T>> getSuccessors(T goalState, Heuristic<T> heuristic) {
        Collection<Node<T>> successors = new ArrayList<>();
        Collection<Action<T>> applicableActions = state.getApplicableActions();
        int successorDepth = depth + 1;
        for (Action<T> applicableAction : applicableActions) {
            T successorState = applicableAction.execute(state);
            double successorCost = heuristic.getHeuristicValue(successorState, goalState);
            successors.add(new Node<>(successorState, successorDepth, successorCost, applicableAction));
        }
        return successors;
    }

    public Collection<Node<T>> getSuccessors() {
        Collection<Node<T>> successors = new ArrayList<>();
        Collection<Action<T>> applicableActions = state.getApplicableActions();
        int successorDepth = depth + 1;
        for (Action<T> applicableAction : applicableActions) {
            T successorState = applicableAction.execute(state);
            successors.add(new Node<>(successorState, successorDepth, 0, applicableAction));
        }
        return successors;
    }

    @Override
    public int compareTo(Node<T> node) {
        double diff = cost - node.getCost();
        if (diff > 0) return 1;
        else if (diff < 0) return -1;
        else return 0;
    }

    @Override
    public String toString() {
        return String.valueOf(state) + " Cost: " +
                cost + ", Action: " +
                action + " @ " +
                depth;
    }

    @Override
    public int hashCode() {
        return state.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Node && state.equals(((Node<T>) obj).getState());
    }
}
