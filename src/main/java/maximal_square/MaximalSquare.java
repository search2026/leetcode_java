package maximal_square;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximalSquare {
    /*
        Maximal Square - DP
        Leetcode #221
        https://leetcode.com/problems/maximal-square/
        Difficulty: Medium
     */
    public class Solution {
        public int maximalSquare(char[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
            int m = matrix.length, n = matrix[0].length, res = 0;
            int[][] b = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (matrix[i - 1][j - 1] == '1') {
                        b[i][j] = Math.min(Math.min(b[i][j - 1], b[i - 1][j - 1]), b[i - 1][j]) + 1;
                        res = Math.max(b[i][j], res);
                    }
                }
            }
            return res * res;
        }
    }

    /*
        Maximal Square - DP with Memoization
        Leetcode #221
        https://leetcode.com/problems/maximal-square/
        Difficulty: Medium
     */
    public class Solution_2 {
        public int maximalSquare(char[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
            int m = matrix.length;
            int n = matrix[0].length;
            int res = 0;
            int[][] dp = new int[2][n + 1];

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (matrix[i - 1][j - 1] == '0') {
                        dp[i % 2][j] = 0;
                    } else {
                        dp[i % 2][j] = Math.min(Math.min(dp[(i + 1) % 2][j - 1], dp[(i + 1) % 2][j]), dp[i % 2][j - 1]) + 1;
                    }

                    res = Math.max(dp[i % 2][j], res);
                }
            }

            return res * res;
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

        @Test
        public void test2() {
            Solution_2 sol = new MaximalSquare().new Solution_2();
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
