package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestSubsets {

    @Test
    public void test1() {
        Subsets.Solution sol = new Subsets().new Solution();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> res = sol.subsets(nums);
        assertEquals(8, res.size());
    }

    @Test
    public void test2() {
        Subsets.Solution_2 sol = new Subsets().new Solution_2();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> res = sol.subsets(nums);
        assertEquals(8, res.size());
    }

    @Test
    public void test3() {
        Subsets.Solution_3 sol = new Subsets().new Solution_3();
        int[] nums = new int[]{1, 2, 2};
        List<List<Integer>> res = sol.subsetsWithDup(nums);
        assertEquals(6, res.size());
    }

    @Test
    public void test4() {
        Subsets.Solution_4 sol = new Subsets().new Solution_4();
        int[] nums = new int[]{1, 2, 2};
        List<List<Integer>> res = sol.subsetsWithDup(nums);
        assertEquals(6, res.size());
    }

}
