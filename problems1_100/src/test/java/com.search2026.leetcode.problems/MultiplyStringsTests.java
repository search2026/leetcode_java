package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MultiplyStringsTests {

    @Test
    public void testSolution() {
        MultiplyStrings.Solution sol = new MultiplyStrings().new Solution();
        assertEquals("6", sol.multiply("2", "3"));
        assertEquals("56088", sol.multiply("456", "123"));
    }

}
