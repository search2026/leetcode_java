package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IsomorphicStringsTests {

    @Test
    public void test1() {
        IsomorphicStrings.Solution sol = new IsomorphicStrings().new Solution();
        assertTrue(sol.isIsomorphic("egg", "add"));
        assertFalse(sol.isIsomorphic("foo", "bar"));
        assertTrue(sol.isIsomorphic("paper", "title"));
    }

}
