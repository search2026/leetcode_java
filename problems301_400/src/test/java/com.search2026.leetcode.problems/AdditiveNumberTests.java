package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AdditiveNumberTests {

    @Test
    public void testSolution() {
        AdditiveNumber.Solution sol = new AdditiveNumber().new Solution();
        assertTrue(sol.isAdditiveNumber("112358"));
        assertTrue(sol.isAdditiveNumber("199100199"));
    }

}
