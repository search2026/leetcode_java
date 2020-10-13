package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PatchingArrayTests {

    @Test
    public void testSolution() {
        PatchingArray.Solution sol = new PatchingArray().new Solution();
        assertEquals(1, sol.minPatches(new int[]{1, 3}, 6));
        assertEquals(2, sol.minPatches(new int[]{1, 5, 10}, 20));
        assertEquals(0, sol.minPatches(new int[]{1, 2, 2}, 5));
    }

    @Test
    public void testSolution2() {
        PatchingArray.Solution_2 sol = new PatchingArray().new Solution_2();
        assertEquals(1, sol.minPatches(new int[]{1, 3}, 6));
        assertEquals(2, sol.minPatches(new int[]{1, 5, 10}, 20));
        assertEquals(0, sol.minPatches(new int[]{1, 2, 2}, 5));
    }

}
