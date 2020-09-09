package com.search2026.leetcode.problems;

public class SearchInsertPosition {

    /*
        Search Insert Position
        Leetcode #35
        https://leetcode.com/problems/search-insert-position/
        Difficulty: Medium
     */
    public class Solution {
        public int searchInsert(int[] nums, int target) {
            if (nums == null || nums.length == 0) return -1;
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }
    }

}
