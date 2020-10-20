package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuperPowTests {

    @Test
    public void testSolution() {
        SuperPow.Solution sol = new SuperPow().new Solution();
        assertEquals(8, sol.superPow(2, new int[]{3}));
        assertEquals(1024, sol.superPow(2, new int[]{1, 0}));
        //assertEquals(1198, sol.superPow((2147483674 % 1337, new int[]{2, 0, 0}));
        assertEquals(426, sol.superPow(797, new int[]{1, 5, 3, 1, 4, 7, 9, 3}));
        assertEquals(660, sol.superPow(3387647, new int[]{5, 5, 5, 4, 7, 9, 3}));
    }

    @Test
    public void testSolution2() {
        SuperPow.Solution_2 sol = new SuperPow().new Solution_2();
        assertEquals(8, sol.superPow(2, new int[]{3}));
        assertEquals(1024, sol.superPow(2, new int[]{1, 0}));
        assertEquals(426, sol.superPow(797, new int[]{1, 5, 3, 1, 4, 7, 9, 3}));
        assertEquals(660, sol.superPow(3387647, new int[]{5, 5, 5, 4, 7, 9, 3}));
    }

}
