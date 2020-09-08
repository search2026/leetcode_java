package com.search2026.leetcode.problems;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestLongestCommonPrefix {

    public static class UnitTest {
        @Test
        public void test1() {
            LongestCommonPrefix.Solution sol = new LongestCommonPrefix().new Solution();
            String[] strs = new String[]{"flower", "flow", "flight"};
            assertEquals("fl", sol.longestCommonPrefix(strs));

            strs = new String[]{"dog", "racecar", "car"};
            assertEquals("", sol.longestCommonPrefix(strs));
        }
    }
}
