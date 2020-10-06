package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FlipGameTests {

    @Test
    public void testSolution() {
        FlipGame.Solution sol = new FlipGame().new Solution();
        List<String> res = sol.generatePossibleNextMoves("++++");
        assertEquals(3, res.size());
        assertTrue(res.contains("--++"));
        assertTrue(res.contains("+--+"));
        assertTrue(res.contains("++--"));
    }

    @Test
    public void testSolution2() {
        FlipGame.Solution_2 sol = new FlipGame().new Solution_2();
        assertTrue(sol.canWin("++++"));
    }
}
