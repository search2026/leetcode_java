package longest_increasing_subsequence;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestIncreasingSubsequence {
    /*
        Longest Increasing Subsequqnce
        https://leetcode.com/problems/longest-increasing-subsequence/
        Difficulty: Medium
     */
    public class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            if (nums.length == 1) {
                return 1;
            }

            int[] dp = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                dp[i] = 1;
            }

            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }

            int result = 1;
            for (int i = 0; i < nums.length; i++) {
                result = Math.max(dp[i], result);
            }

            return result;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new LongestIncreasingSubsequence().new Solution();
        }
    }
}
