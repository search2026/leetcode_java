package com.search2026.leetcode.problems;

public class RegularExpressionMatching {

    /*
        Regular Expression Matching - Dynamic Programming
        https://leetcode.com/problems/regular-expression-matching/
        Difficulty: Hard
    */
    public class Solution {
        public boolean isMatch(String s, String p) {
            if (s == null && p == null) return true;
            if (s == null || p == null) return false;
            int m = s.length(), n = p.length();
            boolean[][] dp = new boolean[m + 1][n + 1];
            dp[0][0] = true;
            for (int i = 0; i < m + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (p.charAt(j - 1) != '*') {
                        dp[i][j] = i > 0 && dp[i - 1][j - 1]
                                           && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
                    } else {
                        dp[i][j] = dp[i][j - 2] || (i > 0 && dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2)
                                                                                      || p.charAt(j - 2) == '.'));
                    }
                }
            }
            return dp[m][n];
        }
    }

    /*
        Regular Expression Matching - Recursion
        Leetcode #10
        https://leetcode.com/problems/regular-expression-matching/
        Difficulty: Hard
     */
    public class Solution_2 {
        public boolean isMatch(String s, String p) {
            if (s == null && p == null) return true;
            if (s == null || p == null) return false;
            for (int i = 0; i < p.length(); s = s.substring(1)) {
                char c = p.charAt(i);
                if (i + 1 >= p.length() || p.charAt(i + 1) != '*')
                    i++;
                else if (isMatch(s, p.substring(i + 2)))
                    return true;

                if (s.isEmpty() || (c != '.' && c != s.charAt(0)))
                    return false;
            }

            return s.isEmpty();
        }
    }

    /*
        Regular Expression Matching - Recursion
        Leetcode #10
        https://leetcode.com/problems/regular-expression-matching/
        Difficulty: Hard
     */
    public class Solution_3 {
        private boolean isMatch(String s, int idx1, String p, int idx2) {
            if (s.length() == idx1 && p.length() == idx2) return true;
            if (p.length() == idx2) return false;
            if (s.length() == idx1) {
                if (idx2 + 1 >= p.length() || p.charAt(idx2 + 1) != '*') {
                    return false;
                }
                return isMatch(s, idx1, p, idx2 + 2);
            }

            if (idx2 + 1 <= p.length() - 1 && p.charAt(idx2 + 1) == '*') {
                if (s.charAt(idx1) == p.charAt(idx2) || p.charAt(idx2) == '.') {
                    return isMatch(s, idx1 + 1, p, idx2) || isMatch(s, idx1, p, idx2 + 2);
                }
                return isMatch(s, idx1, p, idx2 + 2);
            } else if (p.charAt(idx2) == '.') {
                return isMatch(s, idx1 + 1, p, idx2 + 1);
            } else {
                return p.charAt(idx2) == s.charAt(idx1) && isMatch(s, idx1 + 1, p, idx2 + 1);
            }
        }

        public boolean isMatch(String s, String p) {
            if (s == null && p == null) return true;
            if (s == null || p == null) return false;
            return isMatch(s, 0, p, 0);
        }
    }

}
