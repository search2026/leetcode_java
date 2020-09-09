package com.search2026.leetcode.problems;

public class FirstMissingPositive {

    /*
        First Missing Positive
        Leetcode #41
        https://leetcode.com/problems/first-missing-positive/
        Difficulty: Hard
     */
    public class Solution {
        private void swap(int[] nums, int i, int j) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
        }

        public int firstMissingPositive(int[] nums) {
            if (nums == null || nums.length == 0) return 1;
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1])
                    swap(nums, i, nums[i] - 1);
            }
            for (int i = 0; i < n; i++)
                if (nums[i] != i + 1)
                    return i + 1;
            return n + 1;
        }
    }

}
