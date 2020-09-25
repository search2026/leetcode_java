package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumProductSubarrayTests {

    @Test
    public void testSolution() {
        MaximumProductSubarray.Solution s = new MaximumProductSubarray().new Solution();
        assertEquals(12, s.maxProduct(new int[]{-4, -3, -2}));
        assertEquals(6, s.maxProduct(new int[]{2, 3, -2, 4}));
        assertEquals(48, s.maxProduct(new int[]{2, 3, -2, -4}));
    }

}
