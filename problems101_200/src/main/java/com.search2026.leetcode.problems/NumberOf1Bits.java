package com.search2026.leetcode.problems;

public class NumberOf1Bits {

    /*
        Number of 1 Bits
        Leetcode #191
        https://leetcode.com/problems/number-of-1-bits/
        Difficulty: Easy
     */
    public class Solution {
        public int hammingWeight(int n) {
            int count = 0;
            while (n != 0) {
                count++;
                n &= (n - 1);
            }
            return count;
        }
    }

}
