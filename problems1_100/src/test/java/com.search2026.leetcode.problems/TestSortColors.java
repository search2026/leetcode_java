package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestSortColors {

    @Test
    public void test1() {
        SortColors.Solution sol = new SortColors().new Solution();
        int[] nums = {2, 0, 2, 1, 1, 0};
        sol.sortColors(nums);
        assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2}, nums);
    }

}
