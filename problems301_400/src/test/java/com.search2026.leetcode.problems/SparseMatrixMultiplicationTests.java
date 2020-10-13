package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SparseMatrixMultiplicationTests {

    @Test
    public void testSolution() {
        SparseMatrixMultiplication.Solution sol = new SparseMatrixMultiplication().new Solution();
        int[][] matrix1 = {
                {1, 0, 0},
                {-1, 0, 3},};
        int[][] matrix2 = {
                {7, 0, 0},
                {0, 0, 0},
                {0, 0, 1},};
        int[][] res = sol.multiply(matrix1, matrix2);
        assertEquals(2, res.length);
        assertEquals(3, res[0].length);
        assertArrayEquals(new int[]{7, 0, 0}, res[0]);
        assertArrayEquals(new int[]{-7, 0, 3}, res[1]);
    }

}
