package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetMatrixZeroesTests {

    @Test
    public void testSolution() {
        SetMatrixZeroes.Solution sol = new SetMatrixZeroes().new Solution();
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        sol.setZeroes(matrix);
        assertEquals(3, matrix.length);
        assertArrayEquals(new int[]{0, 0, 0, 0}, matrix[0]);
        assertArrayEquals(new int[]{0, 4, 5, 0}, matrix[1]);
        assertArrayEquals(new int[]{0, 3, 1, 0}, matrix[2]);
    }

}
