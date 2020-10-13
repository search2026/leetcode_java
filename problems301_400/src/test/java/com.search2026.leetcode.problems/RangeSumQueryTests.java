package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RangeSumQueryTests {

    @Test
    public void testSolution() {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        RangeSumQuery.NumArray sol = new RangeSumQuery().new NumArray(nums);
        assertEquals(sol.sumRange(0, 2), 1);
        assertEquals(sol.sumRange(2, 5), -1);
        assertEquals(sol.sumRange(0, 5), -3);
    }

    @Test
    public void testSolution2() {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5},
        };
        RangeSumQuery.NumMatrix sol = new RangeSumQuery().new NumMatrix(matrix);
        assertEquals(8, sol.sumRegion(2, 1, 4, 3));
        assertEquals(11, sol.sumRegion(1, 1, 2, 2));
        assertEquals(12, sol.sumRegion(1, 2, 2, 4));
    }
}
