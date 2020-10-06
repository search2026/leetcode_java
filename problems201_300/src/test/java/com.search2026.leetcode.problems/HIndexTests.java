package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HIndexTests {

    @Test
    public void testSolution() {
        HIndex.Solution sol = new HIndex().new Solution();
        assertEquals(3, sol.hIndex(new int[]{3, 0, 6, 1, 5}));
    }

    @Test
    public void testSolution2() {
        HIndex.Solution_2 sol = new HIndex().new Solution_2();
        assertEquals(3, sol.hIndex(new int[]{0, 1, 3, 5, 6}));
    }

}
