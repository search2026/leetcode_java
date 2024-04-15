package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;


public class FrogJumpTests {

    @Test
    public void testSolution() {
        FrogJump.Solution sol = new FrogJump().new Solution();
        Assertions.assertTrue(sol.canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));
        Assertions.assertFalse(sol.canCross(new int[]{0, 1, 2, 3, 4, 8, 9, 11}));
    }

}
