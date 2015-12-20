package burst_balloons;

import org.junit.Test;

import static org.junit.Assert.*;

public class BurstBalloons {
    /*
        Burst Ballons
        https://leetcode.com/problems/burst-balloons/
        ifficulty: Hard
     */
    public class Solution {
        public int maxCoins(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int length = nums.length;
            int[][] dp = new int[length][length];
            for (int len = 1; len <= length; len++) {
                for (int i = 0; i < length - len + 1; i++) {
                    int start = i;
                    int end = i + len - 1;
                    int s = start - 1 == -1 ? 1 : nums[start - 1];
                    int e = end + 1 == length ? 1 : nums[end + 1];
                    for (int j = start; j <= end; j++) {
                        int tmp = nums[j] * s * e;
                        tmp += j != start ? dp[start][j - 1] : 0;
                        tmp += j != end ? dp[j + 1][end] : 0;
                        dp[start][end] = Math.max(dp[start][end], tmp);
                    }
                }
            }
            return dp[0][length - 1];
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new BurstBalloons().new Solution();
        }
    }
}

