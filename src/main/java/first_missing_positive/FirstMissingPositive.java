package first_missing_positive;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class FirstMissingPositive {
    /*
        First Missing Positive
        Leetcode #41
        https://leetcode.com/problems/first-missing-positive/
        Difficulty: Hard
     */
    public class Solution {
        private void swap(int[] nums, int i, int j) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
        }

        public int firstMissingPositive(int[] nums) {
            if (nums == null || nums.length == 0) return 1;
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1])
                    swap(nums, i, nums[i] - 1);
            }
            for (int i = 0; i < n; i++)
                if (nums[i] != i + 1)
                    return i + 1;
            return n + 1;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new FirstMissingPositive().new Solution();
            assertEquals(1, sol.firstMissingPositive(new int[]{}));
            assertEquals(3, sol.firstMissingPositive(new int[]{1, 2, 0}));
            assertEquals(2, sol.firstMissingPositive(new int[]{3, 4, -1, 1}));
        }
    }
}
