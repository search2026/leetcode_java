package com.search2026.leetcode.problems;

public class CountingBits {

    /*
        Counting Bits
        Leetcode #338
        https://leetcode.com/problems/counting-bits/
        Difficulty: Medium
     */
    public class Solution {
        public int[] countBits(int num) {
            int[] f = new int[num + 1];
            for (int i = 1; i <= num; i++) f[i] = f[i >> 1] + (i & 1);
            return f;
        }
    }

}
