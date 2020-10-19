package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidPerfectSquareTests {

    @Test
    public void testSolution() {
        ValidPerfectSquare.Solution sol = new ValidPerfectSquare().new Solution();
        assertFalse(sol.isPerfectSquare(0));
        assertTrue(sol.isPerfectSquare(1));
        assertFalse(sol.isPerfectSquare(8));
        assertTrue(sol.isPerfectSquare(9));
        assertFalse(sol.isPerfectSquare(10));
        assertFalse(sol.isPerfectSquare(99));
        assertTrue(sol.isPerfectSquare(100));
        assertFalse(sol.isPerfectSquare(101));
        assertFalse(sol.isPerfectSquare(808200));
        assertTrue(sol.isPerfectSquare(808201));
        assertFalse(sol.isPerfectSquare(808202));
        assertFalse(sol.isPerfectSquare(2147483647));
    }

    @Test
    public void testSolution2() {
        ValidPerfectSquare.Solution_2 sol = new ValidPerfectSquare().new Solution_2();
        assertFalse(sol.isPerfectSquare(0));
        assertTrue(sol.isPerfectSquare(1));
        assertFalse(sol.isPerfectSquare(8));
        assertTrue(sol.isPerfectSquare(9));
        assertFalse(sol.isPerfectSquare(10));
        assertFalse(sol.isPerfectSquare(99));
        assertTrue(sol.isPerfectSquare(100));
        assertFalse(sol.isPerfectSquare(101));
        assertFalse(sol.isPerfectSquare(808200));
        assertTrue(sol.isPerfectSquare(808201));
        assertFalse(sol.isPerfectSquare(808202));
        assertFalse(sol.isPerfectSquare(2147483647));
    }

    @Test
    public void testSolution3() {
        ValidPerfectSquare.Solution_3 sol = new ValidPerfectSquare().new Solution_3();
        assertFalse(sol.isPerfectSquare(0));
        assertTrue(sol.isPerfectSquare(1));
        assertFalse(sol.isPerfectSquare(8));
        assertTrue(sol.isPerfectSquare(9));
        assertFalse(sol.isPerfectSquare(10));
        assertFalse(sol.isPerfectSquare(99));
        assertTrue(sol.isPerfectSquare(100));
        assertFalse(sol.isPerfectSquare(101));
        assertFalse(sol.isPerfectSquare(808200));
        assertTrue(sol.isPerfectSquare(808201));
        assertFalse(sol.isPerfectSquare(808202));
        assertFalse(sol.isPerfectSquare(2147483647));
    }

}
