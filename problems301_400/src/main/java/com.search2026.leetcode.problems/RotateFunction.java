package com.search2026.leetcode.problems;

public class RotateFunction {

    /*
        Rotate Function
        Leetcode #396
        https://leetcode.com/problems/rotate-function/
        Difficulty: Medium
     */
    public class Solution {
        public int maxRotateFunction(int[] nums) {
            int n = nums.length;
            int sum = 0;
            int cand = 0;

            for (int i = 0; i < n; i++) {
                sum += nums[i];
                cand += nums[i] * i;
            }
            int res = cand;

            for (int i = n - 1; i > 0; i--) {
                cand = cand + sum - nums[i] * n;
                res = Math.max(res, cand);
            }
            return res;
        }
    }

}
