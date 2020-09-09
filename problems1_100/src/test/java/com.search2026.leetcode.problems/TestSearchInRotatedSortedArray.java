package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestSearchInRotatedSortedArray {

    @Test
    public void test1() {
        SearchInRotatedSortedArray.Solution sol = new SearchInRotatedSortedArray().new Solution();
        int[] test = {4, 5, 6, 7, 0, 1, 2};
        assertEquals(-1, sol.search(test, 3));
        assertEquals(0, sol.search(test, 4));
        assertEquals(3, sol.search(test, 7));
        assertEquals(6, sol.search(test, 2));
    }

    @Test
    public void test2() {
        SearchInRotatedSortedArray.Solution_2 sol = new SearchInRotatedSortedArray().new Solution_2();
        int[] test = {4, 5, 6, 7, 7, 0, 1, 2};
        assertFalse(sol.search(test, 3));
        assertTrue(sol.search(test, 4));
        assertTrue(sol.search(test, 7));
        assertTrue(sol.search(test, 2));
        test = new int[]{1, 3};
        assertTrue(sol.search(test, 3));
        assertTrue(sol.search(test, 1));
        assertFalse(sol.search(test, 0));
        assertFalse(sol.search(test, 2));
        assertFalse(sol.search(test, 8));
    }

}
