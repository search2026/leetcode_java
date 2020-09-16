package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RotateImageTests {

    @Test
    public void testSolution() {
        RotateImage.Solution sol = new RotateImage().new Solution();
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        int[][] expected = {{15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9}, {16, 7, 10, 11}};
        sol.rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            assertArrayEquals(expected[i], matrix[i]);
        }
    }

}
