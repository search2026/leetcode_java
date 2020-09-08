package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestValidParentheses {

    @Test
    public void test1() {
        ValidParentheses.Solution sol = new ValidParentheses().new Solution();
        assertTrue(sol.isValid("()"));
        assertTrue(sol.isValid("()[]{}"));
        assertFalse(sol.isValid("("));
        assertFalse(sol.isValid("(]"));
        assertFalse(sol.isValid("([)]"));
    }

    @Test
    public void test2() {
        ValidParentheses.Solution_2 sol = new ValidParentheses().new Solution_2();
        assertTrue(sol.isValid("()"));
        assertTrue(sol.isValid("()[]{}"));
        assertFalse(sol.isValid("(]"));
        assertFalse(sol.isValid("([)]"));
        assertFalse(sol.isValid("("));
    }

    @Test
    public void test3() {
        ValidParentheses.Solution_3 sol = new ValidParentheses().new Solution_3();
        assertTrue(sol.isValid("()"));
        assertTrue(sol.isValid("()[]{}"));
        assertFalse(sol.isValid("(]"));
        assertFalse(sol.isValid("([)]"));
        assertFalse(sol.isValid("("));
    }

}
