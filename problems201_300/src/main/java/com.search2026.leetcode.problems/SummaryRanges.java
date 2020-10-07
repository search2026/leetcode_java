package com.search2026.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    /*
        Summary Ranges
        Leetcode #228
        https://leetcode.com/problems/summary-ranges/
        Difficulty: Easy
     */
    public class Solution {
        public List<String> summaryRanges(int[] nums) {
            List<String> res = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return res;
            }

            if (nums.length == 1) {
                String temp = Integer.toString(nums[0]);
                res.add(temp);
                return res;
            }

            int lo = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] - nums[i - 1] == 1) {
                    continue;
                } else {
                    StringBuffer sb = new StringBuffer();
                    sb.append(Integer.toString(nums[lo]));
                    if (i - lo > 1) {
                        sb.append("->");
                        sb.append(Integer.toString(nums[i - 1]));
                    }
                    res.add(sb.toString());
                    lo = i;
                }
            }

            // Handle the trailing numbers
            if (lo < nums.length) {
                StringBuffer sb = new StringBuffer();
                sb.append(nums[lo]);
                if (nums.length - lo > 1) {
                    sb.append("->");
                    sb.append(Integer.toString(nums[nums.length - 1]));
                }
                res.add(sb.toString());
            }

            return res;
        }
    }

}
