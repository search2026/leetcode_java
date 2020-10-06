package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ExpressionAddOperatorsTests {

    @Test
    public void testSolution() {
        ExpressionAddOperators.Solution sol = new ExpressionAddOperators().new Solution();
        List<String> res = sol.addOperators("123", 6);
        assertEquals(2, res.size());
        assertTrue(res.contains("1+2+3"));
        assertTrue(res.contains("1*2*3"));

        res = sol.addOperators("232", 8);
        assertEquals(2, res.size());
        assertTrue(res.contains("2*3+2"));
        assertTrue(res.contains("2+3*2"));

        res = sol.addOperators("105", 5);
        assertEquals(2, res.size());
        assertTrue(res.contains("1*0+5"));
        assertTrue(res.contains("10-5"));

        res = sol.addOperators("00", 0);
        assertEquals(3, res.size());
        assertTrue(res.contains("0+0"));
        assertTrue(res.contains("0-0"));
        assertTrue(res.contains("0*0"));
    }

}
