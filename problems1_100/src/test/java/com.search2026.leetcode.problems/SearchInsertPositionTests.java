package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SearchInsertPositionTests {

    @Test
    public void testSolution() {
        SearchInsertPosition.Solution sol = new SearchInsertPosition().new Solution();
        assertEquals(2, sol.searchInsert(new int[]{1, 3, 5, 6}, 5));
        assertEquals(1, sol.searchInsert(new int[]{1, 3, 5, 6}, 2));
        assertEquals(4, sol.searchInsert(new int[]{1, 3, 5, 6}, 7));
        assertEquals(0, sol.searchInsert(new int[]{1, 3, 5, 6}, 0));
    }

}
