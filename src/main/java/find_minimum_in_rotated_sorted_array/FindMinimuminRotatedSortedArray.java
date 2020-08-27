package find_minimum_in_rotated_sorted_array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindMinimuminRotatedSortedArray {
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

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new FindMinimuminRotatedSortedArray().new Solution();
            assertEquals(1, sol.findMin(new int[]{2, 1}));
            assertEquals(1, sol.findMin(new int[]{3, 1, 2}));
            assertEquals(0, sol.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
            assertEquals(7, sol.findMin(new int[]{7, 8, 9, 11}));
            assertEquals(-4, sol.findMin(new int[]{-1, 0, 9, 11, -4}));
        }

        @Test
        public void test2() {
            Solution_2 sol = new FindMinimuminRotatedSortedArray().new Solution_2();
            assertEquals(1, sol.findMin(new int[]{2, 1}));
            assertEquals(1, sol.findMin(new int[]{3, 1, 2}));
            assertEquals(0, sol.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
            assertEquals(0, sol.findMin(new int[]{4, 5, 5, 6, 7, 7, 7, 0, 0, 1, 2}));
            assertEquals(7, sol.findMin(new int[]{7, 8, 9, 11}));
            assertEquals(7, sol.findMin(new int[]{7, 7, 7, 8, 9, 9, 9, 9, 11}));
            assertEquals(-4, sol.findMin(new int[]{-1, 0, 9, 11, -4}));
            assertEquals(-4, sol.findMin(new int[]{-1, -1, 0, 0, 0, 0, 9, 11, -4, -4}));
            assertEquals(0, sol.findMin(new int[]{1, 1, 1, 0, 1}));
            assertEquals(0, sol.findMin(new int[]{1, 1, 1, 1, 1, 0}));
            assertEquals(0, sol.findMin(new int[]{0, 1, 1, 1, 1, 1}));
        }
    }
}

