package com.search2026.leetcode.problems;

public class PowerOfTwo {

    /*
        Power of Two
        leetcode #231
        https://leetcode.com/problems/power-of-two/
        Difficulty: Easy
     */
    public class Solution {
        public boolean isPowerOfTwo(int num) {
            return num > 0 && (num & (num - 1)) == 0;
        }
    }

}
