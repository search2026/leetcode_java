package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DifferentWaysToAddParenthesesTests {

    @Test
    public void testSolution() {
        DifferentWaysToAddParentheses.Solution sol = new DifferentWaysToAddParentheses().new Solution();
        List<Integer> res = sol.diffWaysToCompute("2-1-1");
        assertEquals(2, res.size());

        res = sol.diffWaysToCompute("2*3-4*5");
        assertEquals(5, res.size());
    }

}
