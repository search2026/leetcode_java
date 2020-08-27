package valid_sudoku;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

public class ValidSudoku {
    /*
        Valid Sudoku
        Leetcode #36
        https://leetcode.com/problems/valid-sudoku/
        Difficulty: Easy
     */
    public class Solution {
        public boolean isValidSudoku(char[][] board) {
            if (board == null || board.length != 9 ||
                    board[0] == null || board[0].length != 9) return false;

            boolean[][] rows = new boolean[9][9];
            boolean[][] columns = new boolean[9][9];
            boolean[][] cells = new boolean[9][9];

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.') {
                        continue;
                    }
                    int num = board[i][j] - '1';
                    if (num < 0 || num > 9) {
                        return false;
                    }
                    if (rows[i][num] || columns[j][num]
                            || cells[(i / 3) * 3 + j / 3][num]) {
                        return false;
                    }
                    rows[i][num] = columns[j][num] = cells[(i / 3) * 3 + j / 3][num] = true;
                }
            }
            return true;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new ValidSudoku().new Solution();
            char[][] boards = {
                    {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                    {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                    {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                    {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                    {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                    {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                    {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                    {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                    {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
            };
            assertTrue(sol.isValidSudoku(boards));

            boards = new char[][]{
                    {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                    {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                    {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                    {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                    {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                    {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                    {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                    {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                    {'.', '3', '.', '.', '8', '.', '.', '7', '9'},
            };
            assertFalse(sol.isValidSudoku(boards));

            boards = new char[][]{
                    {'.', '.', '4', '.', '.', '.', '6', '3', '.'},
                    {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                    {'5', '.', '.', '.', '.', '.', '.', '.', '9'},
                    {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
                    {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
                    {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
                    {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
                    {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                    {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            };
            assertFalse(sol.isValidSudoku(boards));
        }
    }
}
