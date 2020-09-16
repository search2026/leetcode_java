package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MedianOfTwoSortedArraysTests {

    @Test
    public void testSolution() {
        MedianOfTwoSortedArrays.Solution s = new MedianOfTwoSortedArrays().new Solution();
        double expected = s.findMedianSortedArrays(new int[]{3, 4}, new int[]{1, 2});
        assertEquals(2.5, expected, 1E-5);
        expected = s.findMedianSortedArrays(new int[]{3, 4}, new int[]{1, 2, 5});
        assertEquals(3.0, expected, 1E-5);
    }

    @Test
    public void testSolution2() {
        MedianOfTwoSortedArrays.Solution_2 s = new MedianOfTwoSortedArrays().new Solution_2();
        double expected = s.findMedianSortedArrays(new int[]{3, 4}, new int[]{1, 2});
        assertEquals(2.5, expected, 1E-5);
        expected = s.findMedianSortedArrays(new int[]{3, 4}, new int[]{1, 2, 5});
        assertEquals(3.0, expected, 1E-5);
    }

}
