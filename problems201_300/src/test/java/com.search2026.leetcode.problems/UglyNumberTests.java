package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UglyNumberTests {

    @Test
    public void testSolution() {
        UglyNumber.Solution sol = new UglyNumber().new Solution();
        assertTrue(sol.isUgly(6));
        assertTrue(sol.isUgly(8));
        assertFalse(sol.isUgly(14));
    }

    @Test
    public void testSolution2() {
        UglyNumber.Solution_2 sol = new UglyNumber().new Solution_2();
        assertEquals(12, sol.nthUglyNumber(10));
    }

}
