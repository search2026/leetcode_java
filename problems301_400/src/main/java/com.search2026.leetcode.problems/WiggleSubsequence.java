package com.search2026.leetcode.problems;

public class WiggleSubsequence {

    /*
        Wiggle Subsequence
        Leetcode #376
        https://leetcode.com/problems/wiggle-subsequence/
        Difficulty: Medium
     */
    public class Solution {
        public int wiggleMaxLength(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int n = nums.length;
            if (n == 1) return 1;
            int maxCount = 1, flag = 0; //flag 1 (up), 0 (flat), -1 (down)

            for (int i = 1; i < n; i++) {
                if (nums[i] > nums[i-1] && (flag == -1 || flag == 0)) {
                    maxCount++;
                    flag = 1;
                } else if (nums[i] < nums[i-1] && (flag == 1 || flag == 0)) {
                    maxCount++;
                    flag = -1;
                }
            }

            return maxCount;
        }
    }

}
