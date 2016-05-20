package design_tic_tac_toe;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DesignTicTacToe {
    /*
        Design Tic-Tac-Toe
        Leetcode #348
        https://leetcode.com/discuss/questions/oj/design-tic-tac-toe?sort=votes
        Difficulty: Medium
     */
    public class TicTacToe {
        private int[] rows;
        private int[] cols;
        private int diagonal;
        private int antiDiagonal;

        /**
         * Initialize your data structure here.
         */
        public TicTacToe(int n) {
            rows = new int[n];
            cols = new int[n];
        }

        public int move(int row, int col, int player) {
            int toAdd = player == 1 ? 1 : -1;

            rows[row] += toAdd;
            cols[col] += toAdd;
            if (row == col) {
                diagonal += toAdd;
            }

            if (col == (cols.length - row - 1)) {
                antiDiagonal += toAdd;
            }

            int size = rows.length;
            if (Math.abs(rows[row]) == size ||
                    Math.abs(cols[col]) == size ||
                    Math.abs(diagonal) == size ||
                    Math.abs(antiDiagonal) == size) {
                return player;
            }

            return 0;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            TicTacToe sol = new DesignTicTacToe().new TicTacToe(3);
            assertEquals(1, 1);
        }
    }
}

