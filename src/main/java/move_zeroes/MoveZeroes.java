package move_zeroes;

import org.junit.Test;

import static org.junit.Assert.*;

public class MoveZeroes {
    /*
        Move Zeroes
        https://leetcode.com/problems/move-zeroes/
        Difficulty: Easy
     */
    public class Solution {
        public void moveZeroes(int[] nums) {
            if (nums == null || nums.length == 0) {
                return;
            }

            int i = 0;
            int j = 0;

            // Step 2: compress the nums array by filling out the 0s
            while (i < nums.length) {
                if (nums[i] != 0) {
                    nums[j] = nums[i];
                    j++;
                    i++;
                } else {
                    i++;
                }
            }

            // Step 1: append 0s to the end
            while (j < nums.length) {
                nums[j] = 0;
                j++;
            }
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new MoveZeroes().new Solution();
            assertEquals(3, 3);
        }
    }
}
