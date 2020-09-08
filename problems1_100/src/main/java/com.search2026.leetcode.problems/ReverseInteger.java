package com.search2026.leetcode.problems;

public class ReverseInteger {

    /*
        Reverse Integer
        Leetcode #7
        https://leetcode.com/problems/reverse-integer/
        Difficulty: Easy
     */
    public class Solution {
        public int reverse(int x) {
            int reversed = 0;
            while (x!=0) {
                // handle overflow/underflow
                if (Math.abs(reversed) > 214748364) {
                    return 0;
                }
                reversed = reversed * 10 + x % 10;
                x /= 10;
            }

            return reversed;
        }
    }

}
