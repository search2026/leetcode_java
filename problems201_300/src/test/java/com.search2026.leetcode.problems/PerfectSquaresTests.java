package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PerfectSquaresTests {

    @Test
    public void test1() {
        PerfectSquares.Solution sol = new PerfectSquares().new Solution();
        assertEquals(3, sol.numSquares(12));
        assertEquals(2, sol.numSquares(13));
        assertEquals(3, sol.numSquares(3));
    }

}
