package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestRomanToInteger {

    @Test
    public void test1() {
        RomanToInteger.Solution sol = new RomanToInteger().new Solution();
        assertEquals(3, sol.romanToInt("III"));
        assertEquals(15, sol.romanToInt("XV"));
        assertEquals(49, sol.romanToInt("XLIX"));
        assertEquals(97, sol.romanToInt("XCVII"));
        assertEquals(99, sol.romanToInt("XCIX"));
        assertEquals(300, sol.romanToInt("CCC"));
        assertEquals(1010, sol.romanToInt("MX"));
        assertEquals(1090, sol.romanToInt("MXC"));
        assertEquals(1095, sol.romanToInt("MXCV"));
        assertEquals(1096, sol.romanToInt("MXCVI"));
        assertEquals(2300, sol.romanToInt("MMCCC"));
    }

    @Test
    public void test2() {
        RomanToInteger.Solution_2 sol = new RomanToInteger().new Solution_2();
        assertEquals(3, sol.romanToInt("III"));
        assertEquals(15, sol.romanToInt("XV"));
        assertEquals(49, sol.romanToInt("XLIX"));
        assertEquals(97, sol.romanToInt("XCVII"));
        assertEquals(99, sol.romanToInt("XCIX"));
        assertEquals(300, sol.romanToInt("CCC"));
        assertEquals(1010, sol.romanToInt("MX"));
        assertEquals(1090, sol.romanToInt("MXC"));
        assertEquals(1095, sol.romanToInt("MXCV"));
        assertEquals(1096, sol.romanToInt("MXCVI"));
        assertEquals(2300, sol.romanToInt("MMCCC"));
    }

}
