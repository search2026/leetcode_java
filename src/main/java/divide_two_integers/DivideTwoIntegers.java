package divide_two_integers;

import org.junit.Test;

import static java.lang.Integer.MAX_VALUE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DivideTwoIntegers {
    /*
        Divide Two Integers
        Leetcode #29
        https://leetcode.com/problems/divide-two-integers/
        Difficulty: Medium
     */
    public class Solution {
        // Try to implement without long
        public int divide(int dividend, int divisor) {
            boolean flag = dividend < 0 ^ divisor < 0;
            long Dividend = Math.abs((long) dividend);
            long Divisor = Math.abs((long) divisor);
            long rslt = 0;
            while (Dividend >= Divisor) {
                long c = Divisor;
                for (int i = 0; (c << i) <= Dividend; ++i) {
                    Dividend -= (c << i);
                    rslt += (1 << i);
                }
            }
            if (flag) rslt = -rslt;
            if (rslt > MAX_VALUE) return MAX_VALUE;
            return (int) rslt;
        }
    }

    public static class UnitTest {
        @Test
        public void testDivideWithOverflow() {
            Solution s = new DivideTwoIntegers().new Solution();
            assertEquals(Integer.MIN_VALUE, s.divide(Integer.MIN_VALUE, 1));
        }
    }
}
