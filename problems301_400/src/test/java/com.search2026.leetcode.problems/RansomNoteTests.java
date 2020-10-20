package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RansomNoteTests {

    @Test
    public void testSolution() {
        RansomNote.Solution sol = new RansomNote().new Solution();
        assertFalse(sol.canConstruct("a", "b"));
        assertFalse(sol.canConstruct("aa", "ab"));
        assertTrue(sol.canConstruct("aa", "aab"));
    }

}
