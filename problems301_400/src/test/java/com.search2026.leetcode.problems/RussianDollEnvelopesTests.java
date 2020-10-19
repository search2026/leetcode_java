package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RussianDollEnvelopesTests {

    @Test
    public void testSolution() {
        RussianDollEnvelopes.Solution sol = new RussianDollEnvelopes().new Solution();
        int[][] test1 = {
                {5, 4},
                {6, 4},
                {6, 7},
                {2, 3}
        };
        assertEquals(3, sol.maxEnvelopes(test1));

        int[][] test2 = {
                {4, 5},
                {4, 6},
                {6, 7},
                {2, 3},
                {1, 1}
        };
        assertEquals(4, sol.maxEnvelopes(test2));
    }

    @Test
    public void testSolution2() {
        RussianDollEnvelopes.Solution_2 sol = new RussianDollEnvelopes().new Solution_2();
        int[][] test1 = {
                {5, 4},
                {6, 4},
                {6, 7},
                {2, 3}
        };
        assertEquals(3, sol.maxEnvelopes(test1));

        int[][] test2 = {
                {4, 5},
                {4, 6},
                {6, 7},
                {2, 3},
                {1, 1}
        };
        assertEquals(4, sol.maxEnvelopes(test2));
    }

    @Test
    public void testSolution3() {
        RussianDollEnvelopes.Solution_3 sol = new RussianDollEnvelopes().new Solution_3();
        int[][] test1 = {
                {5, 4},
                {6, 4},
                {6, 7},
                {2, 3}
        };
        assertEquals(3, sol.maxEnvelopes(test1));

        int[][] test2 = {
                {4, 5},
                {4, 6},
                {6, 7},
                {2, 3},
                {1, 1}
        };
        assertEquals(4, sol.maxEnvelopes(test2));
    }

}
