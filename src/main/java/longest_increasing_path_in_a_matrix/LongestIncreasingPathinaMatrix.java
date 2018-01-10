package longest_increasing_path_in_a_matrix;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestIncreasingPathinaMatrix {
    /*
        Longest Increasing Path in Matrix
        https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
        Difficulty: Medium
     */
    public class Solution {
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        int search(int[][] matrix, int[][] dp, int i, int j) {
            if (dp[i][j] != 0) return dp[i][j];

            for (int[] dir : dirs) {
                int new_i = i + dir[0];
                int new_j = j + dir[1];
                if (new_i < 0 || new_i >= matrix.length || new_j < 0 || new_j >= matrix[0].length)
                    continue;
                if (matrix[new_i][new_j] > matrix[i][j])
                    dp[i][j] = Math.max(dp[i][j], search(matrix, dp, new_i, new_j));
            }

            return ++dp[i][j];
        }

        public int longestIncreasingPath(int[][] matrix) {
            int rslt = 0;
            if (matrix == null || matrix.length == 0) return rslt;
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] dp = new int[m][n];

            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    rslt = Math.max(rslt, search(matrix, dp, i, j));

            return rslt;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new LongestIncreasingPathinaMatrix().new Solution();
            int[][] test1 = new int[][]{
                    new int[]{9, 9, 4},
                    new int[]{6, 6, 8},
                    new int[]{2, 1, 1},};
            assertEquals(4, sol.longestIncreasingPath(test1));
            int[][] test2 = new int[][]{
                    new int[]{3, 4, 5},
                    new int[]{3, 2, 6},
                    new int[]{2, 2, 1},};
            assertEquals(4, sol.longestIncreasingPath(test2));
        }
    }
}

