package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShortestDistanceFromAllBuildingsTests {

    @Test
    public void testSolution() {
        ShortestDistanceFromAllBuildings.Solution sol = new ShortestDistanceFromAllBuildings().new Solution();
        int[][] nums = {
                {1, 0, 2, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0}
        };
        assertEquals(7, sol.shortestDistance(nums));
    }

    @Test
    public void testSolution2() {
        ShortestDistanceFromAllBuildings.Solution_2 sol = new ShortestDistanceFromAllBuildings().new Solution_2();
        int[][] test = {
                {1, 0, 2, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0}
        };
        assertEquals(7, sol.shortestDistance(test));
    }

}
