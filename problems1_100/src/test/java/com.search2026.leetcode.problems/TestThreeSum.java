package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestThreeSum {

    @Test
    public void test1() {
        ThreeSum.Solution sol = new ThreeSum().new Solution();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = sol.threeSum(nums);
        assertEquals(2, res.size());
        assertEquals(3, res.get(0).size());
        assertEquals(-1, res.get(0).get(0));
        assertEquals(-1, res.get(0).get(1));
        assertEquals(2, res.get(0).get(2));
        assertEquals(3, res.get(1).size());
        assertEquals(-1, res.get(1).get(0));
        assertEquals(0, res.get(1).get(1));
        assertEquals(1, res.get(1).get(2));

        nums = new int[]{0};
        res = sol.threeSum(nums);
        assertEquals(0, res.size());
    }
}
