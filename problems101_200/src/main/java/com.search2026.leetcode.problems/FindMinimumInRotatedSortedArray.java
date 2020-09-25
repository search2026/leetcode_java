package com.search2026.leetcode.problems;

public class FindMinimumInRotatedSortedArray {

    /*
        Find Minimum in Rotated Sorted Array
        Leetcode #153
        https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
        Difficulty: Medium
     */
    public class Solution {
        public int findMin(int[] nums) {
            if (nums == null || nums.length == 0) return -1;
            int left = 0, right = nums.length - 1;
            while (left < right && nums[left] >= nums[right]) {
                int mid = left + (right - left) / 2;
                if (nums[left] <= nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return nums[left];
        }
    }

    /*
        Find Minimum in Rotated Sorted Array II
        Leetcode #154
        https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
        Difficulty: Hard
     */
    public class Solution_2 {
        public int findMin(int[] nums) {
            if (nums == null || nums.length == 0) return -1;
            int left = 0, right = nums.length - 1;
            while (left < right && nums[left] >= nums[right]) {
                int mid = left + (right - left) / 2;
                if (nums[left] < nums[mid]) {
                    left = mid + 1;
                } else if (nums[left] > nums[mid]) {
                    right = mid;
                } else { // nums[left] == nums[mid] == nums[right]
                    left++; // or right--;
                }
            }
            return nums[left];
        }
    }

}
