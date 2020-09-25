package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MaximumGapTests {

    @Test
    public void testSolution() {
        MaximumGap.Solution sol = new MaximumGap().new Solution();
        int[] nums = {3,6,9,1};
        assertEquals(3, sol.maximumGap(nums));
        nums = new int[]{10};
        assertEquals(0, sol.maximumGap(nums));
    }

}
