package eightpuzzle.solver.task;

import eightpuzzle.model.EightPuzzleHeuristic;
import eightpuzzle.model.EightPuzzleState;
import eightpuzzle.solver.search.algorithms.AStarGraphSearch;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="mailto:magomar@gmail.com">Mario Gómez</a>
 *         Created on 28/05/2017.
 */
public class SingleSearchTaskTest {
    private final int[][] goalPuzzle = new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
    private final int maxDepth = 27;
    private final int[][] initialPuzzle = new int[][]{{3, 1, 5}, {6, 4, 0}, {7, 2, 8}}; // VERY EASY (Cost = 11)
//        int[][] initialPuzzle = new int[][]{{3, 1, 5},{ 6, 4, 7},{0, 2, 8}}; // EASY (Cost = 18)
//        int[][] initialPuzzle = new int[][]{{3, 1, 5},{ 6, 4, 0},{7, 8, 2}}; // HAS NO SOLUTION
//        int[][] initialPuzzle = new int[][]{{1, 6, 4},{ 8, 7, 0},{3, 2, 5}}; // Question 1
//        int[][] initialPuzzle = new int[][]{{8, 1, 7},{4, 5, 6},{2, 0, 3}}; // Question 2

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void run() throws Exception {

        EightPuzzleState initialState = new EightPuzzleState(initialPuzzle);
        EightPuzzleState goalState = new EightPuzzleState(goalPuzzle);

        AStarGraphSearch<EightPuzzleState> searchAlgorithm = new AStarGraphSearch<>(EightPuzzleHeuristic.HAMMINGS_DISTANCE);

        SingleSearchTask<EightPuzzleState> searchTask = new SingleSearchTask<>(initialState, goalState, searchAlgorithm);
        TaskRunner.getInstance().run(searchTask);

        searchAlgorithm.setHeuristic(EightPuzzleHeuristic.MANHATTAN_DISTANCE);

        TaskRunner.getInstance().run(searchTask);

//        ExpandStateSpace<EightPuzzleState> expandAlgorithm = new ExpandStateSpace<>();
//        ExpandStateSpaceTask<EightPuzzleState> expandStateSpaceTask = new ExpandStateSpaceTask<>(goalState, maxDepth, expandAlgorithm);
//        TaskRunner.getInstance().run(expandStateSpaceTask);
    }

}