package com.search2026.leetcode.problems;

public class SumOfTwoIntegers {

    /*
        Sum of Two Integers
        Leetcode #371
        https://leetcode.com/problems/sum-of-two-integers/
        Difficulty: Easy
     */
    public class Solution {
        public int getSum(int a, int b) {
            while (b != 0) {
                int carry = a & b;
                a = a ^ b;
                b = carry << 1;
            }
            return a;
        }
    }

    /*
        Sum of Two Integers - One Line
        Leetcode #371
        https://leetcode.com/problems/sum-of-two-integers/
        Difficulty: Easy
     */
    public class Solution_2 {
        public int getSum(int a, int b) {
            return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
        }
    }

    /*
        Sum of Two Integers - One Line
        Leetcode #371
        https://leetcode.com/problems/sum-of-two-integers/
        Difficulty: Easy
     */
    public class Solution_3 {
        public int getSum(int a, int b) {
            if (b == 0) return a;
            int sum = a ^ b;
            int carry = (a & b) << 1;
            return getSum(sum, carry);
        }
    }

}
