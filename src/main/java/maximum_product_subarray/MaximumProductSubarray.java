package maximum_product_subarray;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximumProductSubarray {

    public class Solution {
        public int maxProduct(int[] nums) {
            int globalMax = nums[0];
            int prevMax = nums[0];
            int prevMin = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int max;
                int min;
                if (nums[i] > 0) {
                    max = Math.max(nums[i], prevMax * nums[i]);
                    min = Math.min(nums[i], prevMin * nums[i]);
                } else {
                    max = Math.max(nums[i], prevMin * nums[i]);
                    min = Math.min(nums[i], prevMax * nums[i]);
                }
                globalMax = Math.max(globalMax, max);
                prevMax = max;
                prevMin = min;
            }
            return globalMax;
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

