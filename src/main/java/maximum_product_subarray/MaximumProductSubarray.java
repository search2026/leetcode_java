package maximum_product_subarray;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximumProductSubarray {
    /*
        Maximum Product Subarray
        https://leetcode.com/problems/maximum-product-subarray/
        Difficulty: Medium
     */
    public class Solution {
        public int maxProduct(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int local_max = nums[0];
            int local_min = nums[0];
            int global = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int pre_local_max = local_max;
                local_max = Math.max(Math.max(pre_local_max * nums[i], nums[i]), local_min * nums[i]);
                local_min = Math.min(Math.min(pre_local_max * nums[i], nums[i]), local_min * nums[i]);
                global = Math.max(local_max, global);
            }
            return global;
        }
    }

    public static class UnitTest {

        @Test
        public void testMaxProduct() {
            Solution s = new MaximumProductSubarray().new Solution();
            assertEquals(12, s.maxProduct(new int[]{-4, -3, -2}));
        }
    }
}

