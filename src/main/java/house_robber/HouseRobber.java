package house_robber;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HouseRobber {
    /*
        House Robber
        https://leetcode.com/problems/house-robber/
        Difficulty: Easy
    */
    public class Solution {
        public int rob(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            if (nums.length < 2) {
                return nums[0];
            }
            int f1 = nums[0];
            int f2 = Math.max(nums[0], nums[1]);
            for (int i = 2; i < nums.length; i++) {
                // f(i) = max { f(i - 2) + nums[i], f(i - 1) }
                int f = Math.max(f1 + nums[i], f2);
                f1 = f2;
                f2 = f;
            }
            return f2;
        }
    }

    /*
        House Robber II
        https://leetcode.com/problems/house-robber-ii/
        Difficulty: Medium
    */
    public class Solution_2 {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0)
                return 0;

            int n = nums.length;

            if (n == 1) {
                return nums[0];
            }
            if (n == 2) {
                return Math.max(nums[1], nums[0]);
            }

            //include 1st element, and not last element
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = nums[0];

            for (int i = 2; i < n; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
            }

            //do not include 1st element, and include last element
            int[] dr = new int[n + 1];
            dr[0] = 0;
            dr[1] = nums[1];

            for (int i = 2; i < n; i++) {
                dr[i] = Math.max(dr[i - 1], dr[i - 2] + nums[i]);
            }

            return Math.max(dp[n - 1], dr[n - 1]);
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new HouseRobber().new Solution();
            assertEquals(3, 3);
        }
    }
}

