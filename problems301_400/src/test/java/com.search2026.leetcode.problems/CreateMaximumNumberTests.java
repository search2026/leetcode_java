package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreateMaximumNumberTests {

    @Test
    public void testSolution() {
        CreateMaximumNumber.Solution sol = new CreateMaximumNumber().new Solution();
        int[] nums1 = {3, 4, 6, 5};
        int[] nums2 = {9, 1, 2, 5, 8, 3};
        int[] res = sol.maxNumber(nums1, nums2, 5);
        assertArrayEquals(new int[]{9, 8, 6, 5, 3}, res);

        nums1 = new int[]{6, 7};
        nums2 = new int[]{6, 0, 4};
        res = sol.maxNumber(nums1, nums2, 5);
        assertArrayEquals(new int[]{6, 7, 6, 0, 4}, res);

        nums1 = new int[]{3, 9};
        nums2 = new int[]{8, 9};
        res = sol.maxNumber(nums1, nums2, 3);
        assertArrayEquals(new int[]{9, 8, 9}, res);
    }

}
