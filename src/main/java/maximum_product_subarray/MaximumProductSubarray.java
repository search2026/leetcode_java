package maximum_product_subarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumProductSubarray {
    /*
        Maximum Product Subarray
        Leetcode #152
        https://leetcode.com/problems/maximum-product-subarray/
        Difficulty: Medium
     */
    public class Solution {
        public int maxProduct(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int localMax = nums[0];
            int localMin = nums[0];
            int global = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int prevMax = localMax;
                int prevMin = localMin;
                localMax = Math.max(Math.max(prevMax * nums[i], nums[i]), prevMin * nums[i]);
                localMin = Math.min(Math.min(prevMax * nums[i], nums[i]), prevMin * nums[i]);
                global = Math.max(localMax, global);
            }
            return global;
        }
    }

    public static class UnitTest {

        @Test
        public void testMaxProduct() {
            Solution s = new MaximumProductSubarray().new Solution();
            assertEquals(12, s.maxProduct(new int[]{-4, -3, -2}));
            assertEquals(6, s.maxProduct(new int[]{2, 3, -2, 4}));
            assertEquals(48, s.maxProduct(new int[]{2, 3, -2, -4}));
        }
    }
}

