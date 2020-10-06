package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfDigitOneTests {

    @Test
    public void testSolution() {
        NumberOfDigitOne.Solution sol = new NumberOfDigitOne().new Solution();
        assertEquals(6, sol.countDigitOne(13));
    }

}
