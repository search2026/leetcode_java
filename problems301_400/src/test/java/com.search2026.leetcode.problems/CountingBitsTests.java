package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CountingBitsTests {

    @Test
    public void testSolution() {
        CountingBits.Solution sol = new CountingBits().new Solution();
        assertArrayEquals(new int[]{0, 1, 1}, sol.countBits(2));
        assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2}, sol.countBits(5));
    }

}
