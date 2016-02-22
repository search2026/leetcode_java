package pow_x_n;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Powxn {
    /*
        Pow(x, n)
        https://leetcode.com/problems/powx-n/
        leetcode 50
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
            double re = 1;
            double times = x;
            while (n != 0) {
                if ((n & 1) == 1) {
                    re *= times;
                }
                times *= times;
                n >>= 1;
            }
            if (negative) {
                return overflow ? 1 / (re * x) : 1 / re;
            }
            return re;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new Powxn().new Solution();
            assertEquals(7, 7);
        }
    }
}
