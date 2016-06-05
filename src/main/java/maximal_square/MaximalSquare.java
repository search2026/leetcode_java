package maximal_square;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximalSquare {
    /*
        Maximal Square
        Leetcode #221
        https://leetcode.com/problems/maximal-square/
        Difficulty: Medium
     */
    public class Solution {
        public int maximalSquare(char[][] matrix) {
            int res = 0;
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
            int[][] dp = new int[matrix.length][matrix[0].length];
            int maxEdge = 0;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][0] == '1') dp[i][0] = 1;
                else dp[i][0] = 0;
                maxEdge = Math.max(maxEdge, dp[i][0]);
            }
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[0][j] == '1') dp[0][j] = 1;
                else dp[0][j] = 0;
                maxEdge = Math.max(maxEdge, dp[0][j]);
            }
            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix[0].length; j++) {
                    if (matrix[i][j] == '0') {
                        dp[i][j] = 0;
                        continue;
                    }
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    maxEdge = Math.max(maxEdge, dp[i][j]);
                }
            }
            return maxEdge * maxEdge;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new MaximalSquare().new Solution();
            char[][] grid = new char[][]{
                    new char[]{'1', '0', '1', '0', '0'},
                    new char[]{'1', '0', '1', '1', '1'},
                    new char[]{'1', '1', '1', '1', '1'},
                    new char[]{'1', '0', '0', '1', '0'}
            };
            assertEquals(4, sol.maximalSquare(grid));
        }
    }
}
