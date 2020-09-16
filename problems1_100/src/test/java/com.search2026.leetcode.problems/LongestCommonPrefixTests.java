package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LongestCommonPrefixTests {

    @Test
    public void testSolution() {
        LongestCommonPrefix.Solution sol = new LongestCommonPrefix().new Solution();
        String[] strs = new String[]{"flower", "flow", "flight"};
        assertEquals("fl", sol.longestCommonPrefix(strs));

        strs = new String[]{"dog", "racecar", "car"};
        assertEquals("", sol.longestCommonPrefix(strs));
    }

}
