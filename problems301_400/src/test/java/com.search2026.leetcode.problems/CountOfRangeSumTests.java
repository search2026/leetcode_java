package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountOfRangeSumTests {

    @Test
    public void testSolution() {
        CountOfRangeSum.Solution sol = new CountOfRangeSum().new Solution();
        assertEquals(3, sol.countRangeSum(new int[]{-2, 5, -1}, -2, 2));
        assertEquals(4, sol.countRangeSum(new int[]{2147483647, -2147483648, -1, 0}, -1, 0));
        assertEquals(2, sol.countRangeSum(new int[]{0, -3, -3, 1, 1, 2}, 3, 5));
        assertEquals(10, sol.countRangeSum(new int[]{-2,0,0,2,2,-2}, -3, 1));
        assertEquals(3, sol.countRangeSum(new int[]{-2147483647,0,-2147483647,2147483647}, -564, 3864));
    }

}
