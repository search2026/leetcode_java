package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BestMeetingPointTests {

    @Test
    public void testSolution() {
        BestMeetingPoint.Solution sol = new BestMeetingPoint().new Solution();
        int[][] grid = {
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
        };
        assertEquals(6, sol.minTotalDistance(grid));
    }

}
