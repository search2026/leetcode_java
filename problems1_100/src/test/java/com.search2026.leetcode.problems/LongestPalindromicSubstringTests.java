package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LongestPalindromicSubstringTests {

    @Test
    public void testSolution() {
        LongestPalindromicSubstring.Solution sol = new LongestPalindromicSubstring().new Solution();
        assertEquals("a", sol.longestPalindrome("a"));
        assertEquals("aaaaaa", sol.longestPalindrome("aaaaaa"));
        assertEquals("aaaa", sol.longestPalindrome("aaaabb"));
    }

    @Test
    public void testSolution2() {
        LongestPalindromicSubstring.Solution_2 sol = new LongestPalindromicSubstring().new Solution_2();
        assertEquals("a", sol.longestPalindrome("a"));
        assertEquals("aaaaaa", sol.longestPalindrome("aaaaaa"));
        assertEquals("aaaa", sol.longestPalindrome("aaaabb"));
    }

    @Test
    public void testSolution3() {
        LongestPalindromicSubstring.Solution_3 sol = new LongestPalindromicSubstring().new Solution_3();
        assertEquals("a", sol.longestPalindrome("a"));
        assertEquals("aaaaaa", sol.longestPalindrome("aaaaaa"));
        assertEquals("aaaa", sol.longestPalindrome("aaaabb"));
    }

}
