package com.search2026.leetcode.problems;

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
            int cellCol = col - col % 3;
            for (int i = 0; i < 9; i++) {
                if (board[i][col] == c || board[row][i] == c
                            || board[cellRow + i / 3][cellCol + i % 3] == c) {
                    return false;
                }
            }
            return true;
        }

        private boolean search(char[][] board) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.') {
                        for (char c = '1'; c <= '9'; c++) {
                            if (isValid(board, i, j, c)) {
                                board[i][j] = c;
                                if (search(board)) {
                                    return true;
                                }
                            }
                        }
                        board[i][j] = '.';
                        return false;
                    }
                }
            }

            return true;
        }

        public void solveSudoku(char[][] board) {
            if (board == null || board.length != 9 ||
                        board[0] == null || board[0].length != 9) return;
            search(board);
        }
    }

}
