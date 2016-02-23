package sort_colors;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SortColors {
    /*
        Sort Colors
        https://leetcode.com/problems/sort-colors/
        leetcode 75
        Difficulty: Medium
     */
    public class Solution {
        public void sortColors(int[] nums) {
            int zero = -1;
            int one = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    nums[i] = nums[++zero];
                    nums[zero] = 0;
                    one = Math.max(zero, one);
                }
                if (nums[i] == 1) {
                    nums[i] = nums[++one];
                    nums[one] = 1;
                }
            }
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new SortColors().new Solution();
            assertEquals(7, 7);
        }
    }
}
