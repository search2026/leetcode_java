package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddStringsTests {

    @Test
    public void testSolution() {
        AddStrings.Solution sol = new AddStrings().new Solution();
        assertEquals("504", sol.addStrings("415", "89"));
        assertEquals("504", sol.addStrings("89", "415"));
    }

}
