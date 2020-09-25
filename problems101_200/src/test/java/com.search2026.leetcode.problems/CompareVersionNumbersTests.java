package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CompareVersionNumbersTests {

    @Test
    public void testSolution() {
        CompareVersionNumbers.Solution sol = new CompareVersionNumbers().new Solution();
        assertEquals(0, sol.compareVersion("1.01", "1.001"));
        assertEquals(0, sol.compareVersion("1.0", "1.0.0"));
        assertEquals(-1, sol.compareVersion("0.1", "1.1"));
    }

}
