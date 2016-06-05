package sudoku_solver;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SudokuSolver {
    /*
        Sudoku Solver
        Leetcode #37
        https://leetcode.com/problems/sudoku-solver/
        Difficulty: Hard
     */
    public class Solution {
        private boolean isValid(char[][] board, int row, int col, char c) {
            int cellRow = row - row % 3;
            int cellColumn = col - col % 3;
            for (int i = 0; i < 9; i++) {
                if (board[i][col] == c || board[row][i] == c
                        || board[cellRow + i / 3][cellColumn + i % 3] == c) {
                    return false;
                }
            }
            return true;
        }

        private boolean search(char[][] board, int pos) {
            while (pos < 81) {
                if (board[pos / 9][pos % 9] == '.') {
                    break;
                }
                pos++;
            }
            if (pos == 81) {
                return true;
            }
            int row = pos / 9;
            int col = pos % 9;
            for (char c = '1'; c <= '9'; c++) {
                if (isValid(board, row, col, c)) {
                    board[row][col] = c;
                    if (search(board, pos + 1)) {
                        return true;
                    }
                }
            }
            board[row][col] = '.'; //very important
            return false;
        }

        public void solveSudoku(char[][] board) {
            search(board, 0);
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new SudokuSolver().new Solution();
            assertEquals(7, 7);
        }
    }
}
