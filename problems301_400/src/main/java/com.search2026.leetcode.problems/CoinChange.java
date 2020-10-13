package com.search2026.leetcode.problems;

public class CoinChange {

    /*
        Coin Changes
        Leetcode #322
        https://leetcode.com/problems/coin-change/
        Difficulty: Medium
     */
    public class Solution {
        public int coinChange(int[] coins, int amount) {
            if (coins == null || coins.length == 0 || amount < 0) return -1;
            int n = coins.length;
            int[] dp = new int[amount + 1];
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                dp[i] = Integer.MAX_VALUE;
                for (int j = 0; j < n; j++) {
                    if (coins[j] <= i) {
                        if (i - coins[j] < 0) continue;
                        int local = dp[i - coins[j]];
                        if (local != Integer.MAX_VALUE)
                            dp[i] = Math.min(dp[i], local + 1);
                    }
                }
            }
            if (dp[amount] != Integer.MAX_VALUE)
                return dp[amount];
            return -1;
        }
    }

}
