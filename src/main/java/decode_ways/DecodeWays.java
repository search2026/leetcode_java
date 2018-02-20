package decode_ways;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecodeWays {
    /*
        Decode Ways - Dynamic Programming
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
        Decode Ways - Dynamic Programming Top Down
        Leetcode #91
        https://leetcode.com/problems/decode-ways/
        Difficulty: Medium
     */
    public class Solution_2 {
        public int numDecodings(String s) {
            if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
            int pre = 27, digit, res = 0, first = 1, second = 1;
            for (int i = s.length() - 1; i >= 0; i--) {
                digit = s.charAt(i) - '0';
                if (digit == 0) res = 0;
                else res = first + (digit * 10 + pre < 27 ? second : 0);
                second = first;
                first = res;
                pre = digit;
            }
            return res;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new DecodeWays().new Solution();
            assertEquals(1, sol.numDecodings("5"));
            assertEquals(2, sol.numDecodings("12"));
            assertEquals(2, sol.numDecodings("15"));
            assertEquals(2, sol.numDecodings("26"));
            assertEquals(0, sol.numDecodings("30"));
            assertEquals(1, sol.numDecodings("42"));
        }

        @Test
        public void test2() {
            Solution_2 sol = new DecodeWays().new Solution_2();
            assertEquals(1, sol.numDecodings("5"));
            assertEquals(2, sol.numDecodings("12"));
            assertEquals(2, sol.numDecodings("15"));
            assertEquals(2, sol.numDecodings("26"));
            assertEquals(0, sol.numDecodings("30"));
            assertEquals(1, sol.numDecodings("42"));
        }
    }
}
