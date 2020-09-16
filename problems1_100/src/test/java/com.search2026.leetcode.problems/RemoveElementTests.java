package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RemoveElementTests {

    @Test
    public void testSolution() {
        RemoveElement.Solution sol = new RemoveElement().new Solution();
        int[] nums = new int[]{3, 2, 2, 3};
        assertEquals(2, sol.removeElement(nums, 3));
        nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        assertEquals(5, sol.removeElement(nums, 2));
    }

}
