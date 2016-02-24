package search_for_a_range;

import org.junit.Test;

import static org.junit.Assert.*;

public class SearchforaRange {
    /*
        Search for a Range
        https://leetcode.com/problems/search-for-a-range/
        Difficulty: Medium
     */
    public class Solution {
        private int lowerBound(int[] nums, int left, int right, int target) {
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

        public int[] searchRange(int[] nums, int target) {
            int[] rslt = new int[2];
            int begin = lowerBound(nums, 0, nums.length - 1, target);
            if (begin < nums.length && nums[begin] == target) {
                rslt[0] = begin;
                rslt[1] = lowerBound(nums, begin + 1, nums.length - 1, target + 1) - 1;
            } else {
                rslt[0] = -1;
                rslt[1] = -1;
            }
            return rslt;
        }
    }

    /*
        Search for a Range - With Flag
        https://leetcode.com/problems/search-for-a-range/
        Difficulty: Medium
    */
    public class Solution_2 {
        public int[] searchRange(int[] nums, int target) {
            int[] rslt = new int[]{-1, -1};
            if (nums.length <= 0) return rslt;

            int begin = search(nums, 0, nums.length - 1, target, true);
            if (begin >= 0 && begin < nums.length && nums[begin] == target) {
                rslt[0] = begin;
                rslt[1] = search(nums, begin, nums.length - 1, target, false);
            }
            return rslt;
        }

        int search(int[] nums, int left, int right, int target, boolean turnLeft) {
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
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new SearchforaRange().new Solution();
            int[] results = sol.searchRange(new int[]{1,2,2,2,3,5}, 2);
            assertEquals(results[0], 1);
            assertEquals(results[1], 3);
        }

        @Test
        public void test2() {
            Solution_2 sol = new SearchforaRange().new Solution_2();
            int[] results = sol.searchRange(new int[]{1,2,2,2,3,5}, 2);
            assertEquals(results[0], 1);
            assertEquals(results[1], 3);
        }
    }
}
