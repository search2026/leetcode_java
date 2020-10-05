package com.search2026.leetcode.problems;

import java.util.Arrays;

public class ValidAnagram {

    /*
        Valid Anagram
        Leetcode #242
        https://leetcode.com/problems/valid-anagram/
        Difficulty: Easy
     */
    public class Solution {
        public boolean isAnagram(String s, String t) {
            if (s == null || s.length() == 0) {
                return t == null || t.length() == 0;
            }

            if (t == null || t.length() == 0) {
                return s == null || s.length() == 0;
            }

            if (s.length() != t.length()) {
                return false;
            }

            char[] sArr = s.toCharArray();
            char[] tArr = t.toCharArray();

            Arrays.sort(sArr);
            Arrays.sort(tArr);

            for (int i = 0; i < sArr.length; i++) {
                if (sArr[i] != tArr[i]) {
                    return false;
                }
            }

            return true;
        }
    }

}
