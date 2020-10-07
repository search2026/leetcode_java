package com.search2026.leetcode.problems;

public class ProductOfArrayExceptSelf {

    /*
        Product of Array Except Self
        Leetcode #238
        https://leetcode.com/problems/product-of-array-except-self/
        Difficulty: Medium
     */
    public class Solution {
        public int[] productExceptSelf(int[] nums) {
            if (nums == null || nums.length < 2) {
                return new int[0];
            }

            int len = nums.length;
            int[] res = new int[len];
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
                res[i] = before[i] * after[i];
            }

            return res;
        }
    }

    /*
        Product of Array Except Self
        Leetcode #238
        https://leetcode.com/problems/product-of-array-except-self/
        Difficulty: Medium
    */
    public class SolutionConstantSpace {
        public int[] productExceptSelf(int[] nums) {
            if (nums == null || nums.length < 2) {
                return new int[0];
            }

            int[] res = new int[nums.length];
            res[0] = 1;

            // before a[i]
            for (int i = 1; i < nums.length; i++) {
                res[i] = res[i - 1] * nums[i - 1];
            }

            // after a[i]
            int after = 1;
            for (int i = nums.length - 2; i >= 0; i--) {
                res[i] *= after * nums[i + 1];
                after *= nums[i + 1];
            }

            return res;
        }
    }

}
