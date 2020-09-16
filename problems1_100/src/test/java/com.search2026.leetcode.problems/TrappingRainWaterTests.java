package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrappingRainWaterTests {

    @Test
    public void testSolution() {
        TrappingRainWater.Solution sol = new TrappingRainWater().new Solution();
        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        assertEquals(6, sol.trap(heights));
    }

}
