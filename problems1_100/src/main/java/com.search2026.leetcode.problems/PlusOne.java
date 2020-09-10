package com.search2026.leetcode.problems;

public class PlusOne {

    /*
        Plus One
        Leetcode #66
        https://leetcode.com/problems/plus-one/
        Difficulty: Easy
     */
    public class Solution {
        public int[] plusOne(int[] digits) {
            if (digits == null || digits.length == 0) return new int[]{};

            for (int i = digits.length - 1; i >= 0; i--) {
                if (digits[i] < 9) {
                    digits[i]++;
                    return digits;
                } else {
                    digits[i] = 0;
                }
            }

            int[] newArray = new int[digits.length + 1];
            System.arraycopy(digits, 0, newArray, 1, digits.length);
            newArray[0] = 1;
            return newArray;
        }
    }

}
