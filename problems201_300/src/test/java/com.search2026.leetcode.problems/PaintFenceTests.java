package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PaintFenceTests {

    @Test
    public void testSolution() {
        PaintFence.Solution sol = new PaintFence().new Solution();
        assertEquals(6, sol.numWays(3, 2));
    }

    @Test
    public void testSolution2() {
        PaintFence.Solution_2 sol = new PaintFence().new Solution_2();
        assertEquals(6, sol.numWays(3, 2));
    }

}
