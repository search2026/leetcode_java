package com.search2026.leetcode.problems;

public class IntegerReplacement {

    /*
        Integer Replacement
        Leetcode #397
        https://leetcode.com/problems/integer-replacement/
        Difficulty: Medium
     */
    public class Solution {
        public int integerReplacement(int n) {
            int c = 0;
            while (n != 1) {
                if ((n & 1) == 0) {
                    n >>>= 1;
                } else if (n == 3 || Integer.bitCount(n + 1) > Integer.bitCount(n - 1)) {
                    --n;
                } else {
                    ++n;
                }
                ++c;
            }
            return c;
        }
    }

    /*
        Integer Replacement
        Leetcode #397
        https://leetcode.com/problems/integer-replacement/
        Difficulty: Medium
     */
    public class Solution_2 {
        public int integerReplacement(int n) {
            int c = 0;
            while (n != 1) {
                if ((n & 1) == 0) {
                    n >>>= 1;
                } else if (n == 3 || ((n >>> 1) & 1) == 0) {
                    --n;
                } else {
                    ++n;
                }
                ++c;
            }
            return c;
        }
    }

}
