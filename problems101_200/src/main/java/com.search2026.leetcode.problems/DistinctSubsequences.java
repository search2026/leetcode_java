package com.search2026.leetcode.problems;

public class DistinctSubsequences {

    /*
        Distinct Subsequences
        Leetcode #115
        https://leetcode.com/problems/distinct-subsequences/
        Difficulty: Hard
     */
    public class Solution {
        public int numDistinct(String s, String t) {
            int[] dp = new int[t.length() + 1];
            dp[0] = 1;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = t.length(); j > 0; j--) {
                    if (t.charAt(j - 1) == s.charAt(i - 1)) {
                        dp[j] += dp[j - 1];
                    }
                }
            }
            return dp[t.length()];
        }
    }

}
