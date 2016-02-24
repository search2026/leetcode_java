package unique_paths;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class UniquePaths {
    /*
        Unique Path
        https://leetcode.com/problems/unique-paths/
        Difficulty: Medium
     */
    public class Solution {
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
        Unique Path II
        https://leetcode.com/problems/unique-paths-ii/
        Difficulty: Medium
     */
    public class Solution_2 {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            if (obstacleGrid == null || obstacleGrid[0] == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
                return 0;
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
            Solution_2 sol = new UniquePaths().new Solution_2();
            int[][] grid = {
                    new int[]{0, 0, 0},
                    new int[]{0, 1, 0},
                    new int[]{0, 0, 0}
            };
            assertEquals(2, sol.uniquePathsWithObstacles(grid));
        }
    }
}
