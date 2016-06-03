package decode_ways;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DecodeWays {
    /*
        Decode Ways
        Leetcode #91
        https://leetcode.com/problems/decode-ways/
        Difficulty: Medium
     */
    public class Solution {
        public int numDecodings(String s) {
            if (s == null || s.length() == 0) return 0;
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

    /*
        Decode Ways
        Leetcode #91
        https://leetcode.com/problems/decode-ways/
        Difficulty: Medium
     */
    public class Solution_2 {
        public int numDecodings(String s) {
            if (s==null || s.length()==0 || s.charAt(0)=='0') return 0;
            int n = s.length();
            int[] dp = new int[n+1];
            dp[0] = 1;
            dp[1] = s.charAt(0) == '0' ? 0 : 1;
            for (int i=2; i<=s.length(); i++) {
                if (s.charAt(i-1) == '0') {
                    if (s.charAt(i-2) == '1' || s.charAt(i-2) == '2') dp[i] = dp[i-2]; // 10, 20
                    else return 0;  // 30, 40, 50.....90
                } else {
                    if (s.charAt(i-2) == '0') dp[i] = dp[i-1];  // 01, 02, 03...09
                    else if (s.charAt(i-2) == '1') dp[i] = dp[i-1] + dp[i-2]; // 11, 12, 13... 19
                    else if (s.charAt(i-2) >= '3') dp[i] = dp[i-1]; // 31, 32...39, 41, 42...49, 51...91, 99
                    else {
                        if (s.charAt(i-1) == '7' || s.charAt(i-1) == '8' || s.charAt(i-1) == '9') dp[i] = dp[i-1]; // 27, 28, 29
                        else dp[i] = dp[i-1] + dp[i-2]; // 21, 22, ..26
                    }
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
