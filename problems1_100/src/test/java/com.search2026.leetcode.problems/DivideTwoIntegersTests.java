package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DivideTwoIntegersTests {

    @Test
    public void testSolution() {
        DivideTwoIntegers.Solution s = new DivideTwoIntegers().new Solution();
        assertEquals(Integer.MIN_VALUE, s.divide(Integer.MIN_VALUE, 1));
        assertEquals(3, s.divide(10, 3));
        assertEquals(-2, s.divide(7, -3));
    }

}
