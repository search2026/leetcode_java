package sudoku_solver;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
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

    private boolean search(char[][] board) {
      for (int i=0; i<9; i++ ) {
        for (int j=0; j<9; j++) {
          if (board[i][j] == '.') {
            for (char c = '1'; c<= '9'; c++) {
              if (isValid(board, i, j, c)) {
                board[i][j] = c;
                if (search(board)) {
                  return true;
                }
                board[i][j] = '.';
              }
            }
           return false;
          }
        }
      }

      return true; // assume what's on-boarding are valid
    }

    public void solveSudoku(char[][] board) {
      if (board == null || board.length != 9 ||
              board[0] == null || board[0].length != 9) return;
      search(board);
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new SudokuSolver().new Solution();
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
      char[][] solved = {
              {'5', '3', '4', '6', '7', '8', '9', '1', '2'},
              {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
              {'1', '9', '8', '3', '4', '2', '5', '6', '7'},
              {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
              {'4', '2', '6', '8', '5', '3', '7', '9', '1'},
              {'7', '1', '3', '9', '2', '4', '8', '5', '6'},
              {'9', '6', '1', '5', '3', '7', '2', '8', '4'},
              {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
              {'3', '4', '5', '2', '8', '6', '1', '7', '9'},
      };

      sol.solveSudoku(boards);

      for (int i = 0; i < 9; i++) {
        assertArrayEquals(solved[i], boards[i]);
      }
    }
  }
}
