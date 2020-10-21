package com.search2026.leetcode.problems;

import java.util.HashMap;

public class MaximumSizeSubarraySumEqualsK {

    /*
        Maximum Size Subarray Sum Equals k
        Leetcode #325
        https://github.com/search2026/leetcode_java/blob/master/problems301_400/resources/MaximumSizeSubarraySumEqualsK.md
        Difficulty: Medium
     */
    public class Solution {
        public int maxSubArrayLen(int[] nums, int k) {
            if (nums == null || nums.length == 0) return 0;
            HashMap<Integer, Integer> map = new HashMap<>();
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

}
