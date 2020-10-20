package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KthSmallestElementInASortedMatrixTests {

    @Test
    public void test1() {
        KthSmallestElementInASortedMatrix.Solution sol = new KthSmallestElementInASortedMatrix().new Solution();
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        assertEquals(1, sol.kthSmallest(matrix, 1));
        assertEquals(9, sol.kthSmallest(matrix, 3));
        assertEquals(11, sol.kthSmallest(matrix, 5));
        assertEquals(12, sol.kthSmallest(matrix, 6));
        assertEquals(13, sol.kthSmallest(matrix, 7));
        assertEquals(13, sol.kthSmallest(matrix, 8));
        assertEquals(15, sol.kthSmallest(matrix, 9));
    }

    @Test
    public void test2() {
        KthSmallestElementInASortedMatrix.Solution_2 sol = new KthSmallestElementInASortedMatrix().new Solution_2();
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        assertEquals(1, sol.kthSmallest(matrix, 1));
        assertEquals(9, sol.kthSmallest(matrix, 3));
        assertEquals(11, sol.kthSmallest(matrix, 5));
        assertEquals(12, sol.kthSmallest(matrix, 6));
        assertEquals(13, sol.kthSmallest(matrix, 7));
        assertEquals(13, sol.kthSmallest(matrix, 8));
        assertEquals(15, sol.kthSmallest(matrix, 9));
    }

}
