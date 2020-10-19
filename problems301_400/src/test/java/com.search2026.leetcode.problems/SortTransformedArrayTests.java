package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortTransformedArrayTests {

    @Test
    public void testSolution() {
        SortTransformedArray.Solution sol = new SortTransformedArray().new Solution();
        int[] testArr = {-4, -2, 2, 4};
        int[] res1 = {3, 9, 15, 33};
        int[] res2 = {-23, -5, 1, 7};
        assertArrayEquals(res1, sol.sortTransformedArray(testArr, 1, 3, 5));
        assertArrayEquals(res2, sol.sortTransformedArray(testArr, -1, 3, 5));
    }

    @Test
    public void testSolution2() {
        SortTransformedArray.Solution_2 sol = new SortTransformedArray().new Solution_2();
        int[] testArr = {-4, -2, 2, 4};
        int[] res1 = {3, 9, 15, 33};
        int[] res2 = {-23, -5, 1, 7};
        assertArrayEquals(res1, sol.sortTransformedArray(testArr, 1, 3, 5));
        assertArrayEquals(res2, sol.sortTransformedArray(testArr, -1, 3, 5));
    }

}
