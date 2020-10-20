package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PerfectRectangleTests {

    @Test
    public void testSolution() {
        PerfectRectangle.Solution sol = new PerfectRectangle().new Solution();
        int[][] rectangles = {
                {1, 1, 3, 3},
                {3, 1, 4, 2},
                {3, 2, 4, 4},
                {1, 3, 2, 4},
                {2, 3, 3, 4}
        };
        assertTrue(sol.isRectangleCover(rectangles));

        rectangles = new int[][]{
                {1, 1, 2, 3},
                {1, 3, 2, 4},
                {3, 1, 4, 2},
                {3, 2, 4, 4}
        };
        assertFalse(sol.isRectangleCover(rectangles));

        rectangles = new int[][]{
                {1, 1, 3, 3},
                {3, 1, 4, 2},
                {1, 3, 2, 4},
                {3, 2, 4, 4}
        };
        assertFalse(sol.isRectangleCover(rectangles));

        rectangles = new int[][]{
                {1, 1, 3, 3},
                {3, 1, 4, 2},
                {1, 3, 2, 4},
                {2, 2, 4, 4}
        };
        assertFalse(sol.isRectangleCover(rectangles));
    }

}
