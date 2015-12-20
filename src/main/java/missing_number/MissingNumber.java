package missing_number;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MissingNumber {
    /*
        Missing Number
        https://leetcode.com/problems/missing-number/
        Difficulty: Medium
     */
    public class Solution {
        public int missingNumber(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            // Step 1: iterate the array and swap according to the buckets
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (num != i && num < nums.length && num != nums[num]) {
                    swap(nums, i, num);
                    i--;
                }
            }

            // Step 2: iterate again to find out the missing number
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i) {
                    return i;
                }
            }

            return nums.length;
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new MissingNumber().new Solution();

            int[] test1 = new int[]{3, 4, 1, 2};
            int[] test2 = new int[]{3, 4, 0, 1, 2};
            int[] test3 = new int[]{4, 0, 1, 2};

            assertEquals(sol.missingNumber(test1), 0);
            assertEquals(sol.missingNumber(test2), 5);
            assertEquals(sol.missingNumber(test3), 3);
        }
    }
}
