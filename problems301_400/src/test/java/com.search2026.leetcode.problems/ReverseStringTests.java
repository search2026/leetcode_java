package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReverseStringTests {

    @Test
    public void testSolution() {
        ReverseString.Solution sol = new ReverseString().new Solution();
        assertTrue(sol.reverseString("").equals(""));
        assertTrue(sol.reverseString(null).equals(""));
        assertTrue(sol.reverseString("s").equals("s"));
        assertEquals("olleh", sol.reverseString("hello"));
        assertTrue(sol.reverseString("abcccd").equals("dcccba"));
    }

    @Test
    public void testSolution2() {
        ReverseString.Solution_2 sol = new ReverseString().new Solution_2();
        assertTrue(sol.reverseString("").equals(""));
        assertTrue(sol.reverseString(null).equals(""));
        assertTrue(sol.reverseString("s").equals("s"));
        assertEquals("olleh", sol.reverseString("hello"));
        assertTrue(sol.reverseString("abcccd").equals("dcccba"));
    }

}
