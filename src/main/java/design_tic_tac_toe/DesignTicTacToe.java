package design_tic_tac_toe;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DesignTicTacToe {
  /*
      Design Tic-Tac-Toe
      Leetcode #348
      https://leetcode.com/discuss/questions/oj/design-tic-tac-toe?sort=votes
      http://www.cnblogs.com/grandyang/p/5467118.html
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
      if (row == col) diagonal += toAdd;
      if (col == (cols.length - row - 1)) antiDiagonal += toAdd;

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
      TicTacToe toe = new DesignTicTacToe().new TicTacToe(3);
      assertEquals(0, toe.move(0, 0, 1));
      assertEquals(0, toe.move(0, 2, 2));
      assertEquals(0, toe.move(2, 2, 1));
      assertEquals(0, toe.move(1, 1, 2));
      assertEquals(0, toe.move(2, 0, 1));
      assertEquals(0, toe.move(1, 0, 2));
      assertEquals(1, toe.move(2, 1, 1));
    }
  }
}

