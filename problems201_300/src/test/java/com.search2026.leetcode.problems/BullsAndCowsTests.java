package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BullsAndCowsTests {

    @Test
    public void testSolution() {
        BullsAndCows.Solution sol = new BullsAndCows().new Solution();
        assertTrue(sol.getHint("1807", "7810").equals("1A3B"));
        assertTrue(sol.getHint("1123", "0111").equals("1A1B"));
    }

}
