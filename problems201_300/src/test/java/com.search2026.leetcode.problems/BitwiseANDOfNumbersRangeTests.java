package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BitwiseANDOfNumbersRangeTests {

    @Test
    public void testSolution() {
        BitwiseANDOfNumbersRange.Solution sol = new BitwiseANDOfNumbersRange().new Solution();
        assertEquals(4, sol.rangeBitwiseAnd(5, 7));
        assertEquals(0, sol.rangeBitwiseAnd(0, 1));
    }

}
