package divide_two_integers;

import static java.lang.Integer.MAX_VALUE;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DivideTwoIntegers {

    public class Solution {
        // Try to implement without long
        public int divide(int dividend, int divisor) {
            boolean flag = dividend < 0 ^ divisor < 0;
            long Dividend = Math.abs((long)dividend);
            long Divisor = Math.abs((long)divisor);
            long res = 0;
            while (Dividend >= Divisor) {
                long c = Divisor;
                for (int i = 0; (c << i) <= Dividend; ++i) {
                    Dividend -= (c << i);
                    res += (1 << i);
                }
            }
            if (flag == true) res = -res;
            if (res > MAX_VALUE) return MAX_VALUE;
            return (int)res;
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
