package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximalRectangleTests {

    @Test
    public void testSolution() {
        MaximalRectangle.Solution sol = new MaximalRectangle().new Solution();
        char[][] grid = new char[][]{
                new char[]{'1'}
        };
        assertEquals(1, sol.maximalRectangle(grid));
        grid = new char[][]{
                new char[]{'0', '1'}
        };
        assertEquals(1, sol.maximalRectangle(grid));
        grid = new char[][]{
                new char[]{'1', '0', '1', '0', '0'},
                new char[]{'1', '0', '1', '1', '1'},
                new char[]{'1', '1', '1', '1', '1'},
                new char[]{'1', '0', '0', '1', '0'}
        };
        assertEquals(6, sol.maximalRectangle(grid));
    }

    @Test
    public void testSolution2() {
        MaximalRectangle.Solution_2 sol = new MaximalRectangle().new Solution_2();
        char[][] grid = new char[][]{
                new char[]{'1'}
        };
        assertEquals(1, sol.maximalRectangle(grid));
        grid = new char[][]{
                new char[]{'0', '1'}
        };
        assertEquals(1, sol.maximalRectangle(grid));
        grid = new char[][]{
                new char[]{'1', '0', '1', '0', '0'},
                new char[]{'1', '0', '1', '1', '1'},
                new char[]{'1', '1', '1', '1', '1'},
                new char[]{'1', '0', '0', '1', '0'}
        };
        assertEquals(6, sol.maximalRectangle(grid));
    }

    @Test
    public void testSolution3() {
        MaximalRectangle.Solution_3 sol = new MaximalRectangle().new Solution_3();
        char[][] grid = new char[][]{
                new char[]{'1'}
        };
        assertEquals(1, sol.maximalRectangle(grid));
        grid = new char[][]{
                new char[]{'0', '1'}
        };
        assertEquals(1, sol.maximalRectangle(grid));
        grid = new char[][]{
                new char[]{'1', '0', '1', '0', '0'},
                new char[]{'1', '0', '1', '1', '1'},
                new char[]{'1', '1', '1', '1', '1'},
                new char[]{'1', '0', '0', '1', '0'}
        };
        assertEquals(6, sol.maximalRectangle(grid));
    }

}
