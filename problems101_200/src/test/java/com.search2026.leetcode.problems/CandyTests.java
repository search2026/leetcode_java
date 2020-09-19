package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CandyTests {

    @Test
    public void testSolution() {
        Candy.Solution sol = new Candy().new Solution();
        assertEquals(5, sol.candy(new int[]{1, 0, 2}));
        assertEquals(4, sol.candy(new int[]{1, 2, 2}));
    }

}
