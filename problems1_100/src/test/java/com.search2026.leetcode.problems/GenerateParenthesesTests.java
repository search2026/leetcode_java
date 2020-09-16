package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GenerateParenthesesTests {

    @Test
    public void testSolution() {
        GenerateParentheses.Solution sol = new GenerateParentheses().new Solution();
        List<String> res = sol.generateParenthesis(3);
        assertEquals(5, res.size());
        assertTrue(res.contains("((()))"));
        assertTrue(res.contains("(()())"));
        assertTrue(res.contains("(())()"));
        assertTrue(res.contains("()(())"));
        assertTrue(res.contains("()()()"));
    }

    @Test
    public void testSolution2() {
        GenerateParentheses.Solution_2 sol = new GenerateParentheses().new Solution_2();
        List<String> res = sol.generateParenthesis(3);
        assertEquals(5, res.size());
        assertTrue(res.contains("((()))"));
        assertTrue(res.contains("(()())"));
        assertTrue(res.contains("(())()"));
        assertTrue(res.contains("()(())"));
        assertTrue(res.contains("()()()"));
    }

}
