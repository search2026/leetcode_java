package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FourSumTests {

    @Test
    public void testSolution() {
        FourSum.Solution sol = new FourSum().new Solution();
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> res = sol.fourSum(nums, target);
        assertEquals(3, res.size());
    }

}
