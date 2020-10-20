package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UTF8ValidationTests {

    @Test
    public void testSolution() {
        UTF8Validation.Solution sol = new UTF8Validation().new Solution();
        int[] data = {197, 130, 1};
        assertTrue(sol.validUtf8(data));
        data = new int[]{235, 140, 4};
        assertFalse(sol.validUtf8(data));
    }

    @Test
    public void testSolution2() {
        UTF8Validation.Solution_2 sol = new UTF8Validation().new Solution_2();
        int[] data = {197, 130, 1};
        assertTrue(sol.validUtf8(data));
        data = new int[]{235, 140, 4};
        assertFalse(sol.validUtf8(data));
    }

}
