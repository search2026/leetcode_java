package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MaximumSubarrayTests {

    @Test
    public void testSolution() {
        MaximumSubarray.Solution sol = new MaximumSubarray().new Solution();
        assertEquals(6, sol.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    @Test
    public void testSolution2() {
        MaximumSubarray.Solution_2 sol = new MaximumSubarray().new Solution_2();
        assertEquals(6, sol.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

}
