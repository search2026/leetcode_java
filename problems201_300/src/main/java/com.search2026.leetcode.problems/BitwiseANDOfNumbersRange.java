package com.search2026.leetcode.problems;

public class BitwiseANDOfNumbersRange {

    /*
        Bitwise AND of Numbers Range
        Leetcode #201
        https://leetcode.com/problems/bitwise-and-of-numbers-range/
        Difficulty: Medium
     */
    public class Solution {
        public int rangeBitwiseAnd(int m, int n) {
            int r = 0;
            for (int i = 0; i < 32 && n != 0; i++) {
                if ((m & 1) != 0 && n == m) {
                    r |= (1 << i);
                }
                n >>>= 1;
                m >>>= 1;
            }
            return r;
        }
    }

}
