package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FindTheDuplicateNumberTests {

    @Test
    public void testSolution() {
        FindTheDuplicateNumber.Solution sol = new FindTheDuplicateNumber().new Solution();
        int[] nums = {4, 1, 5, 2, 3, 1};
        assertEquals(1, sol.findDuplicate(nums));

        nums = new int[]{1, 3, 4, 2, 2};
        assertEquals(2, sol.findDuplicate(nums));

        nums = new int[]{3, 1, 3, 4, 2};
        assertEquals(3, sol.findDuplicate(nums));
    }

}
