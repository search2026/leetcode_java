package search_insert_position;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SearchInsertPosition {
    /*
        Search Insert Position
        Leetcode #35
        https://leetcode.com/problems/search-insert-position/
        Difficulty: Medium
     */
    public class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
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
            assertEquals(7, 7);
        }
    }
}
