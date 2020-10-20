package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NthDigitTests {

    @Test
    public void testSolution() {
        NthDigit.Solution sol = new NthDigit().new Solution();
        assertEquals(3, sol.findNthDigit(3));
        assertEquals(0, sol.findNthDigit(11));
    }

    @Test
    public void testSolution2() {
        NthDigit.Solution_2 sol = new NthDigit().new Solution_2();
        assertEquals(3, sol.findNthDigit(3));
        assertEquals(0, sol.findNthDigit(11));
    }

}
