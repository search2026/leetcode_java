package com.search2026.leetcode.problems;

public class IsSubsequence {

    /*
        Is Subsequence
        Leetcode #392
        https://leetcode.com/problems/is-subsequence/
        Difficulty: Easy
     */
    public class Solution {
        public boolean isSubsequence(String s, String t) {
            int fromIndex = 0;
            for (char c : s.toCharArray()) {
                fromIndex = t.indexOf(c, fromIndex);
                if (fromIndex++ < 0) {
                    return false;
                }
            }
            return true;
        }
    }

}
