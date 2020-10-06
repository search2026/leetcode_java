package com.search2026.leetcode.problems;

public class AddDigits {

    /*
        Add Digits
        Leetcode #258
        https://leetcode.com/problems/add-digits/
        Difficulty: Easy
     */
    public class Solution {
        public int addDigits(int num) {
            if (num < 10) {
                return num;
            }

            int res = num;

            while (res >= 10) {
                // Get each digit of the number
                int digit = 0;
                while (res > 0) {
                    digit += res % 10;
                    res /= 10;
                }

                res = digit;
            }

            return res;
        }
    }

}
