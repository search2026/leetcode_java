package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MinimumSwapsToMakeSequencesIncreasingTests {

    @Test
    public void testSolution() {
        MinimumSwapsToMakeSequencesIncreasing.Solution sol = new MinimumSwapsToMakeSequencesIncreasing().new Solution();
        assertEquals(1, sol.minSwap(new int[]{1,3,5,4}, new int[]{1,2,3,7}));
    }

}
