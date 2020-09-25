package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FindPeakElementTests {

    @Test
    public void testSolution() {
        FindPeakElement.Solution sol = new FindPeakElement().new Solution();
        int[] nums = {1, 2, 3, 1};
        assertEquals(2, sol.findPeakElement(nums));
        nums = new int[]{1, 2, 1, 3, 5, 6, 4};
        assertEquals(1, sol.findPeakElement(nums));
    }

}
