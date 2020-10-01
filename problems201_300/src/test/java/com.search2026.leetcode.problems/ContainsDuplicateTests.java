package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContainsDuplicateTests {

    @Test
    public void testSolution() {
        ContainsDuplicate.Solution sol = new ContainsDuplicate().new Solution();
        int[] nums = {1, 9, 21, 18, -5};
        assertFalse(sol.containsDuplicate(nums));
        nums = new int[]{1, 9, 21, 18, -5, 7, 21, 3};
        assertTrue(sol.containsDuplicate(nums));
    }

    @Test
    public void testSolution2() {
        ContainsDuplicate.Solution_2 sol = new ContainsDuplicate().new Solution_2();
        int[] nums = {1, 9, 21, 18, -5, 7, 21, 3};
        assertTrue(sol.containsNearbyDuplicate(nums, 10));
        assertFalse(sol.containsNearbyDuplicate(nums, 2));
    }

    @Test
    public void testSolution3() {
        ContainsDuplicate.Solution_3 sol = new ContainsDuplicate().new Solution_3();
        int[] nums = {1, 9, 21, 18, -5, 7, 21, 3};
        assertTrue(sol.containsNearbyAlmostDuplicate(nums, 10, 2));
        assertFalse(sol.containsNearbyAlmostDuplicate(nums, 2, 2));
    }

    @Test
    public void testSolution4() {
        ContainsDuplicate.Solution_4 sol = new ContainsDuplicate().new Solution_4();
        int[] nums = {1, 9, 21, 18, -5, 7, 21, 3};
        assertTrue(sol.containsNearbyAlmostDuplicate(nums, 10, 2));
        assertFalse(sol.containsNearbyAlmostDuplicate(nums, 2, 2));
    }

}
