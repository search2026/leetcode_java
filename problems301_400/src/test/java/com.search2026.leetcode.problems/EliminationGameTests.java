package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EliminationGameTests {

    @Test
    public void testSolution() {
        EliminationGame.Solution sol = new EliminationGame().new Solution();
        assertEquals(6, sol.lastRemaining(9));
    }

}
