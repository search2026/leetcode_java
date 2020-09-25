package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OneEditDistanceTests {

    @Test
    public void testSolution() {
        OneEditDistance.Solution sol = new OneEditDistance().new Solution();
        assertFalse(sol.isOneEditDistance("acdbegh", "acdbegh"));
        assertTrue(sol.isOneEditDistance("acdbegh", "cdbegh"));
        assertTrue(sol.isOneEditDistance("acdbegh", "acdegh"));
        assertTrue(sol.isOneEditDistance("acdbegh", "acdbeg"));
        assertTrue(sol.isOneEditDistance("acdbegh", "#acdbegh"));
        assertTrue(sol.isOneEditDistance("acdbegh", "acdbiegh"));
        assertTrue(sol.isOneEditDistance("acdbegh", "acdbeghi"));
        assertTrue(sol.isOneEditDistance("acdbegh", "hcdbegh"));
        assertTrue(sol.isOneEditDistance("acdbegh", "addbegh"));
        assertTrue(sol.isOneEditDistance("acdbegh", "acdbegc"));
        assertFalse(sol.isOneEditDistance("acdbegh", "cdbqgh"));
    }

}
