package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestIncreasingSubsequenceTests {

    @Test
    public void testSolution() {
        LongestIncreasingSubsequence.Solution sol = new LongestIncreasingSubsequence().new Solution();
        assertEquals(4, sol.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        assertEquals(6, sol.lengthOfLIS(new int[]{2, 5, 3, 7, 11, 8, 10, 13, 6}));
    }

    @Test
    public void testSolution2() {
        LongestIncreasingSubsequence.Solution_2 sol = new LongestIncreasingSubsequence().new Solution_2();
        assertEquals(4, sol.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        assertEquals(6, sol.lengthOfLIS(new int[]{2, 5, 3, 7, 11, 8, 10, 13, 6}));
    }

    @Test
    public void testSolution3() {
        LongestIncreasingSubsequence.Solution_3 sol = new LongestIncreasingSubsequence().new Solution_3();
        assertEquals(4, sol.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        assertEquals(6, sol.lengthOfLIS(new int[]{2, 5, 3, 7, 11, 8, 10, 13, 6}));
    }

    @Test
    public void testSolution4() {
        LongestIncreasingSubsequence.Solution_4 sol = new LongestIncreasingSubsequence().new Solution_4();
        assertEquals(4, sol.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        assertEquals(6, sol.lengthOfLIS(new int[]{2, 5, 3, 7, 11, 8, 10, 13, 6}));
    }

}
