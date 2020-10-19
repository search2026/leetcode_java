package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxSumOfRectangleNoLargerThanKTests {

    @Test
    public void testSolution() {
        MaxSumOfRectangleNoLargerThanK.Solution sol = new MaxSumOfRectangleNoLargerThanK().new Solution();
        int[][] matrix = {
                {1, 0, 1},
                {0, -2, 3}
        };
        assertEquals(2, sol.maxSumSubmatrix(matrix, 2));
        matrix = new int[][]{
                {1, 2, -1, -4, -20},
                {-8, -3, 4, 2, 1},
                {3, 8, 10, 1, 3},
                {-4, -1, 1, 7, -6}
        };
        assertEquals(2, sol.maxSumSubmatrix(matrix, 2));
        assertEquals(8, sol.maxSumSubmatrix(matrix, 9));
    }

    @Test
    public void testSolution2() {
        MaxSumOfRectangleNoLargerThanK.Solution_2 sol = new MaxSumOfRectangleNoLargerThanK().new Solution_2();
        int[][] matrix = {
                {1, 0, 1},
                {0, -2, 3}
        };
        assertEquals(2, sol.maxSumSubmatrix(matrix, 2));
        matrix = new int[][]{
                {1, 2, -1, -4, -20},
                {-8, -3, 4, 2, 1},
                {3, 8, 10, 1, 3},
                {-4, -1, 1, 7, -6}
        };
        assertEquals(2, sol.maxSumSubmatrix(matrix, 2));
        assertEquals(8, sol.maxSumSubmatrix(matrix, 9));
    }

    @Test
    public void testSolution3() {
        MaxSumOfRectangleNoLargerThanK.Solution_3 sol = new MaxSumOfRectangleNoLargerThanK().new Solution_3();
        int[][] matrix = {
                {1, 0, 1},
                {0, -2, 3}
        };
        assertEquals(2, sol.maxSumSubmatrix(matrix, 2));
        matrix = new int[][]{
                {1, 2, -1, -4, -20},
                {-8, -3, 4, 2, 1},
                {3, 8, 10, 1, 3},
                {-4, -1, 1, 7, -6}
        };
        assertEquals(2, sol.maxSumSubmatrix(matrix, 2));
        assertEquals(8, sol.maxSumSubmatrix(matrix, 9));
    }

}
