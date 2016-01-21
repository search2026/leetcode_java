package decode_ways;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DecodeWays {
    /*
        Decode Ways
        https://leetcode.com/problems/decode-ways/
        Difficulty: Medium
     */
    public class Solution {
        public int numDecodings(String s) {
            if (s == null || s.length() == 0)
                return 0;
            int n = s.length();
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = s.charAt(0) == '0' ? 0 : 1;
            for (int i = 1; i < n; i++) {
                dp[i + 1] = s.charAt(i) == '0' ? 0 : dp[i];
                if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')) {
                    dp[i + 1] += dp[i - 1];
                }
            }
            return dp[n];
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new DecodeWays().new Solution();
            assertEquals(2, sol.numDecodings("12"));
        }
    }
}
