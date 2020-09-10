package com.search2026.leetcode.problems;

public class LengthOfLastWord {

    /*
        Length of Last Word
        https://leetcode.com/problems/length-of-last-word/
        leetcode 58
        Difficulty: Easy
     */
    public class Solution {
        public int lengthOfLastWord(String s) {
            int i = s.length() - 1;
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            if (i < 0) {
                return 0;
            }
            int len = 0;
            while (i >= 0 && s.charAt(i) != ' ') {
                len++;
                i--;
            }
            return len;
        }
    }

}
