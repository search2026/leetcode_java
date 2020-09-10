package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPlusOne {

    @Test
    public void test1() {
        PlusOne.Solution sol = new PlusOne().new Solution();
        assertArrayEquals(sol.plusOne(new int[]{9, 9, 8}), new int[]{9, 9, 9});
        assertArrayEquals(sol.plusOne(new int[]{9, 9, 9}), new int[]{1, 0, 0, 0});
    }

}
