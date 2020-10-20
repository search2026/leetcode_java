package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IsSubsequenceTests {

    @Test
    public void testSolution() {
        IsSubsequence.Solution sol = new IsSubsequence().new Solution();
        assertTrue(sol.isSubsequence("abc", "ahbgdc"));
        assertFalse(sol.isSubsequence("axc", "ahbgdc"));
    }

}
