package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class WallsAndGatesTests {

    @Test
    public void testSolution() {
        WallsAndGates.Solution sol = new WallsAndGates().new Solution();
        int[][] grid = {
                {2147483647, -1, 0, 2147483647},
                {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1},
                {0, -1, 2147483647, 2147483647}
        };
        sol.wallsAndGates(grid);
        assertArrayEquals(new int[]{3, -1, 0, 1}, grid[0]);
        assertArrayEquals(new int[]{2, 2, 1, -1}, grid[1]);
        assertArrayEquals(new int[]{1, -1, 2, -1}, grid[2]);
        assertArrayEquals(new int[]{0, -1, 3, 4}, grid[3]);
    }

    @Test
    public void testSolution2() {
        WallsAndGates.Solution_2 sol = new WallsAndGates().new Solution_2();
        int[][] grid = {
                {2147483647, -1, 0, 2147483647},
                {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1},
                {0, -1, 2147483647, 2147483647}
        };
        sol.wallsAndGates(grid);
        assertArrayEquals(new int[]{3, -1, 0, 1}, grid[0]);
        assertArrayEquals(new int[]{2, 2, 1, -1}, grid[1]);
        assertArrayEquals(new int[]{1, -1, 2, -1}, grid[2]);
        assertArrayEquals(new int[]{0, -1, 3, 4}, grid[3]);
    }

}
