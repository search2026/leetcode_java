package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectangleAreaTests {

    @Test
    public void testSolution() {
        RectangleArea.Solution sol = new RectangleArea().new Solution();
        assertEquals(45, sol.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }

}
