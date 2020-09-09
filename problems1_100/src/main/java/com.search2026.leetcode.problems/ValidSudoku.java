package com.search2026.leetcode.problems;

public class ValidSudoku {

    /*
        Valid Sudoku
        Leetcode #36
        https://leetcode.com/problems/valid-sudoku/
        Difficulty: Easy
     */
    public class Solution {

        private int getCellColumns(int i, int j) {
            return (i / 3) * 3 + j / 3;
        }

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
                                || cells[getCellColumns(i, j)][num]) {
                        return false;
                    }
                    rows[i][num] = columns[j][num] = cells[getCellColumns(i, j)][num] = true;
                }
            }
            return true;
        }
    }

}
