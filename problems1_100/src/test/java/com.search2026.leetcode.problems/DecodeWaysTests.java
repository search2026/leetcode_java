package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecodeWaysTests {

    @Test
    public void testSolution() {
        DecodeWays.Solution sol = new DecodeWays().new Solution();
        assertEquals(0, sol.numDecodings(""));
        assertEquals(0, sol.numDecodings("0"));
        assertEquals(1, sol.numDecodings("5"));
        assertEquals(1, sol.numDecodings("10"));
        assertEquals(2, sol.numDecodings("12"));
        assertEquals(2, sol.numDecodings("15"));
        assertEquals(2, sol.numDecodings("26"));
        assertEquals(0, sol.numDecodings("30"));
        assertEquals(1, sol.numDecodings("42"));
    }

    @Test
    public void testSolution2() {
        DecodeWays.Solution_2 sol = new DecodeWays().new Solution_2();
        assertEquals(1, sol.numDecodings("5"));
        assertEquals(1, sol.numDecodings("10"));
        assertEquals(2, sol.numDecodings("12"));
        assertEquals(2, sol.numDecodings("15"));
        assertEquals(2, sol.numDecodings("26"));
        assertEquals(0, sol.numDecodings("30"));
        assertEquals(1, sol.numDecodings("42"));
    }

    @Test
    public void testSolution3() {
        DecodeWays.Solution_3 sol = new DecodeWays().new Solution_3();
        assertEquals(9, sol.numDecodings("*"));
        assertEquals(18, sol.numDecodings("1*"));
    }

    @Test
    public void testSolution4() {
        DecodeWays.Solution_4 sol = new DecodeWays().new Solution_4();
        assertEquals(9, sol.numDecodings("*"));
        assertEquals(18, sol.numDecodings("1*"));
    }

}
