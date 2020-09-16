package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class IntegerToRomanTests {

    @Test
    public void testSolution() {
        IntegerToRoman.Solution sol = new IntegerToRoman().new Solution();
        assertEquals("III", sol.intToRoman(3));
        assertEquals("XV", sol.intToRoman(15));
        assertEquals("XLIX", sol.intToRoman(49));
        assertEquals("XCVII", sol.intToRoman(97));
        assertEquals("XCIX", sol.intToRoman(99));
        assertEquals("CCC", sol.intToRoman(300));
        assertEquals("MXCVI", sol.intToRoman(1096));
        assertEquals("MMCCC", sol.intToRoman(2300));
    }

    @Test
    public void testSolution2() {
        IntegerToRoman.Solution_2 sol = new IntegerToRoman().new Solution_2();
        assertEquals("III", sol.intToRoman(3));
        assertEquals("XV", sol.intToRoman(15));
        assertEquals("XLIX", sol.intToRoman(49));
        assertEquals("XCVII", sol.intToRoman(97));
        assertEquals("XCIX", sol.intToRoman(99));
        assertEquals("CCC", sol.intToRoman(300));
        assertEquals("MXCVI", sol.intToRoman(1096));
        assertEquals("MMCCC", sol.intToRoman(2300));
    }

}
