package find_minimum_in_rotated_sorted_array;

import java.util.*;

import org.junit.*;

import static org.junit.Assert.*;

public class FindMinimuminRotatedSortedArray {
    /*
        Find Minimum in Rotated Sorted Array
        https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
        Difficulty: Medium
     */
    public class Solution {
        public int findMin(int[] nums) {
            assert (nums.length > 0);
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] < nums[right]) {
                    return nums[left];
                }
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
        https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
        Difficulty: Hard
     */
    public class Solution_2 {
        public int findMinII(int[] num) {
            assert (num.length > 0);
            int left = 0;
            int right = num.length - 1;
            while (left < right) {
                if (num[left] < num[right]) {
                    return num[left];
                } else if (num[left] == num[right]) {
                    right--;
                } else {
                    int mid = left + (right - left) / 2;
                    if (num[left] == num[mid]) {
                        left++;
                    } else if (num[left] < num[mid]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
            }
            return num[left];
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new FindMinimuminRotatedSortedArray().new Solution();
            assertTrue(true);
        }
    }
}

