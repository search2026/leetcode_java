package number_of_digit_one;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberofDigitOne {
    /*
        Number of Digital One
        Leetcode #233
        https://leetcode.com/problems/number-of-digit-one/
        Difficulty: Medium
     */
    public class Solution {
        public int countDigitOne(int n) {
            int ones = 0;
            for (long m = 1; m <= n; m *= 10) {
                long a = n / m, b = n % m;
                ones += (a + 8) / 10 * m;
                if (a % 10 == 1) ones += b + 1;
            }
            return ones;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new NumberofDigitOne().new Solution();
            assertEquals(3, 3);
        }
    }
}
