package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMinimumPathSum {

    @Test
    public void test1() {
        MinimumPathSum.Solution sol = new MinimumPathSum().new Solution();
        int[][] grid1 = new int[][]{
                new int[]{1, 2},
                new int[]{1, 1}
        };
        assertEquals(3, sol.minPathSum(grid1));
    }

    @Test
    public void test2() {
        MinimumPathSum.Solution_2 sol = new MinimumPathSum().new Solution_2();
        int[][] grid1 = new int[][]{
                new int[]{1, 2},
                new int[]{1, 1}
        };
        assertEquals(3, sol.minPathSum(grid1));
    }

}
