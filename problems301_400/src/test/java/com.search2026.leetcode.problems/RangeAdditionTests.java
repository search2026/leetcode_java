package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RangeAdditionTests {

    @Test
    public void testSolution() {
        RangeAddition.Solution sol = new RangeAddition().new Solution();
        int length = 5;
        int[][] updates = {
                {1, 3, 2},
                {2, 4, 3},
                {0, 2, -2}
        };
        int[] increased = sol.getModifiedArray(length, updates);
        int[] expected = {-2, 0, 3, 5, 3};
        assertArrayEquals(expected, increased);
    }

    @Test
    public void testSolution2() {
        RangeAddition.Solution_2 sol = new RangeAddition().new Solution_2();
        int length = 5;
        int[][] updates = {
                {1, 3, 2},
                {2, 4, 3},
                {0, 2, -2}
        };
        int[] increased = sol.getModifiedArray(length, updates);
        int[] expected = {-2, 0, 3, 5, 3};
        assertArrayEquals(expected, increased);
    }

}
