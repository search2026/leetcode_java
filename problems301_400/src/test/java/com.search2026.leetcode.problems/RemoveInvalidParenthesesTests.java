package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RemoveInvalidParenthesesTests {

    @Test
    public void testSolution() {
        RemoveInvalidParentheses.Solution sol = new RemoveInvalidParentheses().new Solution();
        List<String> res = sol.removeInvalidParentheses("()())()");
        assertEquals(2, res.size());
        assertTrue(res.contains("()()()"));
        assertTrue(res.contains("(())()"));

        res = sol.removeInvalidParentheses("(a)())()");
        assertEquals(2, res.size());
        assertTrue(res.contains("(a)()()"));
        assertTrue(res.contains("(a())()"));

        res = sol.removeInvalidParentheses(")(");
        assertEquals(1, res.size());
        assertEquals("", res.get(0));

        res = sol.removeInvalidParentheses(")()");
        assertEquals(1, res.size());
        assertEquals("()", res.get(0));
    }

    @Test
    public void testSolution2() {
        RemoveInvalidParentheses.Solution_2 sol = new RemoveInvalidParentheses().new Solution_2();
        List<String> res = sol.removeInvalidParentheses("()())()");
        assertEquals(2, res.size());
        assertTrue(res.contains("()()()"));
        assertTrue(res.contains("(())()"));

        res = sol.removeInvalidParentheses("(a)())()");
        assertEquals(2, res.size());
        assertTrue(res.contains("(a)()()"));
        assertTrue(res.contains("(a())()"));

        res = sol.removeInvalidParentheses(")(");
        assertEquals(1, res.size());
        assertEquals("", res.get(0));

        res = sol.removeInvalidParentheses(")()");
        assertEquals(1, res.size());
        assertEquals("()", res.get(0));
    }

}
