package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximalSquareTests {

    @Test
    public void testSolution() {
        MaximalSquare.Solution sol = new MaximalSquare().new Solution();
        char[][] grid = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        assertEquals(4, sol.maximalSquare(grid));
    }

    @Test
    public void testSolution2() {
        MaximalSquare.Solution_2 sol = new MaximalSquare().new Solution_2();
        char[][] grid = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        assertEquals(4, sol.maximalSquare(grid));
    }


    @Test
    public void testSolution3() {
        MaximalSquare.Solution_3 sol = new MaximalSquare().new Solution_3();
        char[][] grid = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        assertEquals(4, sol.maximalSquare(grid));
    }

}
