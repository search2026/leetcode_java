package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestInterleavingString {

    @Test
    public void test1() {
        InterleavingString.Solution sol = new InterleavingString().new Solution();
        assertTrue(sol.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        assertFalse(sol.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }

}
