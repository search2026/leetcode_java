package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumSizeSubarraySumTests {

    @Test
    public void testSolution() {
        MinimumSizeSubarraySum.Solution sol = new MinimumSizeSubarraySum().new Solution();
        assertEquals(2, sol.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

}
