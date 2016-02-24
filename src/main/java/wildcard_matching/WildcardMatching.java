package wildcard_matching;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WildcardMatching {
    /*
        Wildcard Matching - Dynamic Programming
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
        Wildcard Matching - Greedy Search
        https://leetcode.com/problems/wildcard-matching/
        Difficulty: Hard
     */
    public class Solution_2 {
        public boolean isMatch(String s, String p) {
            int pLen = p.length();
            int sLen = s.length();
            if (s.length() == 0 && p.length() == 0) return true;

            int pIdx = 0;
            int sIdx = 0;
            int star_p = -1;
            int star_s = -1;
            char charS, charP;
            while (true) {
                // if all of s has been matched and there is still unused p,
                // then return true only if what left inside p are '*".
                if (pIdx < pLen && sIdx >= sLen) {
                    for (int i = pIdx; i < pLen; i++)
                        if (p.charAt(i) != '*') return false;
                    return true;
                }

                // if all of p has been used
                if (pIdx >= pLen) {
                    // if still has unmatched s, then backtrack to the last occurrence
                    // of '*'. If there is no '*', return false.
                    if (sIdx < sLen) {
                        if (star_p == -1) return false;
                        pIdx = star_p + 1;
                        star_s++;
                        sIdx = star_s;
                    } else return true;
                } else {
                    charS = s.charAt(sIdx);
                    charP = p.charAt(pIdx);
                    if (charP == '?' || charP == charS) {
                        pIdx++;
                        sIdx++;
                    } else if (charP == '*') {
                        star_p = pIdx;
                        star_s = sIdx;
                        pIdx++;
                    } else {
                        if (star_p == -1) return false;
                        pIdx = star_p + 1;
                        star_s++;
                        sIdx = star_s;
                    }
                }
            }
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
    }
}
