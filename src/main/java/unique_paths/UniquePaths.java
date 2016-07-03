package unique_paths;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class UniquePaths {
  /*
      Unique Path - Dynamic Programming O(N*M) Space
      Leetcode #62
      https://leetcode.com/problems/unique-paths/
      Difficulty: Medium
   */
  public class Solution {
    public int uniquePaths(int m, int n) {
      if (m <= 0 || n <= 0) return 0;

      int[][] dp = new int[m][n];
      Arrays.fill(dp[0], 1);

      for (int i = 1; i < m; i++) {
        dp[i][0] = 1;
        for (int j = 1; j < n; j++) {
          dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
      }

      return dp[m - 1][n - 1];
    }
  }

  /*
      Unique Path - Dynamic Programming  O(N) Space
      Leetcode #62
      https://leetcode.com/problems/unique-paths/
      Difficulty: Medium
   */
  public class Solution_2 {
    public int uniquePaths(int m, int n) {
      if (m <= 0 || n <= 0) return 0;
      int[] dp = new int[n];
      Arrays.fill(dp, 1);
      for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
          dp[j] += dp[j - 1];
        }
      }
      return dp[n - 1];
    }
  }

  /*
      Unique Path - Backtracking
      Leetcode #62
      https://leetcode.com/problems/unique-paths/
      Difficulty: Medium
   */
  public class Solution_3 {
    private int search(int[][] matrix, int m, int n, int row, int col) {
      if (row == m - 1 || col == n - 1) return 1;
      if (row > m || col > n) return 0;

      if (matrix[row + 1][col] == -1)
        matrix[row + 1][col] = search(matrix, m, n, row + 1, col);
      if (matrix[row][col + 1] == -1)
        matrix[row][col + 1] = search(matrix, m, n, row, col + 1);

      return matrix[row + 1][col] + matrix[row][col + 1];
    }

    public int uniquePaths(int m, int n) {
      if (m <= 0 || n <= 0) return 0;
      int[][] matrix = new int[m + 1][n + 1];
      for (int i = 0; i < m + 1; i++) {
        Arrays.fill(matrix[i], -1);
      }

      return search(matrix, m, n, 0, 0);
    }
  }

  /*
      Unique Path II - Dynamic Programming O(N*M) Space
      Leetcode #63
      https://leetcode.com/problems/unique-paths-ii/
      Difficulty: Medium
   */
  public class Solution_4 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
      if (obstacleGrid == null || obstacleGrid[0] == null ||
              obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;

      int m = obstacleGrid.length;
      int n = obstacleGrid[0].length;
      int[][] dp = new int[m][n];
      // for first row, if there is an obstacle on the left, available path = 0
      dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
      for (int i = 1; i < n; i++) {
        dp[0][i] = obstacleGrid[0][i] == 1 ? 0 : dp[0][i - 1];
      }

      for (int i = 1; i < m; i++) {
        // for first column, if there is an obstacle on the top, available path = 0
        dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : dp[i - 1][0];
        for (int j = 1; j < n; j++) {
          dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i][j - 1] + dp[i - 1][j];
        }
      }

      return dp[m - 1][n - 1];
    }
  }

  /*
      Unique Path II - Dynamic Programming O(N) Space
      Leetcode #63
      https://leetcode.com/problems/unique-paths-ii/
      Difficulty: Medium
   */
  public class Solution_5 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
      if (obstacleGrid == null || obstacleGrid[0] == null ||
              obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
      int m = obstacleGrid.length;
      int n = obstacleGrid[0].length;
      int[] dp = new int[n];
      dp[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
      for (int i = 0; i < m; i++) {
        dp[0] = obstacleGrid[i][0] == 1 ? 0 : dp[0];
        for (int j = 1; j < n; j++) {
          dp[j] = obstacleGrid[i][j] == 1 ? 0 : dp[j - 1] + dp[j];
        }
      }
      return dp[n - 1];
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new UniquePaths().new Solution();
      assertEquals(15, sol.uniquePaths(3, 5));
      assertEquals(15, sol.uniquePaths(5, 3));
      assertEquals(56, sol.uniquePaths(4, 6));
      assertEquals(56, sol.uniquePaths(6, 4));
      assertEquals(8, sol.uniquePaths(2, 8));
      assertEquals(8, sol.uniquePaths(8, 2));
      assertEquals(3003, sol.uniquePaths(7, 9));
      assertEquals(3003, sol.uniquePaths(9, 7));
    }

    @Test
    public void test2() {
      Solution_2 sol = new UniquePaths().new Solution_2();
      assertEquals(15, sol.uniquePaths(3, 5));
      assertEquals(15, sol.uniquePaths(5, 3));
      assertEquals(56, sol.uniquePaths(4, 6));
      assertEquals(56, sol.uniquePaths(6, 4));
      assertEquals(8, sol.uniquePaths(2, 8));
      assertEquals(8, sol.uniquePaths(8, 2));
      assertEquals(3003, sol.uniquePaths(7, 9));
      assertEquals(3003, sol.uniquePaths(9, 7));
    }

    @Test
    public void test3() {
      Solution_3 sol = new UniquePaths().new Solution_3();
      assertEquals(15, sol.uniquePaths(3, 5));
      assertEquals(15, sol.uniquePaths(5, 3));
      assertEquals(56, sol.uniquePaths(4, 6));
      assertEquals(56, sol.uniquePaths(6, 4));
      assertEquals(8, sol.uniquePaths(2, 8));
      assertEquals(8, sol.uniquePaths(8, 2));
      assertEquals(3003, sol.uniquePaths(7, 9));
      assertEquals(3003, sol.uniquePaths(9, 7));
    }

    @Test
    public void test4() {
      Solution_4 sol = new UniquePaths().new Solution_4();
      int[][] grid = {
              new int[]{0, 0, 0},
              new int[]{0, 1, 0},
              new int[]{0, 0, 0}
      };
      assertEquals(2, sol.uniquePathsWithObstacles(grid));

      grid = new int[][]{
              new int[]{1, 0}
      };
      assertEquals(0, sol.uniquePathsWithObstacles(grid));
    }

    @Test
    public void test5() {
      Solution_5 sol = new UniquePaths().new Solution_5();
      int[][] grid = {
              new int[]{0, 0, 0},
              new int[]{0, 1, 0},
              new int[]{0, 0, 0}
      };
      assertEquals(2, sol.uniquePathsWithObstacles(grid));

      grid = new int[][]{
              new int[]{1, 0}
      };
      assertEquals(0, sol.uniquePathsWithObstacles(grid));
    }
  }
}
