package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ThreeSumClosestTests {

    @Test
    public void testSolution() {
        ThreeSumClosest.Solution sol = new ThreeSumClosest().new Solution();
        int[] nums = new int[]{-1,2,1,-4};
        int target = 2;
        assertEquals(2, sol.threeSumClosest(nums, target));
    }

}
