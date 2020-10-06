package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MissingNumberTests {

    @Test
    public void testSolution() {
        MissingNumber.Solution sol = new MissingNumber().new Solution();
        assertEquals(0, sol.missingNumber(new int[]{3, 4, 1, 2}));
        assertEquals(5, sol.missingNumber(new int[]{3, 4, 0, 1, 2}));
        assertEquals(3, sol.missingNumber(new int[]{4, 0, 1, 2}));
        assertEquals(2, sol.missingNumber(new int[]{3, 0, 1}));
        assertEquals(2, sol.missingNumber(new int[]{0, 1}));
        assertEquals(8, sol.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }

}
