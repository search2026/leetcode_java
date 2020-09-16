package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniquePathsTests {

    @Test
    public void testSolution() {
        UniquePaths.Solution sol = new UniquePaths().new Solution();
        assertEquals(15, sol.uniquePaths(3, 5));
        assertEquals(15, sol.uniquePaths(5, 3));
        assertEquals(56, sol.uniquePaths(4, 6));
        assertEquals(56, sol.uniquePaths(6, 4));
        assertEquals(8, sol.uniquePaths(2, 8));
        assertEquals(8, sol.uniquePaths(8, 2));
        assertEquals(3003, sol.uniquePaths(7, 9));
        assertEquals(3003, sol.uniquePaths(9, 7));
    }

    @Test
    public void testSolution2() {
        UniquePaths.Solution_2 sol = new UniquePaths().new Solution_2();
        assertEquals(15, sol.uniquePaths(3, 5));
        assertEquals(15, sol.uniquePaths(5, 3));
        assertEquals(56, sol.uniquePaths(4, 6));
        assertEquals(56, sol.uniquePaths(6, 4));
        assertEquals(8, sol.uniquePaths(2, 8));
        assertEquals(8, sol.uniquePaths(8, 2));
        assertEquals(3003, sol.uniquePaths(7, 9));
        assertEquals(3003, sol.uniquePaths(9, 7));
    }

    @Test
    public void testSolution3() {
        UniquePaths.Solution_3 sol = new UniquePaths().new Solution_3();
        assertEquals(15, sol.uniquePaths(3, 5));
        assertEquals(15, sol.uniquePaths(5, 3));
        assertEquals(56, sol.uniquePaths(4, 6));
        assertEquals(56, sol.uniquePaths(6, 4));
        assertEquals(8, sol.uniquePaths(2, 8));
        assertEquals(8, sol.uniquePaths(8, 2));
        assertEquals(3003, sol.uniquePaths(7, 9));
        assertEquals(3003, sol.uniquePaths(9, 7));
    }

    @Test
    public void testSolution4() {
        UniquePaths.Solution_4 sol = new UniquePaths().new Solution_4();
        int[][] grid = {
                new int[]{0, 0, 0},
                new int[]{0, 1, 0},
                new int[]{0, 0, 0}
        };
        assertEquals(2, sol.uniquePathsWithObstacles(grid));

        grid = new int[][]{
                new int[]{1, 0}
        };
        assertEquals(0, sol.uniquePathsWithObstacles(grid));
    }

    @Test
    public void testSolution5() {
        UniquePaths.Solution_5 sol = new UniquePaths().new Solution_5();
        int[][] grid = {
                new int[]{0, 0, 0},
                new int[]{0, 1, 0},
                new int[]{0, 0, 0}
        };
        assertEquals(2, sol.uniquePathsWithObstacles(grid));

        grid = new int[][]{
                new int[]{1, 0}
        };
        assertEquals(0, sol.uniquePathsWithObstacles(grid));
    }

}
