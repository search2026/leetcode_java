package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestSearchA2DMatrix {

    @Test
    public void test1() {
        SearchA2DMatrix.Solution sol = new SearchA2DMatrix().new Solution();
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50},};
        assertTrue(sol.searchMatrix(matrix, 3));
        assertFalse(sol.searchMatrix(matrix, 12));
    }

    @Test
    public void test2() {
        SearchA2DMatrix.Solution_2 sol = new SearchA2DMatrix().new Solution_2();
        int[][] matrix =
                {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30},};
        assertTrue(sol.searchMatrix(matrix, 5));
        assertFalse(sol.searchMatrix(matrix, 20));
    }

}
