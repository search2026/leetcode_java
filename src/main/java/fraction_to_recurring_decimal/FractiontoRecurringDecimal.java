package fraction_to_recurring_decimal;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class FractiontoRecurringDecimal {
    /*
        Fraction to Recurring Decimal
        Leetcode #166
        https://leetcode.com/problems/fraction-to-recurring-decimal/
        Difficulty: Medium
     */
    public class Solution {
        public String fractionToDecimal(int numerator, int denominator) {
            if (numerator == 0)
                return "0";
            if (denominator == 0)
                return "";

            String result = "";

            // is result is negative
            if ((numerator < 0) ^ (denominator < 0)) {
                result += "-";
            }

            // convert int to long
            long num = numerator, den = denominator;
            num = Math.abs(num);
            den = Math.abs(den);

            // quotient
            long res = num / den;
            result += String.valueOf(res);

            // if remainder is 0, return result
            long remainder = (num % den) * 10;
            if (remainder == 0)
                return result;

            // right-hand side of decimal point
            HashMap<Long, Integer> map = new HashMap<Long, Integer>();
            result += ".";
            while (remainder != 0) {
                // if digits repeat
                if (map.containsKey(remainder)) {
                    int beg = map.get(remainder);
                    String part1 = result.substring(0, beg);
                    String part2 = result.substring(beg, result.length());
                    result = part1 + "(" + part2 + ")";
                    return result;
                }

                // continue
                map.put(remainder, result.length());
                res = remainder / den;
                result += String.valueOf(res);
                remainder = (remainder % den) * 10;
            }

            return result;
        }
    }

    public static class UnitTest {
        @Test
        public void testFractionToDecimal() {
            Solution s = new FractiontoRecurringDecimal().new Solution();
            assertEquals("3.(3)", s.fractionToDecimal(10, 3));
            assertEquals("0.75", s.fractionToDecimal(3, 4));
            assertEquals("0.(09)", s.fractionToDecimal(1, 11));
            assertEquals("0.0000000004656612873077392578125", s.fractionToDecimal(-1, -2147483648));
        }
    }
}

