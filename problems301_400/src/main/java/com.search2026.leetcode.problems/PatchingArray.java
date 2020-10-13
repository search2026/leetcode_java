package com.search2026.leetcode.problems;

public class PatchingArray {

    /*
        Patching Array
        Leetcode #330
        https://leetcode.com/problems/patching-array/
        Difficulty: Medium
    */
    public class Solution {
        public int minPatches(int[] nums, int n) {
            long sum = 0;
            int res = 0;
            for (int cur : nums) {
                if (sum >= n) break;
                while (sum + 1 < cur && sum < n) {
                    sum += sum + 1;
                    res++;
                }
                sum += cur;
            }
            while (sum < n) {
                sum += sum + 1;
                res++;
            }
            return res;
        }
    }


    /*
        Patching Array
        Leetcode #330
        https://leetcode.com/problems/patching-array/
        Difficulty: Medium
     */
    public class Solution_2 {
        public int minPatches(int[] nums, int n) {
            long sum = 1;
            int res = 0, i = 0;
            while (sum <= n) {
                if (i < nums.length && nums[i] <= sum) {
                    sum += nums[i];
                    i++;
                } else {
                    sum += sum;
                    res++;
                }
            }
            return res;
        }
    }

}
