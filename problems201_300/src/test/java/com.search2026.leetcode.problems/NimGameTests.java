package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NimGameTests {

    @Test
    public void testSolution() {
        NimGame.Solution sol = new NimGame().new Solution();
        assertTrue(sol.canWinNim(1));
        assertTrue(sol.canWinNim(2));
        assertTrue(sol.canWinNim(7));
        assertFalse(sol.canWinNim(8));
    }

}
