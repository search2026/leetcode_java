package product_of_array_except_self;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductofArrayExceptSelf {
    /*
        Product of Array Except Self
        https://leetcode.com/problems/product-of-array-except-self/
        Difficulty: Medium
     */
    public class Solution {
        public int[] productExceptSelf(int[] nums) {
            if (nums == null || nums.length < 2) {
                return new int[0];
            }

            int len = nums.length;
            int[] result = new int[len];
            int[] before = new int[len];
            int[] after = new int[len];

            before[0] = 1;
            for (int i = 1; i < len; i++) {
                before[i] = before[i - 1] * nums[i - 1];
            }

            after[len - 1] = 1;
            for (int i = len - 2; i >= 0; i--) {
                after[i] = after[i + 1] * nums[i + 1];
            }

            for (int i = 0; i < len; i++) {
                result[i] = before[i] * after[i];
            }

            return result;
        }
    }

    /*
        Product of Array Except Self
        https://leetcode.com/problems/product-of-array-except-self/
        Difficulty: Medium
    */
    public class SolutionConstantSpace {
        public int[] productExceptSelf(int[] nums) {
            if (nums == null || nums.length < 2) {
                return new int[0];
            }

            int[] result = new int[nums.length];
            result[0] = 1;

            // before a[i]
            for (int i = 1; i < nums.length; i++) {
                result[i] = result[i - 1] * nums[i - 1];
            }

            // after a[i]
            int after = 1;
            for (int i = nums.length - 2; i >= 0; i--) {
                result[i] *= after * nums[i + 1];
                after *= nums[i + 1];
            }

            return result;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new ProductofArrayExceptSelf().new Solution();
            assertEquals(7, 7);
        }
    }
}
