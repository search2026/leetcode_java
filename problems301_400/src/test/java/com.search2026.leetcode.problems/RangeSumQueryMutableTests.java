package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RangeSumQueryMutableTests {

    @Test
    public void testSolution() {
        RangeSumQueryMutable.NumArray sol = new RangeSumQueryMutable().new NumArray(new int[]{1, 3, 5});
        assertEquals(9, sol.sumRange(0, 2));
        sol.update(1, 2);
        assertEquals(8, sol.sumRange(0, 2));
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
        RangeSumQueryMutable.NumMatrix sol = new RangeSumQueryMutable().new NumMatrix(matrix);
        assertEquals(8, sol.sumRegion(2, 1, 4, 3));
        sol.update(3, 2, 2);
        assertEquals(10, sol.sumRegion(2, 1, 4, 3));
    }

}
