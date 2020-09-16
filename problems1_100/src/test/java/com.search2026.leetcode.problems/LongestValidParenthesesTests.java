package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LongestValidParenthesesTests {

    @Test
    public void testSolution() {
        LongestValidParentheses.Solution sol = new LongestValidParentheses().new Solution();
        assertEquals(2, sol.longestValidParentheses("(()"));
        assertEquals(4, sol.longestValidParentheses(")()())"));
    }

}
