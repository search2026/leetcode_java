package com.search2026.leetcode.problems;

import java.util.Arrays;

public class ThreeSumSmaller {

    /*
        3 Sum Smaller
        Leetcode #259
        https://github.com/search2026/leetcode_java/blob/master/resources/ThreeSumSmaller.md
        Difficulty: Medium
     */
    public class Solution {
        public int threeSumSmaller(int[] nums, int target) {
            if (nums == null || nums.length < 3) {
                return 0;
            }

            int res = 0;
            Arrays.sort(nums);

            for (int i = 0; i < nums.length - 2; i++) {
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    if (nums[i] + nums[j] + nums[k] < target) {
                        res += (k - j);
                        j++;
                    } else {
                        k--;
                    }
                }
            }

            return res;
        }
    }

}
