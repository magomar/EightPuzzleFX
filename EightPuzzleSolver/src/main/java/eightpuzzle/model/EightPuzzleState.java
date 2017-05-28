package eightpuzzle.model;

import eightpuzzle.solver.search.data.State;

import java.util.*;

/**
 * Created by mario on 30/01/14.
 */
public class EightPuzzleState implements State<EightPuzzleAction> {
    private int[][] puzzle;
    private int x; // x-coordinate of the zero location
    private int y; //y-coordinate of the

    EightPuzzleState(int[][] puzzle, int x, int y) {
        assert 0 == puzzle[x][y];
        this.puzzle = puzzle;
        this.x = x;
        this.y = y;
    }

    public EightPuzzleState(int[][] puzzle) {
        this.puzzle = puzzle;
        for (int i = 0; i < 3; i++) {
            int[] puzzleRow = puzzle[i];
            for (int j = 0; j < 3; j++) {
                if (puzzleRow[j] == 0) {
                    x = i;
                    y = j;
                    return;
                }
            }
        }
    }

    @Override
    public Collection<EightPuzzleAction> getApplicableActions() {
        Set<EightPuzzleAction> applicableActions = EnumSet.noneOf(EightPuzzleAction.class);
        if (y > 0) applicableActions.add(EightPuzzleAction.NORTH);
        if (y < 2) applicableActions.add(EightPuzzleAction.SOUTH);
        if (x > 0) applicableActions.add(EightPuzzleAction.WEST);
        if (x < 2) applicableActions.add(EightPuzzleAction.EAST);
        return applicableActions;
    }

    @Override
    public Collection<EightPuzzleState> getSuccessors() {
        Collection<EightPuzzleAction> applicableActions = getApplicableActions();
        Collection<EightPuzzleState> successors = new ArrayList<>();
        for (EightPuzzleAction applicableAction : applicableActions) {
            successors.add(applicableAction.execute(this));
        }
        return successors;
    }


    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    int[][] getPuzzle() {
        return puzzle;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof EightPuzzleState) {
            int[][] otherPuzzle = ((EightPuzzleState) obj).getPuzzle();
            for (int i = 0; i < 3; i++) {
                int[] puzzleRow = puzzle[i];
                int[] otherRow = otherPuzzle[i];
                for (int j = 0; j < 3; j++) {
                    if (puzzleRow[j] != otherRow[j]) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : puzzle) {
            sb.append(Arrays.toString(row));
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
//        return x * 31 + y *16 + puzzle[0][0];
        int hashCode = 1;
        for (int i = 0; i < 3; i++) {
            int[] row = puzzle[i];
            for (int j = 0; j < 3; j++) {
                hashCode = 31 * hashCode + row[j];
            }
        }
        return hashCode;

    }

}