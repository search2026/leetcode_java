package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestConsecutiveSequenceTests {

    @Test
    public void testSolution() {
        LongestConsecutiveSequence.Solution sol = new LongestConsecutiveSequence().new Solution();
        assertEquals(4, sol.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        assertEquals(2, sol.longestConsecutive(new int[]{1, 2, 5, 6}));
        assertEquals(3, sol.longestConsecutive(new int[]{3, 5, 6, 12, 7}));
        assertEquals(3, sol.longestConsecutive(new int[]{1, 6, 2, 7, 3}));
    }

}
