package com.search2026.leetcode.problems;

public class IncreasingTripletSubsequence {

    /*
        Increasing Triplet Subsequence - O(N) Space
        Leetcode #334
        https://leetcode.com/problems/increasing-triplet-subsequence/
        Difficulty: Medium
     */
    public class Solution {
        public boolean increasingTriplet(int[] nums) {
            if (nums == null || nums.length <= 0) return false;
            int n = nums.length;
            if (n < 3) return false;

            int[] rmax = new int[n];
            int max = nums[0];
            for (int i = n - 1; i >= 0; i--) {
                if (nums[i] > max)
                    max = nums[i];
                rmax[i] = max;
            }

            int lmin = nums[0];
            for (int i = 1; i < n - 1; i++) {
                if (nums[i] > lmin && nums[i] < rmax[i])
                    return true;
                if (nums[i] < lmin)
                    lmin = nums[i];
            }
            return false;
        }
    }

    /*
        Increasing Triplet Subsequence - O(1) Space
        https://leetcode.com/problems/increasing-triplet-subsequence/
        Difficulty: Medium
     */
    public class Solution_2 {
        public boolean increasingTriplet(int[] nums) {
            if (nums == null || nums.length <= 0) return false;
            int n = nums.length;
            if (n < 3) return false;

            int n1 = Integer.MAX_VALUE;
            int n2 = Integer.MAX_VALUE;
            for (int num : nums) {
                if (num <= n1) {
                    n1 = num;
                } else if (num <= n2) {
                    n2 = num;
                } else {
                    return true;
                }
            }

            return false;
        }
    }

}
