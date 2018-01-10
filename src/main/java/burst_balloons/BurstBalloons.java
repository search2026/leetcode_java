package burst_balloons;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BurstBalloons {
    /*
        Burst Ballons
        Leetcode #312
        https://leetcode.com/problems/burst-balloons/
        Difficulty: Hard
     */
    public class Solution {
        public int maxCoins(int[] nums) {
            int n = nums.length + 2;
            int[] arr = new int[n];  //expanded nums
            arr[0] = arr[n - 1] = 1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0)
                    arr[i + 1] = nums[i];
            }
            int[][] dp = new int[n][n];
            for (int i = 2; i <= n - 1; i++) {
                for (int l = 0; l <= n - 1 - i; l++) {
                    int r = l + i;
                    for (int j = l + 1; j < r; j++) {
                        dp[l][r] = Math.max(dp[l][r], arr[l] * arr[r] * arr[j] + dp[l][j] + dp[j][r]);
                    }
                }
            }
            return dp[0][n - 1];
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new BurstBalloons().new Solution();
            assertEquals(167, sol.maxCoins(new int[]{3,1,5,8}));
        }
    }
}

