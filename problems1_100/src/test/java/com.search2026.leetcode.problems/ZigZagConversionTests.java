package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ZigZagConversionTests {

    @Test
    public void testSolution() {
        ZigZagConversion.Solution sol = new ZigZagConversion().new Solution();
        assertEquals("PAHNAPLSIIGYIR", sol.convert("PAYPALISHIRING", 3));
        assertEquals("PINALSIGYAHRPI", sol.convert("PAYPALISHIRING", 4));
    }

}
