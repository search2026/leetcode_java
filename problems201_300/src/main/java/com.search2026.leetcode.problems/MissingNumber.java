package com.search2026.leetcode.problems;

public class MissingNumber {

    /*
        Missing Number
        Leetcode #268
        https://leetcode.com/problems/missing-number/
        Difficulty: Medium
     */
    public class Solution {
        public int missingNumber(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            // Step 1: iterate the array and swap according to the buckets
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (num != i && num < nums.length && num != nums[num]) {
                    swap(nums, i, num);
                    i--;
                }
            }

            // Step 2: iterate again to findRoot out the missing number
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i) {
                    return i;
                }
            }

            return nums.length;
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

}
