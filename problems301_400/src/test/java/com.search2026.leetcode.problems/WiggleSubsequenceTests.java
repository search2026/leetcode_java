package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WiggleSubsequenceTests {

    @Test
    public void testSolution() {
        WiggleSubsequence.Solution sol = new WiggleSubsequence().new Solution();
        assertEquals(6, sol.wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5}));
        assertEquals(7, sol.wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
        assertEquals(2, sol.wiggleMaxLength(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }

}
