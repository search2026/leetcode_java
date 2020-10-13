package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PartitionEqualSubsetSumTests {

    @Test
    public void testSolution() {
        PartitionEqualSubsetSum.Solution sol = new PartitionEqualSubsetSum().new Solution();
        int[] nums = new int[]{1, 5, 11, 5};
        assertTrue(sol.canPartition(nums));
        nums = new int[]{1, 2, 3, 5};
        assertFalse(sol.canPartition(nums));
    }

    @Test
    public void testSolution2() {
        PartitionEqualSubsetSum.Solution_2 sol = new PartitionEqualSubsetSum().new Solution_2();
        int[] nums = new int[]{1, 5, 11, 5};
        assertTrue(sol.canPartition(nums));
        nums = new int[]{1, 2, 3, 5};
        assertFalse(sol.canPartition(nums));
    }

}
