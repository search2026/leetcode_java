package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FindFirstAndLastPositionOfElementInSortedArrayTests {

    @Test
    public void testSolution() {
        FindFirstAndLastPositionOfElementInSortedArray.Solution sol =
                new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        int[] test = {0, 0, 0, 2, 5, 5, 6, 7, 7};
        int[] range = sol.searchRange(test, 0);
        assertEquals(range[0], 0);
        assertEquals(range[1], 2);

        range = sol.searchRange(test, 2);
        assertEquals(range[0], 3);
        assertEquals(range[1], 3);

        range = sol.searchRange(test, 4);
        assertEquals(range[0], -1);
        assertEquals(range[1], -1);

        range = sol.searchRange(test, 5);
        assertEquals(range[0], 4);
        assertEquals(range[1], 5);

        range = sol.searchRange(test, 7);
        assertEquals(range[0], 7);
        assertEquals(range[1], 8);
    }

    @Test
    public void testSolution2() {
        FindFirstAndLastPositionOfElementInSortedArray.Solution_2 sol =
                new FindFirstAndLastPositionOfElementInSortedArray().new Solution_2();
        int[] test = {0, 0, 0, 2, 5, 5, 6, 7, 7};
        int[] range = sol.searchRange(test, 0);
        assertEquals(range[0], 0);
        assertEquals(range[1], 2);

        range = sol.searchRange(test, 2);
        assertEquals(range[0], 3);
        assertEquals(range[1], 3);

        range = sol.searchRange(test, 4);
        assertEquals(range[0], -1);
        assertEquals(range[1], -1);

        range = sol.searchRange(test, 5);
        assertEquals(range[0], 4);
        assertEquals(range[1], 5);

        range = sol.searchRange(test, 7);
        assertEquals(range[0], 7);
        assertEquals(range[1], 8);
    }

    @Test
    public void testSolution3() {
        FindFirstAndLastPositionOfElementInSortedArray.Solution_3 sol =
                new FindFirstAndLastPositionOfElementInSortedArray().new Solution_3();
        int[] test = {0, 0, 0, 2, 5, 5, 6, 7, 7};
        int[] range = sol.searchRange(test, 0);
        assertEquals(range[0], 0);
        assertEquals(range[1], 2);

        range = sol.searchRange(test, 2);
        assertEquals(range[0], 3);
        assertEquals(range[1], 3);

        range = sol.searchRange(test, 4);
        assertEquals(range[0], -1);
        assertEquals(range[1], -1);

        range = sol.searchRange(test, 5);
        assertEquals(range[0], 4);
        assertEquals(range[1], 5);

        range = sol.searchRange(test, 7);
        assertEquals(range[0], 7);
        assertEquals(range[1], 8);
    }

    @Test
    public void testSolution4() {
        FindFirstAndLastPositionOfElementInSortedArray.Solution_4 sol =
                new FindFirstAndLastPositionOfElementInSortedArray().new Solution_4();
        int[] test = {0, 0, 0, 2, 5, 5, 6, 7, 7};
        int[] range = sol.searchRange(test, 0);
        assertEquals(range[0], 0);
        assertEquals(range[1], 2);

        range = sol.searchRange(test, 2);
        assertEquals(range[0], 3);
        assertEquals(range[1], 3);

        range = sol.searchRange(test, 4);
        assertEquals(range[0], -1);
        assertEquals(range[1], -1);

        range = sol.searchRange(test, 5);
        assertEquals(range[0], 4);
        assertEquals(range[1], 5);

        range = sol.searchRange(test, 7);
        assertEquals(range[0], 7);
        assertEquals(range[1], 8);
    }

}
