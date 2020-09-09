package com.search2026.leetcode.problems;

public class FindFirstAndLastPositionOfElementInSortedArray {

    /*
        Find First and Last Position of Element in Sorted Array - Increase Target
        Leetcode #34
        https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
        Difficulty: Medium
     */
    public class Solution {
        // the same as lower_bound in C++ STL.
        private int lowerBound(int[] nums, int left, int right, int target) {
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    //should not be mid-1 when A[mid]==target.
                    //could be mid even if A[mid]>target because mid<right.
                    right = mid - 1;
                }
            }
            return left;
        }

        public int[] searchRange(int[] nums, int target) {
            int[] range = {-1, -1};
            int begin = lowerBound(nums, 0, nums.length - 1, target);
            if (begin < nums.length && nums[begin] == target) {
                range[0] = begin;
                range[1] = lowerBound(nums, begin + 1, nums.length - 1, target + 1) - 1;
            }
            return range;
        }
    }

    /*
        Find First and Last Position of Element in Sorted Array - With Flag
        Leetcode #34
        https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
        Difficulty: Medium
    */
    public class Solution_2 {
        private int search(int[] nums, int left, int right, int target, boolean turnLeft) {
            if (left > right) return -1;

            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                return search(nums, mid + 1, right, target, turnLeft);
            } else if (nums[mid] > target) {
                return search(nums, left, mid - 1, target, turnLeft);
            }

            if (turnLeft) {
                if (mid == 0 || nums[mid - 1] < nums[mid]) {
                    return mid;
                } else {
                    return search(nums, left, mid - 1, target, turnLeft);
                }
            } else {
                if (mid == nums.length - 1 || nums[mid + 1] > nums[mid]) {
                    return mid;
                } else {
                    return search(nums, mid + 1, right, target, turnLeft);
                }
            }
        }

        public int[] searchRange(int[] nums, int target) {
            int[] range = {-1, -1};
            if (nums.length <= 0) return range;

            int begin = search(nums, 0, nums.length - 1, target, true);
            if (begin >= 0 && begin < nums.length && nums[begin] == target) {
                range[0] = begin;
                range[1] = search(nums, begin, nums.length - 1, target, false);
            }
            return range;
        }
    }

    /*
        Find First and Last Position of Element in Sorted Array - One Binary Search
        https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
        Difficulty: Medium
    */
    public class Solution_3 {
        public int[] searchRange(int[] nums, int target) {
            int[] range = {-1, -1};
            int left = 0, right = nums.length - 1;

            while (nums[left] < nums[right]) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    if (nums[left] == nums[mid]) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }

            if (nums[left] == nums[right] && nums[left] == target) {
                range[0] = left;
                range[1] = right;
            }

            return range;
        }
    }

    /*
        Find First and Last Position of Element in Sorted Array - Two Binary Search
        https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
        Difficulty: Medium
    */
    public class Solution_4 {
        public int[] searchRange(int[] nums, int target) {
            int i = 0, j = nums.length - 1;
            int[] res = {-1, -1};
            // Search for the left one
            while (i < j) {
                int mid = (i + j) / 2;
                if (nums[mid] < target) i = mid + 1;
                else j = mid;
            }
            if (nums[i] != target) return res;
            else res[0] = i;
            // Search for the right one
            j = nums.length - 1;
            while (i < j) {
                int mid = (i + j) / 2 + 1;
                if (nums[mid] > target) j = mid - 1;
                else i = mid;
            }
            res[1] = j;
            return res;
        }
    }

}
