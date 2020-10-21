package com.search2026.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

    /*
        Missing Ranges
        Leetcode #163
        https://github.com/search2026/leetcode_java/blob/master/problems101_200/resources/MissingRanges.md
        Difficulty: Medium
     */
    public class Solution {
        private String getRange(int from, int to) {
            return (from == to) ? String.valueOf(from) : from + "->" + to;
        }

        public List<String> findMissingRanges(int[] vals, int start, int end) {
            List<String> ranges = new ArrayList<>();
            if (vals == null || vals.length == 0 || start > end) return ranges;
            int prev = start - 1;
            for (int i = 0; i <= vals.length; i++) {
                int curr = (i == vals.length) ? end + 1 : vals[i];
                if (curr - prev >= 2) {
                    ranges.add(getRange(prev + 1, curr - 1));
                }
                prev = curr;
            }
            return ranges;
        }
    }

}
