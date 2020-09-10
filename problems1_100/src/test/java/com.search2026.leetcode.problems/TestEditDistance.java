package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEditDistance {

    @Test
    public void test1() {
        EditDistance.Solution sol = new EditDistance().new Solution();
        assertEquals(sol.minDistance("a", ""), 1);
        assertEquals(sol.minDistance("a", "bcd"), 3);
    }

    @Test
    public void test2() {
        EditDistance.Solution_2 sol2 = new EditDistance().new Solution_2();
        assertEquals(sol2.minDistance("a", ""), 1);
        assertEquals(sol2.minDistance("a", "bcd"), 3);
        assertEquals(sol2.minDistance("a", "bad"), 2);
    }

}
