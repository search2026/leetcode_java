public class MaximalSquare {
    /*
        Maximal Square
        https://leetcode.com/problems/maximal-square/
        Difficulty: Medium
     */
    public class Solution {
        public int maximalSquare(char[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return 0;
            }

            int rows = matrix.length;
            int cols = matrix[0].length;

            int[][] dp = new int[rows][cols];

            // Initialization
            for (int i = 0; i < cols; i++) {
                dp[0][i] = matrix[0][i] - '0';
            }

            for (int i = 0; i < rows; i++) {
                dp[i][0] = matrix[i][0] - '0';
            }

            for (int i = 1; i < rows; i++) {
                for (int j = 1; j < cols; j++) {
                    if (matrix[i][j] == '1') {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j],
                                dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                }
            }

            int maxArea = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    maxArea = Math.max(maxArea, dp[i][j] * dp[i][j]);
                }
            }

            return maxArea;
        }
    }

    public static class UnitTest {

    }
}
