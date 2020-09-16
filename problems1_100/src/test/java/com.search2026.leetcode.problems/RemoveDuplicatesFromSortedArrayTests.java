package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RemoveDuplicatesFromSortedArrayTests {

    @Test
    public void testSolution() {
        RemoveDuplicatesFromSortedArray.Solution sol = new RemoveDuplicatesFromSortedArray().new Solution();
        int[] nums = {1, 1, 2};
        assertEquals(2, sol.removeDuplicates(nums));
        nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        assertEquals(5, sol.removeDuplicates(nums));
    }

    @Test
    public void testSolution2() {
        RemoveDuplicatesFromSortedArray.Solution_2 sol = new RemoveDuplicatesFromSortedArray().new Solution_2();
        int[] nums = {1,1,1,2,2,3};
        assertEquals(5, sol.removeDuplicates(nums));
        nums = new int[]{0,0,1,1,1,1,2,3,3};
        assertEquals(7, sol.removeDuplicates(nums));
    }

}
