package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountOfSmallerNumbersAfterSelfTests {

    @Test
    public void testSolution() {
        CountOfSmallerNumbersAfterSelf.Solution sol = new CountOfSmallerNumbersAfterSelf().new Solution();
        int[] nums = {5, 2, 6, 1};
        List<Integer> res = sol.countSmaller(nums);
        assertEquals(4, res.size());
        assertEquals(2, res.get(0));
        assertEquals(1, res.get(1));
        assertEquals(1, res.get(2));
        assertEquals(0, res.get(3));
    }

    @Test
    public void testSolution2() {
        CountOfSmallerNumbersAfterSelf.Solution_2 sol = new CountOfSmallerNumbersAfterSelf().new Solution_2();
        int[] nums = {5, 2, 6, 1};
        List<Integer> res = sol.countSmaller(nums);
        assertEquals(4, res.size());
        assertEquals(2, res.get(0));
        assertEquals(1, res.get(1));
        assertEquals(1, res.get(2));
        assertEquals(0, res.get(3));
    }

    @Test
    public void testSolution3() {
        CountOfSmallerNumbersAfterSelf.Solution_3 sol = new CountOfSmallerNumbersAfterSelf().new Solution_3();
        int[] nums = {5, 2, 6, 1};
        List<Integer> res = sol.countSmaller(nums);
        assertEquals(4, res.size());
        assertEquals(2, res.get(0));
        assertEquals(1, res.get(1));
        assertEquals(1, res.get(2));
        assertEquals(0, res.get(3));
    }

}
