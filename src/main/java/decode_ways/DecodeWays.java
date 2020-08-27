package decode_ways;

import org.junit.jupiter.api.Test;

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

    /*
        Decode Ways II - Dynamic Programming
        Leetcode #639
        https://leetcode.com/problems/decode-ways-ii/description/
        Difficulty: Medium
     */
    public class Solution_3 {
        private int ways(int ch) {
            if (ch == '*') return 9;
            if (ch == '0') return 0;
            return 1;
        }

        private int ways(char ch1, char ch2) {
            String str = "" + ch1 + "" + ch2;
            if (ch1 != '*' && ch2 != '*') {
                if (Integer.parseInt(str) >= 10 && Integer.parseInt(str) <= 26)
                    return 1;
            } else if (ch1 == '*' && ch2 == '*') {
                return 15;
            } else if (ch1 == '*') {
                if (Integer.parseInt("" + ch2) >= 0 && Integer.parseInt("" + ch2) <= 6)
                    return 2;
                else
                    return 1;
            } else {
                if (Integer.parseInt("" + ch1) == 1) {
                    return 9;
                } else if (Integer.parseInt("" + ch1) == 2) {
                    return 6;
                }
            }
            return 0;
        }

        // https://leetcode.com/problems/decode-ways-ii/discuss/105275/Java-DP-O(n)-time-and-O(1)-space
        public int numDecodings(String s) {
            long[] res = new long[2];
            res[0] = ways(s.charAt(0));
            if (s.length() < 2) return (int) res[0];

            res[1] = res[0] * ways(s.charAt(1)) + ways(s.charAt(0), s.charAt(1));
            for (int j = 2; j < s.length(); j++) {
                long temp = res[1];
                res[1] = (res[1] * ways(s.charAt(j)) + res[0] * ways(s.charAt(j - 1), s.charAt(j))) % 1000000007;
                res[0] = temp;
            }
            return (int) res[1];
        }
    }

    /*
        Decode Ways II - Dynamic Programming Template
        Leetcode #639
        https://leetcode.com/problems/decode-ways-ii/description/
        Difficulty: Medium
     */
    public class Solution_4 {
        // https://leetcode.com/problems/decode-ways-ii/discuss/105258/Java-O(N)-by-General-Solution-for-all-DP-problems
        public int numDecodings(String s) {
            /* initial conditions */
            long[] dp = new long[s.length() + 1];
            dp[0] = 1;
            if (s.charAt(0) == '0') {
                return 0;
            }
            dp[1] = (s.charAt(0) == '*') ? 9 : 1;

            /* bottom up method */
            for (int i = 2; i <= s.length(); i++) {
                char first = s.charAt(i - 2);
                char second = s.charAt(i - 1);

                // For dp[i-1]
                if (second == '*') {
                    dp[i] += 9 * dp[i - 1];
                } else if (second > '0') {
                    dp[i] += dp[i - 1];
                }

                // For dp[i-2]
                if (first == '*') {
                    if (second == '*') {
                        dp[i] += 15 * dp[i - 2];
                    } else if (second <= '6') {
                        dp[i] += 2 * dp[i - 2];
                    } else {
                        dp[i] += dp[i - 2];
                    }
                } else if (first == '1' || first == '2') {
                    if (second == '*') {
                        if (first == '1') {
                            dp[i] += 9 * dp[i - 2];
                        } else { // first == '2'
                            dp[i] += 6 * dp[i - 2];
                        }
                    } else if (((first - '0') * 10 + (second - '0')) <= 26) {
                        dp[i] += dp[i - 2];
                    }
                }

                dp[i] %= 1000000007;
            }
            /* Return */
            return (int) dp[s.length()];
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new DecodeWays().new Solution();
            assertEquals(0, sol.numDecodings(""));
            assertEquals(0, sol.numDecodings("0"));
            assertEquals(1, sol.numDecodings("5"));
            assertEquals(1, sol.numDecodings("10"));
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
            assertEquals(1, sol.numDecodings("10"));
            assertEquals(2, sol.numDecodings("12"));
            assertEquals(2, sol.numDecodings("15"));
            assertEquals(2, sol.numDecodings("26"));
            assertEquals(0, sol.numDecodings("30"));
            assertEquals(1, sol.numDecodings("42"));
        }

        @Test
        public void test3() {
            Solution_3 sol = new DecodeWays().new Solution_3();
            assertEquals(9, sol.numDecodings("*"));
            assertEquals(18, sol.numDecodings("1*"));
        }

        @Test
        public void test4() {
            Solution_4 sol = new DecodeWays().new Solution_4();
            assertEquals(9, sol.numDecodings("*"));
            assertEquals(18, sol.numDecodings("1*"));
        }
    }
}
