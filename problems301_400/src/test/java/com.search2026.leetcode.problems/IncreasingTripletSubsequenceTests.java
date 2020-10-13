package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IncreasingTripletSubsequenceTests {

    @Test
    public void testSolution() {
        IncreasingTripletSubsequence.Solution sol = new IncreasingTripletSubsequence().new Solution();
        assertTrue(sol.increasingTriplet(new int[]{1, 2, 3, 4, 5}));
        assertFalse(sol.increasingTriplet(new int[]{5, 4, 3, 2, 1}));
        assertTrue(sol.increasingTriplet(new int[]{1, 7, 3, 5}));
        assertFalse(sol.increasingTriplet(new int[]{5, 6, 2, 3}));
        assertFalse(sol.increasingTriplet(new int[]{1, 7, 3, 2}));
        assertTrue(sol.increasingTriplet(new int[]{5, 6, 5, 7}));
        assertTrue(sol.increasingTriplet(new int[]{1, 0, 0, 0, 0, 10, 0, 0, 1000}));
        assertFalse(sol.increasingTriplet(new int[]{1, 2, 1, 2, 1, 1, 2}));
        assertTrue(sol.increasingTriplet(new int[]{1, 2, -10, -8, -7}));
    }

    @Test
    public void testSolution2() {
        IncreasingTripletSubsequence.Solution sol = new IncreasingTripletSubsequence().new Solution();
        assertTrue(sol.increasingTriplet(new int[]{1, 2, 3, 4, 5}));
        assertFalse(sol.increasingTriplet(new int[]{5, 4, 3, 2, 1}));
        assertTrue(sol.increasingTriplet(new int[]{1, 7, 3, 5}));
        assertFalse(sol.increasingTriplet(new int[]{5, 6, 2, 3}));
        assertFalse(sol.increasingTriplet(new int[]{1, 7, 3, 2}));
        assertTrue(sol.increasingTriplet(new int[]{5, 6, 5, 7}));
        assertTrue(sol.increasingTriplet(new int[]{1, 0, 0, 0, 0, 10, 0, 0, 1000}));
        assertFalse(sol.increasingTriplet(new int[]{1, 2, 1, 2, 1, 1, 2}));
        assertTrue(sol.increasingTriplet(new int[]{1, 2, -10, -8, -7}));
    }

}
