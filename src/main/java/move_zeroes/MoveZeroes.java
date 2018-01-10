package move_zeroes;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class MoveZeroes {
    /*
        Move Zeroes - Two Pointers
        Leetcode #283
        https://leetcode.com/problems/move-zeroes/
        Difficulty: Easy
     */
    public class Solution {
        public void moveZeroes(int[] nums) {
            if (nums == null || nums.length < 2) return;
            int p1 = 0, p2 = 0;
            while (p1 < nums.length) {
                if (nums[p1] != 0) {
                    nums[p2] = nums[p1];
                    p2++;
                }
                p1++;
            }
            while (p2 < nums.length) {
                nums[p2] = 0;
                p2++;
            }
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new MoveZeroes().new Solution();
            int[] nums = {0, 1, 0, 3, 12};
            sol.moveZeroes(nums);
            int[] res = {1, 3, 12, 0, 0};
            Assert.assertArrayEquals(res, nums);
        }
    }
}
