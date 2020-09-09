package com.search2026.leetcode.problems;

public class SearchInRotatedSortedArray {

    /*
        Search in rotated Sorted Array
        Leetcode #33
        https://leetcode.com/problems/search-in-rotated-sorted-array/
        Difficulty: Medium
     */
    public class Solution {
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) return -1;

            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[left] <= nums[mid]) {
                    if (nums[left] <= target && target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    if (nums[mid] < target && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }

            return -1;
        }
    }

    /*
        Search in rotated Sorted Array II - Duplicates are allowed
        Leetcode #81
        https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
        Difficulty: Medium
    */
    public class Solution_2 {
        public boolean search(int[] nums, int target) {
            if (nums == null || nums.length == 0) return false;

            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return true;
                }
                if (nums[left] < nums[mid]) {
                    if (nums[left] <= target && target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else if (nums[left] > nums[mid]) {
                    if (nums[mid] < target && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    left++; // take care of duplicates Note: right-- will not work
                }
            }

            return false;
        }
    }

}
