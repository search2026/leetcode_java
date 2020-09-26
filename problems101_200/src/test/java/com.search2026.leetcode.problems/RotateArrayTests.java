package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RotateArrayTests {

    @Test
    public void testSolution() {
        RotateArray.Solution sol = new RotateArray().new Solution();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int[] expected = {5, 6, 7, 1, 2, 3, 4};
        sol.rotate(nums, 3);
        assertArrayEquals(expected, nums);

        nums = new int[]{-1, -100, 3, 99};
        expected = new int[]{3, 99, -1, -100};
        sol.rotate(nums, 2);
        assertArrayEquals(expected, nums);
    }

}
