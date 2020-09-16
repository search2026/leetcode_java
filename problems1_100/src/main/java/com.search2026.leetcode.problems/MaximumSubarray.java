package com.search2026.leetcode.problems;

import java.util.Arrays;

public class MaximumSubarray {

    /*
        Maximum Subarray - Dynamic Programming
        Leetcode #53
        https://leetcode.com/problems/maximum-subarray/
        Difficulty: Medium
     */
    public class Solution {
        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length == 0)
                throw new IllegalArgumentException("null or empty input array");

            int localMax = nums[0], globalMax = nums[0];
            for (int i = 1; i < nums.length; i++) {
                localMax = Math.max(localMax + nums[i], nums[i]);
                globalMax = Math.max(globalMax, localMax);
            }
            return globalMax;
        }
    }

    /*
        Maximum Subarray - Dynamic Programming
        Leetcode #53
        https://leetcode.com/problems/maximum-subarray/
        Difficulty: Medium
      */
    public class Solution_2 {
        private void search(int[] nums, int[] res, int left, int right) {
            if (left == right) {
                Arrays.fill(res, nums[left]);
                return;
            }

            int mid = left + (right - left) / 2;
            int[] leftRes = new int[4];
            search(nums, leftRes, left, mid);
            int[] rightRes = new int[4];
            search(nums, rightRes, mid + 1, right);

            res[0] = Math.max(Math.max(leftRes[0], rightRes[0]), leftRes[2] + rightRes[1]);
            res[1] = Math.max(leftRes[1], leftRes[3] + +rightRes[1]);
            res[2] = Math.max(rightRes[2], rightRes[3] + +leftRes[2]);
            res[3] = leftRes[3] + rightRes[3];
        }

        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length == 0)
                throw new IllegalArgumentException("null or empty input array");

            int[] res = new int[4]; //maxSoFar, leftMax, rightMax, currSum
            search(nums, res, 0, nums.length - 1);
            return res[0];
        }
    }

}
