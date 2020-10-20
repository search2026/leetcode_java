package com.search2026.leetcode.problems;

public class FindTheDifference {

    /*
        Find the Difference - Bit Manipulation
        Leetcode #389
        https://leetcode.com/problems/find-the-difference/
        Difficulty: Easy
     */
    public class Solution {
        public char findTheDifference_B(String s, String t) {
            char c = 0;
            for (int i = 0; i < s.length(); ++i) {
                c ^= s.charAt(i);
            }
            for (int i = 0; i < t.length(); ++i) {
                c ^= t.charAt(i);
            }
            return c;
        }
    }


    /*
        Find the Difference - Using Array
        Leetcode #389
        https://leetcode.com/problems/find-the-difference/
        Difficulty: Easy
     */
    public class Solution_2 {
        public char findTheDifference_B(String s, String t) {
            int[] alpha = new int[26];
            for (int i = 0; i < 26; i++) alpha[i] = 0;
            for (char c : s.toCharArray())
                alpha[ c - 'a' ]++;

            for (char c : t.toCharArray()) {
                //could do decrement first, then check but yeah
                if (--alpha[c - 'a'] < 0)
                    return c;
            }

            return 0;
        }
    }

}
