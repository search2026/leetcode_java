package longest_valid_parentheses;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestValidParentheses {
    /*
        Longest Valid Parentheses
        https://leetcode.com/problems/longest-valid-parentheses/
        leetcode 32
        Difficulty: Hard
     */
    public class Solution {
        public int longestValidParentheses(String s) {
            int[] dp = new int[s.length()];
            int max = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ')') {
                    int p = i - 1;
                    while (p >= 0) {
                        if (s.charAt(p) == '(') {
                            dp[i] = i - p + 1 + (p > 0 ? dp[p - 1] : 0);
                            break;
                        } else if (dp[p] == 0) {
                            break;
                        }
                        p = p - dp[p];
                    }
                }
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new LongestValidParentheses().new Solution();
            assertEquals(3, 3);
        }
    }
}
