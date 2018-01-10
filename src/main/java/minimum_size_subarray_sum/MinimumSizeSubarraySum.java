package minimum_size_subarray_sum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumSizeSubarraySum {
    /*
        Minimum Size Subarray Sum
        Leetcode #209
        https://leetcode.com/problems/minimum-size-subarray-sum/
        Difficulty: Medium
     */
    public class Solution {
        public int minSubArrayLen(int s, int[] nums) {
            int left = 0, right = 0;
            int sum = 0;
            int re = nums.length + 1;
            while (right < nums.length) {
                sum += nums[right];
                while (sum >= s) {
                    if (right - left + 1 == 1)
                        return 1;
                    re = Math.min(re, right - left + 1);
                    sum -= nums[left++];
                }
                right++;
            }
            return re == nums.length + 1 ? 0 : re;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new MinimumSizeSubarraySum().new Solution();
            assertEquals(3, 3);
        }
    }
}
