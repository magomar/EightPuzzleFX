package eightpuzzle.model;

import eightpuzzle.solver.search.data.Action;

import java.util.Arrays;

/**
 * Created by mario on 30/01/14.
 */
public enum EightPuzzleAction implements Action<EightPuzzleState> {
    NORTH {
        @Override
        public EightPuzzleState execute(EightPuzzleState state) {
            int x = state.getX();
            int y = state.getY();
            assert (y > 0);
            int[][] puzzle = state.getPuzzle();
            int[][] newPuzzle = deepCopy(puzzle);
            int newY = y - 1;
            newPuzzle[x][y] = puzzle[x][newY];
            newPuzzle[x][newY] = 0;
            return new EightPuzzleState(newPuzzle, x, newY);
        }
    },
    SOUTH {
        @Override
        public EightPuzzleState execute(EightPuzzleState state) {
            int x = state.getX();
            int y = state.getY();
            assert (y < 2);
            int[][] puzzle = state.getPuzzle();
            int[][] newPuzzle = deepCopy(puzzle);
            int newY = y + 1;
            newPuzzle[x][y] = puzzle[x][newY];
            newPuzzle[x][newY] = 0;
            return new EightPuzzleState(newPuzzle, x, newY);
        }
    },
    EAST {
        @Override
        public EightPuzzleState execute(EightPuzzleState state) {
            int x = state.getX();
            int y = state.getY();
            assert (x < 2);
            int[][] puzzle = state.getPuzzle();
            int[][] newPuzzle = deepCopy(puzzle);
            newPuzzle[x][y] = puzzle[x + 1][y];
            newPuzzle[x + 1][y] = 0;
            return new EightPuzzleState(newPuzzle, x + 1, y);
        }
    },
    WEST {
        @Override
        public EightPuzzleState execute(EightPuzzleState state) {
            int x = state.getX();
            int y = state.getY();
            assert (x > 0);
            int[][] puzzle = state.getPuzzle();
            int[][] newPuzzle = deepCopy(puzzle);
            newPuzzle[x][y] = puzzle[x - 1][y];
            newPuzzle[x - 1][y] = 0;
            return new EightPuzzleState(newPuzzle, x - 1, y);
        }
    };

    private static int[][] deepCopy(int[][] original) {
        if (original == null) {
            return null;
        }

        final int[][] result = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            result[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return result;
    }

    @Override
    public String toString() {
        return name();
    }
}
