package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestNextPermutation {

    @Test
    public void test1() {
        NextPermutation.Solution sol = new NextPermutation().new Solution();
        int[] start = new int[]{6, 8, 7, 4, 3, 2};
        int[] next = new int[]{7, 2, 3, 4, 6, 8};
        sol.nextPermutation(start);
        for (int i = 0; i < start.length; i++) {
            assertEquals(start[i], next[i]);
        }
    }
}
