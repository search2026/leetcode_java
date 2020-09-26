package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DungeonGameTests {

    @Test
    public void testSolution() {
        DungeonGame.Solution sol = new DungeonGame().new Solution();
        int[][] dungeon = {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5},
        };
        assertEquals(7, sol.calculateMinimumHP(dungeon));
    }

}
