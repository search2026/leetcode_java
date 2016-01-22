package scramble_string;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ScrambleString {
    /*
        Scramble String
        https://leetcode.com/problems/scramble-string/
        Difficulty: Hard
     */
    public class Solution {
        public boolean isScramble(String s1, String s2) {
            if (s1 == null || s2 == null || s1.length() != s2.length()) return false;
            if (s1.length() == 0) return true;
            boolean[][][] dp = new boolean[s1.length()][s2.length()][s1.length() + 1];
            for (int i = 0; i < s1.length(); i++) {
                for (int j = 0; j < s2.length(); j++) {
                    dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
                }
            }
            for (int len = 2; len <= s1.length(); len++) {
                for (int i = 0; i + len - 1 < s1.length(); i++) {
                    for (int j = 0; j + len - 1 < s2.length(); j++) {
                        for (int k = 1; k < len; k++) {
                            dp[i][j][len] |= dp[i][j][k] && dp[i + k][j + k][len - k] || dp[i][j + len - k][k] && dp[i + k][j][len - k];
                        }
                    }
                }
            }
            return dp[0][0][s1.length()];
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new ScrambleString().new Solution();
            assertFalse(sol.isScramble("rttae", "great"));
            assertTrue(sol.isScramble("rgtae", "great"));
        }
    }
}
