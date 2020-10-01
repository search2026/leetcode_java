package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TheSkylineProblemTests {

    @Test
    public void test1() {
        TheSkylineProblem.Solution sol = new TheSkylineProblem().new Solution();
        int[][] buildings = {
                {2, 9, 10},
                {3, 7, 15},
                {5, 12, 12},
                {15, 20, 10},
                {19, 24, 8},
        };
        List<int[]> res = sol.getSkyline(buildings);
        assertEquals(7, res.size());
    }

}
