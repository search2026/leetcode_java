package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SqrtXTests {

    @Test
    public void testSolution() {
        SqrtX.Solution sol = new SqrtX().new Solution();
        assertEquals(0, sol.sqrt(0));
        assertEquals(1, sol.sqrt(1));
        assertEquals(2, sol.sqrt(5));
        assertEquals(4, sol.sqrt(16));
        assertEquals(4, sol.sqrt(17));
    }

    @Test
    public void testSolution2() {
        SqrtX.Solution_2 sol = new SqrtX().new Solution_2();
        assertEquals(0, sol.sqrt(0));
        assertEquals(1, sol.sqrt(1));
        assertEquals(2, sol.sqrt(5));
        assertEquals(4, sol.sqrt(16));
        assertEquals(4, sol.sqrt(17));
    }

}
