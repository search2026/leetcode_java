package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestTwoSum {

    @Test
    public void test1() {
        TwoSum.Solution sol = new TwoSum().new Solution();
        int[] test = {5, 75, 25};
        assertArrayEquals(new int[]{1, 2}, sol.twoSum(test, 100));
        assertArrayEquals(null, sol.twoSum(test, 99));
    }

    @Test
    public void test2() {
        TwoSum.Solution_2 sol = new TwoSum().new Solution_2();
        int[] test = {5, 25, 75};
        assertArrayEquals(new int[]{2, 3}, sol.twoSum(test, 100));
        assertArrayEquals(null, sol.twoSum(test, 99));
    }

    @Test
    public void test3() {
        TwoSum.TwoSumDS sol = new TwoSum().new TwoSumDS();
        sol.add(1);
        sol.add(3);
        sol.add(5);
        sol.add(4);
        assertTrue(sol.find(4));
        assertTrue(sol.find(7));
        assertFalse(sol.find(10));
    }

}
