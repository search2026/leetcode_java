package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShortestPalindromeTests {

    @Test
    public void testSolution() {
        ShortestPalindrome.Solution sol = new ShortestPalindrome().new Solution();
        assertEquals("aaacecaaa", sol.shortestPalindrome("aacecaaa"));
        assertEquals("dcbabcd", sol.shortestPalindrome("abcd"));
    }

}
