package rotate_array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RotateArray {
    /*
        Rotate Array
        https://leetcode.com/problems/rotate-array/
        leetcode 189
        Difficulty: Easy
     */
    public class Solution {
        private void reverse(int[] nums, int begin, int end) {
            while (begin < end) {
                int temp = nums[begin];
                nums[begin] = nums[end];
                nums[end] = temp;
                begin++;
                end--;
            }
        }

        public void rotate(int[] nums, int k) {
            k = k % nums.length;
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new RotateArray().new Solution();
            assertEquals(7, 7);
        }
    }
}

