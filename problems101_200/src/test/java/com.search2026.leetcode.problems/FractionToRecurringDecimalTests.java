package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FractionToRecurringDecimalTests {

    @Test
    public void testSolution() {
        FractionToRecurringDecimal.Solution s = new FractionToRecurringDecimal().new Solution();
        assertEquals("3.(3)", s.fractionToDecimal(10, 3));
        assertEquals("0.75", s.fractionToDecimal(3, 4));
        assertEquals("0.(09)", s.fractionToDecimal(1, 11));
        assertEquals("0.0000000004656612873077392578125", s.fractionToDecimal(-1, -2147483648));
    }

}
