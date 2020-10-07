package com.search2026.leetcode.problems;

public class LongestIncreasingPathInAMatrix {

    /*
        Longest Increasing Path in Matrix
        Leetcode #329
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
            int res = 0;
            if (matrix == null || matrix.length == 0) return res;
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] dp = new int[m][n];

            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    res = Math.max(res, search(matrix, dp, i, j));

            return res;
        }
    }

}
