package com.search2026.leetcode.problems;

public class ValidPalindrome {

    /*
        Valid Palindrome
        Leetcode #125
        https://leetcode.com/problems/valid-palindrome/
        Difficulty: Easy
     */
    public class Solution {
        public boolean isPalindrome(String s) {
            if (s == null || s.length() == 0) return true;
            int p1 = 0, p2 = s.length() - 1;

            while (p1 < p2) {
                while (p1 < p2 && !Character.isLetterOrDigit(s.charAt(p1))) p1++;
                while (p1 < p2 && !Character.isLetterOrDigit(s.charAt(p2))) p2--;
                if (Character.toLowerCase(s.charAt(p1)) != Character.toLowerCase(s.charAt(p2))) {
                    return false;
                }
                p1++;
                p2--;
            }

            return true;
        }
    }

}
