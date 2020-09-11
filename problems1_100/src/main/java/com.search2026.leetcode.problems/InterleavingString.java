package com.search2026.leetcode.problems;

public class InterleavingString {

    /*
        Interleaving String
        Leetcode #97
        https://leetcode.com/problems/interleaving-string/
        Difficulty: Hard
     */
    public class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            if (s1.length() + s2.length() != s3.length()) {
                return false;
            }
            int l1 = s1.length();
            int l2 = s2.length();
            boolean[] dp = new boolean[l2 + 1];
            for (int i = 0; i <= l1; i++) {
                for (int j = 0; j <= l2; j++) {
                    dp[j] = (i == 0 && j == 0) || (i != 0 && dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                                    (j != 0 && dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
            return dp[l2];
        }
    }

}
