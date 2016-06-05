package maximum_size_subarray_sum_equals_k;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class MaximumSizeSubarraySumEqualsk {
    /*
        Maximum Size Subarray Sum Equals k
        Leetcode #325
        https://leetcode.com/discuss/oj/maximum-size-subarray-sum-equals-k
        http://www.cnblogs.com/EdwardLiu/p/5104280.html
        Difficulty: Medium
     */
    public class Solution {
        public int maxSubArrayLen(int[] nums, int k) {
            if (nums == null || nums.length == 0) return 0;
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            map.put(0, -1);
            int sum = 0;
            int maxLen = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (!map.containsKey(sum)) {
                    map.put(sum, i);
                }
                if (map.containsKey(sum - k)) {
                    int index = map.get(sum - k);
                    maxLen = Math.max(maxLen, i - index);
                }
            }
            return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new MaximumSizeSubarraySumEqualsk().new Solution();
            assertEquals(4, sol.maxSubArrayLen(new int[]{100, 1, -1, 5, -2}, 3));
            assertEquals(2, sol.maxSubArrayLen(new int[]{-99, -2, -1, 2, 1}, 1));
        }
    }
}

