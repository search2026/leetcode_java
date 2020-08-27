package bomb_enemy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BombEnemy {
  /*
      Bomb Enemy
      Leetcode #361
      https://leetcode.com/discuss/questions/oj/bomb-enemy
      http://www.cnblogs.com/grandyang/p/5599289.html
      Difficulty: Medium
   */
  public class Solution {
    public int maxKilledEnemies(char[][] grid) {
      if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;

      int m = grid.length, n = grid[0].length;
      Spot[][] spots = new Spot[m][n];
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          spots[i][j] = new Spot();
          if (grid[i][j] == 'W') {
            continue;
          }
          spots[i][j].up = (i == 0 ? 0 : spots[i - 1][j].up) + (grid[i][j] == 'E' ? 1 : 0);
          spots[i][j].left = (j == 0 ? 0 : spots[i][j - 1].left) + (grid[i][j] == 'E' ? 1 : 0);
        }
      }

      int maxHits = 0;
      for (int i = m - 1; i >= 0; i--) {
        for (int j = n - 1; j >= 0; j--) {
          if (grid[i][j] == 'W') {
            continue;
          }
          spots[i][j].bottom = (i == m - 1 ? 0 : spots[i + 1][j].bottom) + (grid[i][j] == 'E' ? 1 : 0);
          spots[i][j].right = (j == n - 1 ? 0 : spots[i][j + 1].right) + (grid[i][j] == 'E' ? 1 : 0);

          if (grid[i][j] == '0') {
            maxHits = Math.max(maxHits, spots[i][j].up + spots[i][j].left + spots[i][j].bottom + spots[i][j].right);
          }
        }
      }

      return maxHits;
    }
  }

  /*
      Bomb Enemy
      Leetcode #361
      https://leetcode.com/discuss/questions/oj/bomb-enemy
      http://www.cnblogs.com/grandyang/p/5599289.html
      Difficulty: Medium
   */
  public class Solution_2 {
    public int maxKilledEnemies(char[][] grid) {
      if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;

      int m = grid.length, n = grid[0].length;
      int maxHits = 0, rowHits = Integer.MIN_VALUE;
      int[] colHits = new int[n];
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (j == 0 || grid[i][j - 1] == 'W') {
            rowHits = 0;
            for (int k = j; k < n && grid[i][k] != 'W'; k++)
              rowHits += (grid[i][k] == 'E') ? 1 : 0;
          }
          if (i == 0 || grid[i - 1][j] == 'W') {
            colHits[j] = 0;
            for (int k = i; k < m && grid[k][j] != 'W'; k++)
              colHits[j] += (grid[k][j] == 'E') ? 1 : 0;
          }
          if (grid[i][j] == '0')
            maxHits = Math.max(maxHits, rowHits + colHits[j]);
        }
      }

      return maxHits;
    }
  }

  private class Spot {
    int up; // enemies to its up including itself
    int left; // enemies to its left including itself
    int bottom;
    int right;
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new BombEnemy().new Solution();
      char[][] grid = {
              {'0', 'E', '0', '0'},
              {'E', '0', 'W', 'E'},
              {'0', 'E', '0', '0'}
      };
      assertEquals(3, sol.maxKilledEnemies(grid));
    }
  }

  @Test
  public void test2() {
    Solution_2 sol = new BombEnemy().new Solution_2();
    char[][] grid = {
            {'0', 'E', '0', '0'},
            {'E', '0', 'W', 'E'},
            {'0', 'E', '0', '0'}
    };
    assertEquals(3, sol.maxKilledEnemies(grid));
  }
}

