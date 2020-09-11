package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLargestRectangleInHistogram {

    @Test
    public void test1() {
        LargestRectangleInHistogram.Solution sol = new LargestRectangleInHistogram().new Solution();
        assertEquals(1, sol.largestRectangleArea(new int[]{1}));
        assertEquals(10, sol.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        assertEquals(7, sol.largestRectangleArea(new int[]{2, 7, 1}));
        assertEquals(7, sol.largestRectangleArea(new int[]{1, 7, 2}));
        assertEquals(7, sol.largestRectangleArea(new int[]{2, 3, 7}));
    }

    @Test
    public void test2() {
        LargestRectangleInHistogram.Solution_2 sol = new LargestRectangleInHistogram().new Solution_2();
        assertEquals(1, sol.largestRectangleArea(new int[]{1}));
        assertEquals(10, sol.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        assertEquals(7, sol.largestRectangleArea(new int[]{2, 7, 1}));
        assertEquals(7, sol.largestRectangleArea(new int[]{1, 7, 2}));
    }

    @Test
    public void test3() {
        LargestRectangleInHistogram.Solution_3 sol = new LargestRectangleInHistogram().new Solution_3();
        assertEquals(1, sol.largestRectangleArea(new int[]{1}));
        assertEquals(10, sol.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        assertEquals(7, sol.largestRectangleArea(new int[]{2, 7, 1}));
        assertEquals(7, sol.largestRectangleArea(new int[]{1, 7, 2}));
    }

}
