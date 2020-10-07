package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UniqueWordAbbreviationTests {

    @Test
    public void testSolution() {
        String[] dict = {"deer", "door", "cake", "card"};
        UniqueWordAbbreviation.ValidWordAbbr sol = new UniqueWordAbbreviation().new ValidWordAbbr(dict);
        assertFalse(sol.isUnique("dear"));
        assertTrue(sol.isUnique("cart"));
        assertFalse(sol.isUnique("cane"));
        assertTrue(sol.isUnique("make"));
    }

}
