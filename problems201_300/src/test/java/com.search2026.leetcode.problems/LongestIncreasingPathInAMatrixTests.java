package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestIncreasingPathInAMatrixTests {

    @Test
    public void testSolution() {
        LongestIncreasingPathInAMatrix.Solution sol = new LongestIncreasingPathInAMatrix().new Solution();
        int[][] test1 = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1},
        };
        assertEquals(4, sol.longestIncreasingPath(test1));
        int[][] test2 = new int[][]{new int[]{3, 4, 5}, new int[]{3, 2, 6}, new int[]{2, 2, 1},};
        assertEquals(4, sol.longestIncreasingPath(test2));
    }

}
