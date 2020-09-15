package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContainerWithMostWaterTests {

    @Test
    public void testSolution() {
        ContainerWithMostWater.Solution sol = new ContainerWithMostWater().new Solution();
        int[] heights = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        assertEquals(49, sol.maxArea(heights));
    }

}
