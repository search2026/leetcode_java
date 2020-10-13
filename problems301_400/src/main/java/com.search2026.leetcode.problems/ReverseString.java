package com.search2026.leetcode.problems;

public class ReverseString {

    /*
        Reverse String
        Leetcode #344
        https://leetcode.com/problems/reverse-string/
        Difficulty: Easy
     */
    public class Solution {
        public String reverseString(String s) {
            if (s == null || s.length() == 0) return "";
            int n = s.length();
            if (n == 1) return s;
            char[] sChars = s.toCharArray();
            for (int i = 0; i < n / 2; i++) {
                char t = sChars[i];
                sChars[i] = sChars[n - i - 1];
                sChars[n - i - 1] = t;
            }
            return new String(sChars);
        }
    }

    /*
        Reverse String
        Leetcode #344
        https://leetcode.com/problems/reverse-string/
        Difficulty: Easy
     */
    public class Solution_2 {
        public String reverseString(String s) {
            if (s == null || s.length() == 0) return "";
            return new StringBuilder(s).reverse().toString();
        }
    }

}
