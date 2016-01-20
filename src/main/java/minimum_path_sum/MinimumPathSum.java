package minimum_path_sum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MinimumPathSum {
    /*
        Minimum Path Sum
        https://leetcode.com/problems/minimum-path-sum/
        Difficulty: Medium
     */
    public class Solution {
        public int minPathSum(int[][] grid) {
            int[] dp = new int[grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                dp[0] = i == 0 ? grid[0][0] : dp[0] + grid[i][0];
                for (int j = 1; j < grid[0].length; j++) {
                    dp[j] = i == 0 ? dp[j - 1] : Math.min(dp[j], dp[j - 1]);
                    dp[j] += grid[i][j];
                }
            }
            return dp[grid[0].length - 1];
        }
    }

    public class Solution_2 {
        public int minPathSum(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0)
                return 0;
            int m = grid.length;
            int n = grid[0].length;
            int[] dp = new int[n];
            dp[0] = grid[0][0];
            for (int i = 1; i < n; i++)
                dp[i] = dp[i - 1] + grid[0][i];
            for (int i = 1; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (j == 0)
                        dp[0] += grid[i][0];
                    else
                        dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
                }
            }
            return dp[n - 1];
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution_2 sol = new MinimumPathSum().new Solution_2();
            int[][] grid1 = new int[][]{
                    new int[]{1, 2},
                    new int[]{1, 1}
            };
            assertEquals(3, sol.minPathSum(grid1));
        }
    }
}
