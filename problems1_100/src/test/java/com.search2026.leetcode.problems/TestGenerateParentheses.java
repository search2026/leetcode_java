package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestGenerateParentheses {

    @Test
    public void test1() {
        GenerateParentheses.Solution sol = new GenerateParentheses().new Solution();
        List<String> res = sol.generateParenthesis(3);
        assertEquals(5, res.size());
        assertTrue(res.contains("((()))"));
        assertTrue(res.contains("(()())"));
        assertTrue(res.contains("(())()"));
        assertTrue(res.contains("()(())"));
        assertTrue(res.contains("()()()"));
    }
}
