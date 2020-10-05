package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StrobogrammaticTests {

    @Test
    public void testSolution() {
        StrobogrammaticNumber.Solution sol = new StrobogrammaticNumber().new Solution();
        assertTrue(sol.isStrobogrammatic("69"));
        assertTrue(sol.isStrobogrammatic("88"));
        assertTrue(sol.isStrobogrammatic("818"));
        assertFalse(sol.isStrobogrammatic("7"));
    }

    @Test
    public void testSolution2() {
        StrobogrammaticNumber.Solution_2 sol = new StrobogrammaticNumber().new Solution_2();
        List<String> res = sol.findStrobogrammatic(2);
        assertEquals(4, res.size());
        assertTrue(res.contains("11"));
        assertTrue(res.contains("69"));
        assertTrue(res.contains("88"));
        assertTrue(res.contains("96"));
    }

    @Test
    public void testSolution3() {
        StrobogrammaticNumber.Solution_3 sol = new StrobogrammaticNumber().new Solution_3();
        int res = sol.strobogrammaticInRange("50", "100");
        assertEquals(3, res);
    }

}
