package minimum_size_subarray_sum;

public class MinimumSizeSubarraySum {

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

    }
}
