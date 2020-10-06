package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WordPatternTests {

    @Test
    public void testSolution() {
        WordPattern.Solution sol = new WordPattern().new Solution();
        assertTrue(sol.wordPattern("abba", "dog cat cat dog"));
        assertFalse(sol.wordPattern("abba", "dog cat cat fish"));
        assertFalse(sol.wordPattern("aaaa", "dog cat cat dog"));
    }

}
