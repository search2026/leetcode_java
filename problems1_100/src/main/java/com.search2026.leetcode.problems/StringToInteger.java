package com.search2026.leetcode.problems;

public class StringToInteger {

    /*
        String to Integer (atoi)
        Leetcode #8
        https://leetcode.com/problems/string-to-integer-atoi/
        Difficulty: Easy
     */
    public class Solution {
        private final int maxDiv10 = Integer.MAX_VALUE / 10;

        public int myAtoi(String str) {
            if (str.length() == 0) return 0;
            int idx = 0, sign = 1;

            while (str.charAt(idx) == ' ' && idx < str.length()) idx++;

            if (str.charAt(idx) == '+' || str.charAt(idx) == '-') {
                sign = str.charAt(idx) == '+' ? 1 : -1;
                idx++;
            }

            int num = 0;
            while (idx < str.length()) {
                int digit = str.charAt(idx) - '0';
                if (digit < 0 || digit > 9) break;

                //check if num will be overflow after 10 times and add digit
                if (num > maxDiv10 || num == maxDiv10 && digit >= 8) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }

                num = num * 10 + digit;
                idx++;
            }

            return num * sign;
        }
    }

}
