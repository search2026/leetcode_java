package search_insert_position;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new SearchInsertPosition().new Solution();
            assertEquals(2, sol.searchInsert(new int[]{1, 3, 5, 6}, 5));
            assertEquals(1, sol.searchInsert(new int[]{1, 3, 5, 6}, 2));
            assertEquals(4, sol.searchInsert(new int[]{1, 3, 5, 6}, 7));
            assertEquals(0, sol.searchInsert(new int[]{1, 3, 5, 6}, 0));
        }
    }
}
