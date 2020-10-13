package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PowerOfThreeTests {

    @Test
    public void testSolution() {
        PowerOfThree.Solution sol = new PowerOfThree().new Solution();
        assertTrue(sol.isPowerOfThree(81));
        assertFalse(sol.isPowerOfThree(82));
    }

}
