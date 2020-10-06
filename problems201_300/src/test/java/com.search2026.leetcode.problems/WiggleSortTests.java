package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WiggleSortTests {

    @Test
    public void testSolution() {
        WiggleSort.Solution sol = new WiggleSort().new Solution();
        int[] nums = {3, 5, 2, 1, 6, 4};
        sol.wiggleSort(nums);
        assertEquals(6, nums.length);
        // Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
        boolean smaller = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (smaller) {
                assertTrue(nums[i] <= nums[i + 1]);
            } else {
                assertTrue(nums[i] >= nums[i + 1]);
            }
            smaller = !smaller;
        }
    }


    @Test
    public void testSolution2() {
        WiggleSort.Solution_2 sol = new WiggleSort().new Solution_2();
        int[] nums = {1, 5, 1, 1, 6, 4};
        sol.wiggleSort(nums);
        assertEquals(6, nums.length);
        // Given an unsorted array nums, reorder it in-place such that nums[0] < nums[1] > nums[2] < nums[3]....
        boolean smaller = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (smaller) {
                assertTrue(nums[i] < nums[i + 1]);
            } else {
                assertTrue(nums[i] > nums[i + 1]);
            }
            smaller = !smaller;
        }
    }

}
