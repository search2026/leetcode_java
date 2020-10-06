package com.search2026.leetcode.problems;

import java.util.Arrays;

public class ThreeSumSmaller {

    /*
        3 Sum Smaller
        Leetcode #259
        http://buttercola.blogspot.com/2015/08/leetcode.html
        https://leetcode.com/discuss/questions/oj/3sum-smaller?sort=votes
        Difficulty: Medium
     */
    public class Solution {
        public int threeSumSmaller(int[] nums, int target) {
            if (nums == null || nums.length < 3) {
                return 0;
            }

            int result = 0;
            Arrays.sort(nums);

            for (int i = 0; i < nums.length - 2; i++) {
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    if (nums[i] + nums[j] + nums[k] < target) {
                        result += (k - j);
                        j++;
                    } else {
                        k--;
                    }
                }
            }

            return result;
        }
    }

}
