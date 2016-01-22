package regular_expression_matching;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RegularExpressionMatching {
    /*
        Regular Expression Matching
        https://leetcode.com/problems/regular-expression-matching/
        Difficulty: Hard
     */
    public class Solution_2 {
        public boolean isMatch(String s, String p) {
            if (s == null || p == null) return false;
            boolean[][] res = new boolean[s.length() + 1][p.length() + 1];
            res[0][0] = true;
            for (int m = 1; m <= p.length(); m++) {
                if (p.charAt(m - 1) == '*') {
                    res[0][m] = res[0][m - 2];
                }
            }

            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '*' && p.charAt(j - 2) != '.') {
                    for (int i = 1; i <= s.length(); i++) {
                        if (res[i][j - 1] || res[i][j - 2]) res[i][j] = true;
                        else if (res[i - 1][j] && i > 1 && p.charAt(j - 2) == s.charAt(i - 2) && s.charAt(i - 2) == s.charAt(i - 1)) {
                            res[i][j] = true;
                        }
                    }
                } else if (p.charAt(j - 1) == '*' && p.charAt(j - 2) == '.') {
                    for (int i = 1; i <= s.length(); i++) {
                        if (res[i][j - 1] || res[i][j - 2]) {
                            res[i][j] = true;
                            while (i <= s.length()) {
                                res[i][j] = true;
                                i++;
                            }
                        }
                    }
                } else {
                    for (int i = 1; i <= s.length(); i++) {
                        if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
                            res[i][j] = res[i - 1][j - 1];
                        }
                    }
                }
            }
            return res[s.length()][p.length()];
        }
    }

    /*
        Regular Expression Matching - Dynamic Programming
        https://leetcode.com/problems/regular-expression-matching/
        Difficulty: Hard
    */
    public class Solution {
        public boolean isMatch(String s, String p) {
            boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
            dp[0][0] = true;
            for (int i = 1; i <= p.length(); i++) {
                dp[i][0] = p.charAt(i - 1) == '*' && dp[i - 2][0];
                for (int j = 1; j <= s.length(); j++) {
                    if (p.charAt(i - 1) == '*') {
                        if (dp[i - 2][j]) {
                            dp[i][j] = true;
                            continue;
                        }
                        char prev = p.charAt(i - 2);
                        for (int k = j; k > 0; k--) {
                            if (prev != '.' && prev != s.charAt(k - 1)) {
                                break;
                            }
                            if (dp[i - 2][k - 1]) {
                                dp[i][j] = true;
                                break;
                            }
                        }
                    } else {
                        dp[i][j] = dp[i - 1][j - 1]
                                && (p.charAt(i - 1) == '.' || p.charAt(i - 1) == s
                                .charAt(j - 1));
                    }
                }

            }
            return dp[p.length()][s.length()];
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new RegularExpressionMatching().new Solution();
            assertFalse(sol.isMatch("aa", "a"));
            assertTrue(sol.isMatch("aa", "aa"));
            assertFalse(sol.isMatch("aaa", "aa"));
            assertTrue(sol.isMatch("aa", "a*"));
            assertTrue(sol.isMatch("aa", ".*"));
            assertTrue(sol.isMatch("ab", ".*"));
            assertTrue(sol.isMatch("aab", "c*a*b"));
            assertTrue(true);
        }

        @Test
        public void test2() {
            Solution_2 sol = new RegularExpressionMatching().new Solution_2();
            assertFalse(sol.isMatch("aa", "a"));
            assertTrue(sol.isMatch("aa", "aa"));
            assertFalse(sol.isMatch("aaa", "aa"));
            assertTrue(sol.isMatch("aa", "a*"));
            assertTrue(sol.isMatch("aa", ".*"));
            assertTrue(sol.isMatch("ab", ".*"));
            assertTrue(sol.isMatch("aab", "c*a*b"));
            assertTrue(true);
        }
    }
}
