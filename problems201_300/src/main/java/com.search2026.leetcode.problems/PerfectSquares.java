package com.search2026.leetcode.problems;

public class PerfectSquares {

    /*
        Perfect Squares
        Leetcode #279
        https://leetcode.com/problems/perfect-squares/
        Difficulty: Medium
     */
    public class Solution {
        public int numSquares(int n) {
            if (n <= 0) return 0;

            int[] dp = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                dp[i] = Integer.MAX_VALUE;
                for (int j = 1; j * j <= i; j++) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }

            return dp[n];
        }
    }

}
