package unique_paths;

import java.util.Arrays;

public class UniquePaths {
    // Unique Path
    public class Solution {
        public int uniquePaths(int m, int n) {
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

    // Unique Path II
    public class SolutionII {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
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

    }
}
