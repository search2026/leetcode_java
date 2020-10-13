package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SelfCrossingTests {

    @Test
    public void test1() {
        SelfCrossing.Solution sol = new SelfCrossing().new Solution();
        assertTrue(sol.isSelfCrossing(new int[]{2, 1, 1, 2}));
        assertTrue(sol.isSelfCrossing(new int[]{1, 1, 1, 1}));
        assertFalse(sol.isSelfCrossing(new int[]{1, 2, 3, 4}));
        assertTrue(sol.isSelfCrossing(new int[]{1, 1, 2, 1, 1}));
        assertTrue(sol.isSelfCrossing(new int[]{1, 1, 2, 2, 1, 1}));
        assertFalse(sol.isSelfCrossing(new int[]{3, 3, 3, 2, 1, 1}));
    }

}
