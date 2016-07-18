package search_in_rotated_sorted_array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SearchinRotatedSortedArray {
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
      int[] test = {4, 5, 6, 7, 0, 1, 2};
      assertEquals(-1, sol.search(test, 3));
      assertEquals(0, sol.search(test, 4));
      assertEquals(3, sol.search(test, 7));
      assertEquals(6, sol.search(test, 2));
    }

    @Test
    public void test2() {
      Solution_2 sol = new SearchinRotatedSortedArray().new Solution_2();
      int[] test = {4, 5, 6, 7, 7, 0, 1, 2};
      assertFalse(sol.search(test, 3));
      assertTrue(sol.search(test, 4));
      assertTrue(sol.search(test, 7));
      assertTrue(sol.search(test, 2));
    }
  }
}
