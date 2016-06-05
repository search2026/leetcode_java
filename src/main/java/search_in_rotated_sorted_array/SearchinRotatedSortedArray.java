package search_in_rotated_sorted_array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SearchinRotatedSortedArray {
    /*
        Search in rotated Sorted Array
        Leetcode #33
        https://leetcode.com/problems/search-in-rotated-sorted-array/
        Difficulty: Medium
     */
    public class Solution {
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
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
    public class SolutionII {
        public boolean search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
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
                    left++; // or right-- take care of duplicates
                }
            }
            return false;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new SearchinRotatedSortedArray().new Solution();
            assertEquals(7, 7);
        }
    }
}
