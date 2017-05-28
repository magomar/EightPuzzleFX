package eightpuzzle.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mario on 1/02/14.
 */
class ManhattanDistanceProvider {
    private static Map<EightPuzzleState, ManhattanDistanceProvider> cache = new HashMap<>();
    private int[] x = new int[9];
    private int[] y = new int[9];

    private ManhattanDistanceProvider(EightPuzzleState goalState) {
        int[][] puzzle = goalState.getPuzzle();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int value = puzzle[i][j];
                x[value] = i;
                y[value] = j;
            }
        }
    }

    static ManhattanDistanceProvider getManhattanDistanceProvider(EightPuzzleState goalState) {
        if (cache.containsKey(goalState)) return cache.get(goalState);
        else {
            ManhattanDistanceProvider manhattanDistanceProvider = new ManhattanDistanceProvider(goalState);
            cache.put(goalState, manhattanDistanceProvider);
            return manhattanDistanceProvider;
        }
    }

    int[] getX() {
        return x;
    }

    int[] getY() {
        return y;
    }
}
