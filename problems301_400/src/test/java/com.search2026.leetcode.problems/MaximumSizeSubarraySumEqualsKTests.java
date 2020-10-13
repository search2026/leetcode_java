package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumSizeSubarraySumEqualsKTests {

    @Test
    public void testSolution() {
        MaximumSizeSubarraySumEqualsK.Solution sol = new MaximumSizeSubarraySumEqualsK().new Solution();
        assertEquals(4, sol.maxSubArrayLen(new int[]{1, -1, 5, -2, 3}, 3));
        assertEquals(2, sol.maxSubArrayLen(new int[]{-2, -1, 2, 1}, 1));
    }

}
