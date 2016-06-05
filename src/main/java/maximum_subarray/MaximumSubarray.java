package maximum_subarray;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximumSubarray {
    /*
        Maximum Subarray
        Leetcode #53
        https://leetcode.com/problems/maximum-subarray/
        Difficulty: Medium
     */
    public class Solution {
        public int maxSubArray(int[] nums) {
            int local = nums[0];
            int global = nums[0];
            for (int i = 1; i < nums.length; i++) {
                local = Math.max(local + nums[i], nums[i]);
                global = Math.max(global, local);
            }
            return global;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new MaximumSubarray().new Solution();
            assertEquals(6, sol.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        }
    }
}
