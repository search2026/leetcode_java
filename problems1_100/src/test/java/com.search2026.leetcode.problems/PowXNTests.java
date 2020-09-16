package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PowXNTests {

    @Test
    public void testSolution() {
        PowXN.Solution sol = new PowXN().new Solution();
        assertEquals(4096.0, sol.pow(2.0, 12), 1E-6);
        assertEquals(998001.0, sol.pow(999.0, 2), 1E-6);
        assertEquals(0.333333, sol.pow(3.0, -1), 1E-6);
    }

    @Test
    public void testSolution2() {
        PowXN.Solution_2 sol = new PowXN().new Solution_2();
        assertEquals(4096.0, sol.pow(2.0, 12), 1E-6);
        assertEquals(998001.0, sol.pow(999.0, 2), 1E-6);
        assertEquals(0.333333, sol.pow(3.0, -1), 1E-6);
    }

}
