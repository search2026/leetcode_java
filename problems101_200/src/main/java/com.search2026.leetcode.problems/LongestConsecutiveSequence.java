package com.search2026.leetcode.problems;

import java.util.HashSet;

public class LongestConsecutiveSequence {

    /*
        Longest Consecutive Sequence
        https://leetcode.com/problems/longest-consecutive-sequence/
        leetcode 128
        Difficulty: Hard
     */
    public class Solution {
        public int longestConsecutive(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            for (int n : nums) {
                set.add(n);
            }
            int res = 0;
            for (int n : nums) {
                int i = n - 1;
                while (set.contains(i)) {
                    set.remove(i);
                    i--;
                }
                int j = n + 1;
                while (set.contains(j)) {
                    set.remove(j);
                    j++;
                }
                res = Math.max(res, j - i - 1);
            }
            return res;
        }
    }

}
