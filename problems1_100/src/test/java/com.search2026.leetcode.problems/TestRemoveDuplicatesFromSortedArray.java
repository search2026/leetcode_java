package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestRemoveDuplicatesFromSortedArray {

    @Test
    public void test1() {
        RemoveDuplicatesFromSortedArray.Solution sol = new RemoveDuplicatesFromSortedArray().new Solution();
        int[] nums = new int[]{1, 1, 2};
        assertEquals(2, sol.removeDuplicates(nums));
        nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        assertEquals(5, sol.removeDuplicates(nums));
    }

}
