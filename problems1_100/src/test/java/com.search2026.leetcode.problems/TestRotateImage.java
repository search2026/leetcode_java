package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestRotateImage {

    @Test
    public void test1() {
        RotateImage.Solution sol = new RotateImage().new Solution();
        int[][] metrix = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16},
        };
        int[][] expected = new int[][]{
                {15, 13, 2, 5},
                {14, 3, 4, 1},
                {12, 6, 8, 9},
                {16, 7, 10, 11},
        };
        sol.rotate(metrix);
        for (int i=0; i< metrix.length; i++) {
            assertArrayEquals(expected[i], metrix[i]);
        }
    }
}
