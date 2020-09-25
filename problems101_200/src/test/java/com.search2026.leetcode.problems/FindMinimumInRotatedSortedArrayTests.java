package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindMinimumInRotatedSortedArrayTests {

    @Test
    public void testSolution() {
        FindMinimumInRotatedSortedArray.Solution sol = new FindMinimumInRotatedSortedArray().new Solution();
        assertEquals(1, sol.findMin(new int[]{2, 1}));
        assertEquals(1, sol.findMin(new int[]{3, 1, 2}));
        assertEquals(0, sol.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        assertEquals(7, sol.findMin(new int[]{7, 8, 9, 11}));
        assertEquals(-4, sol.findMin(new int[]{-1, 0, 9, 11, -4}));
    }

    @Test
    public void testSolution2() {
        FindMinimumInRotatedSortedArray.Solution_2 sol = new FindMinimumInRotatedSortedArray().new Solution_2();
        assertEquals(1, sol.findMin(new int[]{2, 1}));
        assertEquals(1, sol.findMin(new int[]{3, 1, 2}));
        assertEquals(0, sol.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        assertEquals(0, sol.findMin(new int[]{4, 5, 5, 6, 7, 7, 7, 0, 0, 1, 2}));
        assertEquals(7, sol.findMin(new int[]{7, 8, 9, 11}));
        assertEquals(7, sol.findMin(new int[]{7, 7, 7, 8, 9, 9, 9, 9, 11}));
        assertEquals(-4, sol.findMin(new int[]{-1, 0, 9, 11, -4}));
        assertEquals(-4, sol.findMin(new int[]{-1, -1, 0, 0, 0, 0, 9, 11, -4, -4}));
        assertEquals(0, sol.findMin(new int[]{1, 1, 1, 0, 1}));
        assertEquals(0, sol.findMin(new int[]{1, 1, 1, 1, 1, 0}));
        assertEquals(0, sol.findMin(new int[]{0, 1, 1, 1, 1, 1}));
    }

}
