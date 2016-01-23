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

            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) != '*') {
                    for (int i = s.length() - 1; i >= 0; i--) {
                        dp[i + 1] = dp[i] && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j));
                    }
                } else {
                    int i = 0;
                    while (i <= s.length() && !dp[i])
                        i++;
                    for (; i <= s.length(); i++) {
                        dp[i] = true;
                    }
                }
                dp[0] = dp[0] && p.charAt(j) == '*';
            }
            return dp[s.length()];
        }
    }

    /*
        Wildcard Matching - Backtracking
        https://leetcode.com/problems/wildcard-matching/
        Difficulty: Hard
     */
    public class Solution_2 {
        public boolean isMatch(String s, String p) {
            int sLen = s.length();
            int pLen = p.length();
            if (s == "" && p == "") return true;


            int pInd = 0;
            int sInd = 0;
            int star = -1;
            int starS = -1;
            char charS, charP;
            while (true) {
                //Determin the current state of the problem first.
                //if all s has been matched, but there is still unused p,
                //then return true only if all the p left are '*", otherwise return false;
                if (pInd < pLen && sInd >= sLen) {
                    for (int i = pInd; i < pLen; i++)
                        if (p.charAt(i) != '*')
                            return false;
                    return true;
                }

                //If all the p has been used
                if (pInd >= pLen) {
                    //if still has unmatched s, then backtrack to the last currence of '*'
                    //otherwise, return true;
                    if (sInd < sLen) {
                        if (star == -1) return false;
                        pInd = star + 1;
                        starS++;
                        sInd = starS;
                    } else return true;
                } else {
                    charS = s.charAt(sInd);
                    charP = p.charAt(pInd);
                    boolean match = false;
                    if (charP == '?' || charP == charS) {
                        pInd++;
                        sInd++;
                    } else if (charP == '*') {
                        star = pInd;
                        starS = sInd;
                        pInd++;
                    } else {
                        if (star == -1) return false;
                        pInd = star + 1;
                        starS++;
                        sInd = starS;
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
        }
    }
}
