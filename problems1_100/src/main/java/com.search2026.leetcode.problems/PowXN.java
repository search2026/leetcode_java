package com.search2026.leetcode.problems;

public class PowXN {

    /*
        Pow(x, n) - Iterative
        Leetcode #50
        https://leetcode.com/problems/powx-n/
        Difficulty: Medium
     */
    public class Solution {
        public double pow(double x, int n) {
            boolean overflow = false;
            if (n == Integer.MIN_VALUE) {
                overflow = true;
                n++;
            }
            boolean negative = n < 0;
            n = Math.abs(n);
            double res = 1;
            double times = x;
            while (n != 0) {
                if ((n & 1) == 1) {
                    res *= times;
                }
                times *= times;
                n >>= 1;
            }
            if (negative) {
                return overflow ? 1 / (res * x) : 1 / res;
            }
            return res;
        }
    }

    /*
        Pow(x, n) - Recursion
        Leetcode #50
        https://leetcode.com/problems/powx-n/
        Difficulty: Medium
     */
    public class Solution_2 {
        public double pow(double x, int n) {
            if (n == 0)
                return 1;
            if (n < 0) {
                n = -n;
                x = 1 / x;
            }
            return (n % 2 == 0) ? pow(x * x, n / 2) : x * pow(x * x, n / 2);
        }
    }

}
