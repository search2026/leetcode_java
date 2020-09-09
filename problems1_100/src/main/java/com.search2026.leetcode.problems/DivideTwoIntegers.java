package com.search2026.leetcode.problems;

import static java.lang.Integer.MAX_VALUE;

public class DivideTwoIntegers {

    /*
        Divide Two Integers
        Leetcode #29
        https://leetcode.com/problems/divide-two-integers/
        Difficulty: Medium
     */
    public class Solution {
        public int divide(int dividend, int divisor) {
            boolean flag = dividend < 0 ^ divisor < 0;
            long Dividend = Math.abs((long) dividend);
            long Divisor = Math.abs((long) divisor);
            long res = 0;
            while (Dividend >= Divisor) {
                long c = Divisor;
                for (int i = 0; (c << i) <= Dividend; ++i) {
                    Dividend -= (c << i);
                    res += (1 << i);
                }
            }
            if (flag) res = -res;
            if (res > MAX_VALUE) return MAX_VALUE;
            return (int) res;
        }
    }

}
