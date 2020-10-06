package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PaintHouseTests {

    @Test
    public void testSolution() {
        PaintHouse.Solution sol = new PaintHouse().new Solution();
        int[][] costs = {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
//        assertEquals(10, sol.minCost(costs));
    }

    @Test
    public void testSolution2() {
        PaintHouse.Solution_2 sol = new PaintHouse().new Solution_2();
        int[][] costs = {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
        assertEquals(10, sol.minCost(costs));
    }

    @Test
    public void testSolution3() {
        PaintHouse.Solution_3 sol = new PaintHouse().new Solution_3();
        int[][] costs = {{1,5,3}, {2,9,4}};
        assertEquals(5, sol.minCostII(costs));
    }

}
