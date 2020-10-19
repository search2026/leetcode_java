package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AndroidUnlockPatternsTests {

    @Test
    public void testSolution() {
        AndroidUnlockPatterns.Solution sol = new AndroidUnlockPatterns().new Solution();
        assertEquals(9, sol.numberOfPatterns(1, 1));
        assertEquals(385, sol.numberOfPatterns(1, 3));
        assertEquals(320, sol.numberOfPatterns(3, 3));
        assertEquals(34792, sol.numberOfPatterns(4, 6));
        assertEquals(33168, sol.numberOfPatterns(5, 6));
        assertEquals(26016, sol.numberOfPatterns(6, 6));
    }

    @Test
    public void testSolution2() {
        AndroidUnlockPatterns.Solution_2 sol = new AndroidUnlockPatterns().new Solution_2();
        assertEquals(9, sol.numberOfPatterns(1, 1));
        assertEquals(385, sol.numberOfPatterns(1, 3));
        assertEquals(320, sol.numberOfPatterns(3, 3));
        assertEquals(34792, sol.numberOfPatterns(4, 6));
        assertEquals(33168, sol.numberOfPatterns(5, 6));
        assertEquals(26016, sol.numberOfPatterns(6, 6));
    }

}
