package com.search2026.leetcode.problems;

public class PowerOfFour {

    /*
        Power of Four
        leetcode #342
        https://leetcode.com/problems/power-of-four/
        Difficulty: Easy
     */
    public class Solution {
        public boolean isPowerOfFour(int num) {
            return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
        }
    }

}
