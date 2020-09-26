package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FactorialTrailingZeroesTests {

    @Test
    public void testSolution() {
        FactorialTrailingZeroes.Solution sol = new FactorialTrailingZeroes().new Solution();
        assertEquals(0, sol.trailingZeroes(3));
        assertEquals(1, sol.trailingZeroes(5));
        assertEquals(0, sol.trailingZeroes(0));
    }

}
