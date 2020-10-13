package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegerBreakTests {

    @Test
    public void test1() {
        IntegerBreak.Solution sol = new IntegerBreak().new Solution();
        assertEquals(1, sol.integerBreak(2));
        assertEquals(2, sol.integerBreak(3));
        assertEquals(4, sol.integerBreak(4));
        assertEquals(6, sol.integerBreak(5));
        assertEquals(9, sol.integerBreak(6));
        assertEquals(12, sol.integerBreak(7));
        assertEquals(18, sol.integerBreak(8));
        assertEquals(27, sol.integerBreak(9));
        assertEquals(36, sol.integerBreak(10));
    }

    @Test
    public void test2() {
        IntegerBreak.Solution_2 sol = new IntegerBreak().new Solution_2();
        assertEquals(1, sol.integerBreak(2));
        assertEquals(2, sol.integerBreak(3));
        assertEquals(4, sol.integerBreak(4));
        assertEquals(6, sol.integerBreak(5));
        assertEquals(9, sol.integerBreak(6));
        assertEquals(12, sol.integerBreak(7));
        assertEquals(18, sol.integerBreak(8));
        assertEquals(27, sol.integerBreak(9));
        assertEquals(36, sol.integerBreak(10));
    }

}
