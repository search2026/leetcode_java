package first_missing_positive;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FirstMissingPositive {
    /*
        First Missing Positive
        https://leetcode.com/problems/first-missing-positive/
        Difficulty: Hard
     */
    public class Solution {
        public int firstMissingPositive(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                if (nums[i] <= 0) {
                    nums[i] = n + 1;
                }
            }
            for (int i = 0; i < n; i++) {
                int temp = Math.abs(nums[i]);
                if (temp <= n && nums[temp - 1] > 0) {
                    nums[temp - 1] = -nums[temp - 1];
                }
            }
            for (int i = 0; i < n; i++) {
                if (nums[i] > 0) {
                    return i + 1;
                }
            }
            return n + 1;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new FirstMissingPositive().new Solution();
            assertTrue(true);
        }
    }
}
