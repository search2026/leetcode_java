package remove_duplicates_from_sorted_array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoveDuplicatesfromSortedArray {
    /*
        Remove Duplicates from Sorted Array
        https://leetcode.com/problems/remove-duplicates-from-sorted-array/
        leetcode 26
        Difficulty: Easy
     */
    public class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int len = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[len - 1] != nums[i]) {
                    nums[len++] = nums[i];
                }
            }
            return len;
        }
    }

    /*
        Remove Duplicates from Sorted Array
        hhttps://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
        leetcode 80
        Difficulty: Medium
     */
    public class Solution_2 {
        public int removeDuplicatesII(int[] nums) {
            int len = 0;
            boolean twice = false;
            for (int i = 0; i < nums.length; i++) {
                if (i == 0 || nums[i] != nums[i - 1]) {
                    twice = false;
                    nums[len++] = nums[i];
                } else if (!twice) {
                    nums[len++] = nums[i];
                    twice = true;
                }
            }
            return len;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new RemoveDuplicatesfromSortedArray().new Solution();
            assertEquals(7, 7);
        }
    }
}
