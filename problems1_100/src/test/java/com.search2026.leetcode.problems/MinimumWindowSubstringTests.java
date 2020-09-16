package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MinimumWindowSubstringTests {

    @Test
    public void testSolution() {
        MinimumWindowSubstring.Solution sol = new MinimumWindowSubstring().new Solution();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        assertEquals("BANC", sol.minWindow(s, t));
    }

    @Test
    public void testSolution2() {
        MinimumWindowSubstring.Solution_2 sol = new MinimumWindowSubstring().new Solution_2();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        assertEquals("BANC", sol.minWindow(s, t));
    }

    @Test
    public void testSolution3() {
        MinimumWindowSubstring.Solution_3 sol = new MinimumWindowSubstring().new Solution_3();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        assertEquals("BANC", sol.minWindow(s, t));
    }

}
