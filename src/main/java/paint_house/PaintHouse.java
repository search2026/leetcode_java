package paint_house;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PaintHouse {
    /*
        Paint House - Time O(n*k*k) Solution
        Leetcode #256
        https://leetcode.com/discuss/questions/oj/paint-house?sort=votes
        http://www.cnblogs.com/EdwardLiu/p/5063170.html
        Difficulty: Medium
    */
    public class Solution {
        public int minCost(int[][] costs) {
            if (costs == null || costs.length == 0 || costs[0].length == 0) return 0;
            int m = costs.length;
            int n = costs[0].length;
            int[][] dp = new int[m][n];

            System.arraycopy(dp[0], 0, costs[0], 1, costs[0].length);
            for (int i = 1; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = 0; k < n; k++) {
                        dp[i][j] = (k == j) ? dp[i][j] : Math.min(dp[i][j], dp[i - 1][k] + costs[i][j]);
                    }
                }
            }
            int rslt = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                rslt = Math.min(rslt, dp[m - 1][j]);
            }
            return rslt;
        }
    }

    /*
        Paint House
        Leetcode #256
        https://leetcode.com/discuss/questions/oj/paint-house?sort=votes
        https://leetcode.com/discuss/51721/simple-java-dp-solution?show=51755#a51755
        Difficulty: Medium
    */
    public class Solution_2 {
        public int minCost(int[][] costs) {
            if (costs == null || costs.length == 0 || costs[0].length == 0) return 0;
            int n = costs.length, cur_r = 0, cur_g = 0, cur_b = 0;
            for (int i = 0; i < n; i++) {
                int r = cur_r, b = cur_b, g = cur_g;
                cur_r = costs[i][0] + Math.min(b, g);
                cur_b = costs[i][1] + Math.min(r, g);
                cur_g = costs[i][2] + Math.min(r, b);
            }
            return Math.min(cur_r, Math.min(cur_b, cur_g));
        }
    }

    /*
        Paint House II - Time O(n*K) Solution
        Leetcode #265
        https://leetcode.com/discuss/oj/paint-house-ii
        http://buttercola.blogspot.com/2015/09/leetcode-paint-house-ii.html
        Difficulty: Hard
    */
    public class Solution_3 {
        public int minCostII(int[][] costs) {
            if (costs == null || costs.length == 0) return 0;

            int m = costs.length;
            int n = costs[0].length;

            int[] dp = new int[n]; // dp[j] means the min cost for color j
            int min1 = 0;
            int min2 = 0;

            for (int i = 0; i < m; i++) {
                int oldMin1 = min1;
                int oldMin2 = min2;

                min1 = Integer.MAX_VALUE;
                min2 = Integer.MAX_VALUE;

                for (int j = 0; j < n; j++) {
                    if (dp[j] != oldMin1 || oldMin1 == oldMin2) {
                        dp[j] = oldMin1 + costs[i][j];
                    } else {
                        dp[j] = oldMin2 + costs[i][j];
                    }

                    if (min1 <= dp[j]) {
                        min2 = Math.min(min2, dp[j]);
                    } else {
                        min2 = min1;
                        min1 = dp[j];
                    }
                }
            }

            return min1;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new PaintHouse().new Solution();
            assertTrue(true);
        }
    }
}

