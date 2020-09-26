package com.search2026.leetcode.problems;

public class FactorialTrailingZeroes {

    /*
        Factorial Trailing Zeros
        leetcode #172
        https://leetcode.com/problems/factorial-trailing-zeroes/
        Difficulty: Easy
     */
    public class Solution {
        public int trailingZeroes(int n) {
            if (n < 0) return -1;
            int count = 0;
            for (long i = 5; n / i >= 1; i *= 5) {
                count += n / i;
            }
            return count;
        }
    }

}
