package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FallingSquaresTests {

    @Test
    public void testSolution() {
        FallingSquares.Solution sol = new FallingSquares().new Solution();
        int[][] positions = {
                {1, 2},
                {2, 3},
                {6, 1}
        };
        List<Integer> res = sol.fallingSquares(positions);
        assertEquals(3, res.size());
    }


    @Test
    public void testSolution2() {
        FallingSquares.Solution_2 sol = new FallingSquares().new Solution_2();
        int[][] positions = {
                {1, 2},
                {2, 3},
                {6, 1}
        };
        List<Integer> res = sol.fallingSquares(positions);
        assertEquals(3, res.size());
    }

}
