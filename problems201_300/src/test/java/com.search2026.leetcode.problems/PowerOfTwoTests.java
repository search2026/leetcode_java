package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PowerOfTwoTests {

    @Test
    public void testSolution() {
        PowerOfTwo.Solution sol = new PowerOfTwo().new Solution();
        assertFalse(sol.isPowerOfTwo(7));
        assertTrue(sol.isPowerOfTwo(8));
    }

}
