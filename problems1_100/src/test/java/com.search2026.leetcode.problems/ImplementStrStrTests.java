package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ImplementStrStrTests {

    @Test
    public void testSolution() {
        ImplementStrStr.Solution sol = new ImplementStrStr().new Solution();
        assertEquals(2, sol.strStr("hello", "ll"));
        assertEquals(-1, sol.strStr("aaaaa", "bba"));
    }

    @Test
    public void testSolution2() {
        ImplementStrStr.Solution_2 sol = new ImplementStrStr().new Solution_2();
        assertEquals(2, sol.strStr("hello", "ll"));
        assertEquals(-1, sol.strStr("aaaaa", "bba"));
    }

    @Test
    public void testSolution3() {
        ImplementStrStr.Solution_3 sol = new ImplementStrStr().new Solution_3();
        assertEquals(2, sol.strStr("hello", "ll"));
        assertEquals(-1, sol.strStr("aaaaa", "bba"));
    }

    @Test
    public void testSolution4() {
        ImplementStrStr.Solution_4 sol = new ImplementStrStr().new Solution_4();
        assertEquals(2, sol.strStr("hello", "ll"));
        assertEquals(-1, sol.strStr("aaaaa", "bba"));
    }

}
