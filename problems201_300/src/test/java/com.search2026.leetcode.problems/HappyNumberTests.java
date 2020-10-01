package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HappyNumberTests {

    @Test
    public void testSolution() {
        HappyNumber.Solution sol = new HappyNumber().new Solution();
        assertTrue(sol.isHappy(19));
        assertFalse(sol.isHappy(18));
    }

    @Test
    public void testSolution2() {
        HappyNumber.Solution_2 sol = new HappyNumber().new Solution_2();
        assertTrue(sol.isHappy(19));
        assertFalse(sol.isHappy(18));
    }

}
