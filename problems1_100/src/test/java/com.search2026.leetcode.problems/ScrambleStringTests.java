package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ScrambleStringTests {

    @Test
    public void testSolution() {
        ScrambleString.Solution sol = new ScrambleString().new Solution();
        assertFalse(sol.isScramble("rttae", "great"));
        assertTrue(sol.isScramble("rgtae", "great"));
    }

}
