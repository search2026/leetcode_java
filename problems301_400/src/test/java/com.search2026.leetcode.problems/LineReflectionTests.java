package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LineReflectionTests {

    @Test
    public void testSolution() {
        LineReflection.Solution sol = new LineReflection().new Solution();
        int[][] test1 = {
                {1, 1},
                {-1, 1}
        };
        assertTrue(sol.isReflected(test1));
        int[][] test2 = {
                {1, 1},
                {-1, -1}
        };
        assertFalse(sol.isReflected(test2));
        int[][] test3 = {
                {1, 1},
                {9, 1},
                {8, 2}
        };
        assertFalse(sol.isReflected(test3));
    }

}
