package com.search2026.leetcode.problems;

public class IntegerBreak {

    /*
        Integer Break
        Leetcode #343
        https://leetcode.com/problems/integer-break/
        Difficulty: Medium
     */
    public class Solution {
        int integerBreak(int n) {
            if (n == 2 || n == 3) return n-1;
            int div = n / 3;
            int reminder = n % 3;
            if (reminder == 1)
                return (int)Math.pow(3, div-1) * 4;
            else if (reminder == 0)
                return (int)Math.pow(3, div);
            return (int)Math.pow(3, div) * 2;
        }
    }

    /*
        Integer Break - Dynamic Programming
        Leetcode #343
        https://leetcode.com/problems/integer-break/
        Difficulty: Medium
     */
    public class Solution_2 {
        int integerBreak(int n) {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            for(int i = 2; i <= n; i ++) {
                for(int j = 1; 2*j <= i; j ++) {
                    dp[i] = Math.max(dp[i], (Math.max(j,dp[j])) * (Math.max(i - j, dp[i - j])));
                }
            }
            return dp[n];
        }
    }

}
