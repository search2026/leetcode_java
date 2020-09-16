package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstMissingPositiveTests {

    @Test
    public void testSolution() {
        FirstMissingPositive.Solution sol = new FirstMissingPositive().new Solution();
        assertEquals(1, sol.firstMissingPositive(new int[]{}));
        assertEquals(3, sol.firstMissingPositive(new int[]{1, 2, 0}));
        assertEquals(2, sol.firstMissingPositive(new int[]{3, 4, -1, 1}));
    }

}
