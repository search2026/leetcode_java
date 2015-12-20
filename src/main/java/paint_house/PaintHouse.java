package paint_house;

public class PaintHouse {
    // Paint House
    // http://buttercola.blogspot.com/2015/08/leetcode-paint-house.html
    // Difficulty: Medium
    public class Solution {
        public int minCost(int[][] costs) {
            if (costs == null || costs.length == 0) {
                return 0;
            }

            int n = costs.length;

            int cost = Integer.MAX_VALUE;
            int[] color = new int[n];

            // First house
            int k;
            int firstColor = 0;
            for (k = 0; k < 3; k++) {
                if (costs[0][k] < cost) {
                    cost = costs[0][k];
                    firstColor = k;
                }
            }

            color[0] = firstColor;

            for (int i = 1; i < n; i++) {
                int localCost = Integer.MAX_VALUE;
                for (int j = 0; j < 3; j++) {
                    if (j != color[i - 1] && costs[i][j] < localCost) {
                        localCost = costs[i][j];
                        color[i] = j;
                    }
                }
                cost += localCost;
            }

            return cost;
        }
    }

    // Paint House II
    // http://buttercola.blogspot.com/2015/09/leetcode-paint-house-ii.html
    // Difficulty: Hard
    public class SolutionII {
        public int minCostII(int[][] costs) {
            if (costs == null || costs.length == 0) {
                return 0;
            }

            int n = costs.length;
            int k = costs[0].length;

            // dp[i][j] means the min cost painting for house i, with color j
            int[][] dp = new int[n][k];

            // Initialization
            for (int i = 0; i < k; i++) {
                dp[0][i] = costs[0][i];
            }

            for (int i = 1; i < n; i++) {
                for (int j = 0; j < k; j++) {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int m = 0; m < k; m++) {
                        if (m != j) {
                            dp[i][j] = Math.min(dp[i - 1][m] + costs[i][j], dp[i][j]);
                        }
                    }
                }
            }

            // Final state
            int minCost = Integer.MAX_VALUE;
            for (int i = 0; i < k; i++) {
                minCost = Math.min(minCost, dp[n - 1][i]);
            }

            return minCost;
        }
    }

    public static class UnitTest {

    }
}

