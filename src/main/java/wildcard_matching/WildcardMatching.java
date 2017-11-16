package wildcard_matching;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WildcardMatching {
    /*
        Wildcard Matching - Dynamic Programming
        Leetcode #44
        https://leetcode.com/problems/wildcard-matching/
        Difficulty: Hard
     */
    public class Solution {
        public boolean isMatch(String s, String p) {
            if (s == null && p == null) return true;
            if (s == null || p == null) return false;
            if (p.length() == 0) return s.length() == 0;
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;

            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) != '*') {
                    for (int j = s.length() - 1; j >= 0; j--)
                        dp[j + 1] = dp[j] && (p.charAt(i) == '?' || s.charAt(j) == p.charAt(i));
                } else {
                    int k = 0;
                    while (k <= s.length() && !dp[k]) k++;
                    for (; k <= s.length(); k++) dp[k] = true;
                }
                dp[0] = dp[0] && p.charAt(i) == '*';
            }
            return dp[s.length()];
        }
    }

    /*
        Wildcard Matching - Iterative
        Leetcode #44
        https://leetcode.com/problems/wildcard-matching/
        Difficulty: Hard
     */
    public class Solution_2 {
        public boolean isMatch(String s, String p) {
            int ps = 0, pp = 0, match = 0, starIdx = -1;
            while (ps < s.length()) {
                if (pp < p.length() && (p.charAt(pp) == '?' || s.charAt(ps) == p.charAt(pp))) {
                    // advancing both pointers
                    ps++;
                    pp++;
                } else if (pp < p.length() && p.charAt(pp) == '*') {
                    // * found, only advancing pattern pointer
                    starIdx = pp;
                    match = ps;
                    pp++;
                } else if (starIdx != -1) {
                    // last pattern pointer was *, advancing string pointer
                    pp = starIdx + 1;
                    match++;
                    ps = match;
                } else {
                    // current pattern pointer is not star, last patter pointer was not *
                    // characters do not match
                    return false;
                }
            }

            //check for remaining characters in pattern
            while (pp < p.length() && p.charAt(pp) == '*')
                pp++;

            return pp == p.length();
        }
    }

    /*
        Wildcard Matching - Recursion
        Leetcode #44
        https://leetcode.com/problems/wildcard-matching/
        Difficulty: Hard
     */
    public class Solution_3 {
        Integer level = 0;

        private boolean search(char[] s, char[] p, int i, int j) {
            boolean first = true;
            int curlevel = level;
            if (j == p.length) return i == s.length || p[j - 1] == '*';
            if (i == s.length) {
                while (p[j] == '*' && j < p.length - 1) j++;
                return p[j] == '*';
            }
            if (p[j] == '?')
                return search(s, p, ++i, ++j);
            if (p[j] != '*')
                return p[j] == s[i] && search(s, p, ++i, ++j);
            //p[j]=='*'
            boolean res = false;
            while (j < p.length && p[j] == '*') j++;
            for (int k = i; k <= s.length; k++) {
                if (first) {
                    ++level;
                    first = false;
                }
                if (level > curlevel + 1)
                    return false;
                res |= search(s, p, k, j);
                if (res) return res;
            }
            return res;
        }

        public boolean isMatch(String sS, String pS) {
            char[] s = sS.toCharArray();
            char[] p = pS.toCharArray();
            if (p.length == 0 && s.length > 0) return false;
            return search(s, p, 0, 0);
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new WildcardMatching().new Solution();
            assertFalse(sol.isMatch("aa", "a"));
            assertTrue(sol.isMatch("aa", "aa"));
            assertFalse(sol.isMatch("aaa", "aa"));
            assertTrue(sol.isMatch("aa", "*"));
            assertTrue(sol.isMatch("aa", "a*"));
            assertTrue(sol.isMatch("ab", "?*"));
            assertFalse(sol.isMatch("aab", "c*a*b"));
            assertTrue(sol.isMatch("cazb", "c*a*b"));
        }

        @Test
        public void test2() {
            Solution_2 sol = new WildcardMatching().new Solution_2();
            assertFalse(sol.isMatch("aa", "a"));
            assertTrue(sol.isMatch("aa", "aa"));
            assertFalse(sol.isMatch("aaa", "aa"));
            assertTrue(sol.isMatch("aa", "*"));
            assertTrue(sol.isMatch("aa", "a*"));
            assertTrue(sol.isMatch("ab", "?*"));
            assertFalse(sol.isMatch("aab", "c*a*b"));
            assertTrue(sol.isMatch("cazb", "c*a*b"));
        }

        @Test
        public void test3() {
            Solution_3 sol = new WildcardMatching().new Solution_3();
            assertFalse(sol.isMatch("aa", "a"));
            assertTrue(sol.isMatch("aa", "aa"));
            assertFalse(sol.isMatch("aaa", "aa"));
            assertTrue(sol.isMatch("aa", "*"));
            assertTrue(sol.isMatch("aa", "a*"));
            assertTrue(sol.isMatch("ab", "?*"));
            assertFalse(sol.isMatch("aab", "c*a*b"));
            assertTrue(sol.isMatch("cazb", "c*a*b"));
        }
    }
}
