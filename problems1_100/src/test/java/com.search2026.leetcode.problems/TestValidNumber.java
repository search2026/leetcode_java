package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestValidNumber {

    @Test
    public void test1() {
        ValidNumber.Solution sol = new ValidNumber().new Solution();
        assertTrue(sol.isNumber("0"));
        assertTrue(sol.isNumber(" 0.1"));
        assertFalse(sol.isNumber("abc"));
        assertFalse(sol.isNumber("1 a"));
        assertTrue(sol.isNumber("2e10"));
        assertTrue(sol.isNumber("20.355E-235"));
    }

    @Test
    public void test2() {
        ValidNumber.Solution_2 sol = new ValidNumber().new Solution_2();
        assertTrue(sol.isNumber("0"));
        assertTrue(sol.isNumber(" 0.1"));
        assertFalse(sol.isNumber("abc"));
        assertFalse(sol.isNumber("1 a"));
        assertTrue(sol.isNumber("2e10"));
        assertTrue(sol.isNumber("20.355E-235"));
    }

    @Test
    public void test3() {
        ValidNumber.Solution_3 sol = new ValidNumber().new Solution_3();
        assertTrue(sol.isNumber("0"));
        assertTrue(sol.isNumber(" 0.1"));
        assertFalse(sol.isNumber("abc"));
        assertFalse(sol.isNumber("1 a"));
        assertTrue(sol.isNumber("2e10"));
        assertTrue(sol.isNumber("20.355E-235"));
    }

}
