package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PowerOfFourTests {

    @Test
    public void testSolution() {
        PowerOfFour.Solution sol = new PowerOfFour().new Solution();
        assertTrue(sol.isPowerOfFour(1));
        assertFalse(sol.isPowerOfFour(6));
        assertFalse(sol.isPowerOfFour(8));
        assertFalse(sol.isPowerOfFour(14));
        assertFalse(sol.isPowerOfFour(15));
        assertTrue(sol.isPowerOfFour(16));
    }

}
