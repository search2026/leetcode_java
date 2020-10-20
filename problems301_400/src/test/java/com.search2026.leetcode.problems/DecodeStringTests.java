package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DecodeStringTests {

    @Test
    public void testSolution() {
        DecodeString.Solution sol = new DecodeString().new Solution();
        assertEquals("aaabcbc", sol.decodeString("3[a]2[bc]"));
        assertEquals("accaccacc", sol.decodeString("3[a2[c]]"));
    }

}
